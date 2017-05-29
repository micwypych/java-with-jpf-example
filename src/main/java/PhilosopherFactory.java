/**
 * Created by mwypych on 23.05.17.
 */
public class PhilosopherFactory {
    public Philosopher make(Philosopher.Fork left, Philosopher.Fork right) {
        return new Philosopher(left, right);
    }
}
