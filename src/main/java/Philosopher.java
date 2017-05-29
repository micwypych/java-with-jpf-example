import java.util.Arrays;

/**
 * Created by mwypych on 23.05.17.
 */
public class Philosopher implements Runnable {
    static class Fork {}

    public Philosopher(Fork left, Fork right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        think();
        synchronized (left) {
            synchronized (right) {
                eat();
            }
        }
    }

    private void think() {

    }

    private void eat() {

    }

    private Fork left;
    private Fork right;

    static Philosopher[] createTable(int size, PhilosopherFactory factory) {
        Philosopher[] table = new Philosopher[size];
        Fork[] forks = new Fork[size];
        for (int i=0; i<size; i++) {
            forks[i] = new Fork();
        }
        for (int i=0; i<size; i++) {
            table[i] = factory.make(forks[i],forks[(i+1) % size]);
        }
        return table;
    }

    public static void main(String[] args) {
        createTable(5, new PhilosopherFactory());
    }
}
