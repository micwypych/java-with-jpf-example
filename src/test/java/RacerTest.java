import gov.nasa.jpf.annotation.JPFConfig;
import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.*;
import org.junit.Test;

//WARN: this approach does not work
@JPFConfig({"listener+=,gov.nasa.jpf.listener.PreciseRaceDetector,MyListener"})
public class RacerTest extends TestJPF {
    static class Ptr {
        public int value;
    }

    @Test
    public void testRacerWithCustomJpfListener() throws InterruptedException {
        //WARN: this approach does not work neither
        Verify.setProperties("listener+=,gov.nasa.jpf.listener.PreciseRaceDetector");
        Verify.setProperties("listener+=,MyListener");
        //WARN: this approach works correctly so the setting file is looked for
        if (verifyPropertyViolation(new TypeRef("gov.nasa.jpf.listener.PreciseRaceDetector"),"java-with-jpf-example.jpf")) {
            Ptr x = new Ptr();
            x.value = 10;
            Runnable r = () -> {
                System.out.println(10 / x.value);
                x.value = 0;
                x.value++;
                System.out.println(x.value);
            };
            Thread t1 = new Thread(r);
            Thread t2 = new Thread(r);

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }
    }
}
