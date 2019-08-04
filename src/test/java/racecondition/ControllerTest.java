package racecondition;

import gov.nasa.jpf.annotation.JPFConfig;
import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;
import org.junit.Test;
import java.util.concurrent.atomic.AtomicInteger;

//This annotation does not work
@JPFConfig({"listener=+gov.nasa.jpf.listener.PreciseRaceDetector"})
public class ControllerTest extends TestJPF {

    @Test
    public void testRaceCondition() throws InterruptedException {
        //cannot be refactored because TestJPF uses naive method to find the test method to run (second from the call stack) override of that method does not help either because later on JPF uses TestJPF version anyway...

        //the second argument is ignored? it is shown in the output but only addiotion of this line to the jpf.proprties in the project enables PreciseRaceDetector listiner to work
        if (verifyPropertyViolation(new TypeRef("gov.nasa.jpf.listener.PreciseRaceDetector"),"listener=gov.nasa.jpf.listener.PreciseRaceDetector")) {
            Service srv = new NonAtomicService();
            Thread[] threads = new Thread[3];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(() -> {
                    srv.resetValue();
                    srv.incValue();
                    System.out.println(String.format("THREAD: %d CURRENT VALUE: %d",Thread.currentThread().getId(),srv.getValue()));
                });
            }
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
        }
    }


    @Test
    public void testNoRaceCondition() throws InterruptedException {
        if (verifyNoPropertyViolation("listener=gov.nasa.jpf.listener.PreciseRaceDetector")) {
            Service srv = new AtomicService();
            Thread[] threads = new Thread[3];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(() -> {
                    srv.resetValue();
                    srv.incValue();
                    System.out.println(String.format("THREAD: %d CURRENT VALUE: %d",Thread.currentThread().getId(),srv.getValue()));
                });
            }
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
        }
    }

    private static class AtomicService implements Service {

        private AtomicInteger x = new AtomicInteger(0);

        @Override
        public void resetValue() {
            x.set(0);
        }

        @Override
        public void incValue() {
            x.incrementAndGet();
        }

        @Override
        public int getValue() {
            return x.intValue();
        }
    }
}
