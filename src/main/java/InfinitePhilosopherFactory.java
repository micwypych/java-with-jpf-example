/**
 * Created by mwypych on 23.05.17.
 */
public class InfinitePhilosopherFactory extends PhilosopherFactory {
    @Override
    public Philosopher make(Philosopher.Fork left, Philosopher.Fork right) {
        return new InfinitePhilosopher(left, right);
    }
}
