import gov.nasa.jpf.annotation.JPFConfig;
import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.*;
import org.junit.Test;

//WARN: nie dziala ten sposob dodania listenera
@JPFConfig({"listener+=,gov.nasa.jpf.listener.PreciseRaceDetector,MyListener"})
public class RacerTest extends TestJPF {
    static class Ptr {
        public int value;
    }

    @Test
    public void testRacer() throws InterruptedException {
        //WARN: nie dziala ten sposob dodania listenera
        Verify.setProperties("listener+=,gov.nasa.jpf.listener.PreciseRaceDetector");
        Verify.setProperties("listener+=,MyListener");
        //WARN: dopiero ten sposob dziala
        if (verifyNoPropertyViolation("java-with-jpf-example.jpf")) {
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
