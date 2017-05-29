import gov.nasa.jpf.util.test.TestJPF;
import org.junit.Test;

/**
 * Created by mwypych on 23.05.17.
 */
public class DiningPhilosophersTest extends TestJPF {
    @Test
    public void catchDeadlock() {
        if (verifyDeadlock()) {
            Philosopher[] table = Philosopher.createTable(5, new PhilosopherFactory());
            for (Philosopher ph : table) {
                new Thread(ph).start();
            }
        }
    }

    @Test
    public void catchDeadlockInInfiniteCase() {
        if (verifyDeadlock()) {
            Philosopher[] table = Philosopher.createTable(5, new InfinitePhilosopherFactory());
            for (Philosopher ph : table) {
                new Thread(ph).start();
            }
        }
    }
}
