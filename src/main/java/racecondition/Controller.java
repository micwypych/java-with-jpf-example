package racecondition;

public class Controller {

    public Controller(Service service) {
        this.service = service;
    }

    public int addValue(int value) {
        for (int i =0; i < value; i++) {
            service.incValue();
        }
        return service.getValue();
    }

    private Service service;
}
