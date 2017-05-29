/**
 * Created by mwypych on 23.05.17.
 */
public class InfinitePhilosopher extends Philosopher {

    public InfinitePhilosopher(Fork left, Fork right) {
        super(left, right);
    }

    @Override
    public void run() {
        while (true) {
            super.run();
        }
    }
}
