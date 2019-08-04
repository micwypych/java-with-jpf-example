package racecondition;

public class NonAtomicService implements Service {
    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void incValue() {
        value++;
    }

    @Override
    public void resetValue() {
        value = 0;
    }

    private int value;
}
