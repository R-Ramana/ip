package ip.task;

public class Todo extends TaskManager {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return " [T]" + super.toString();
    }
}