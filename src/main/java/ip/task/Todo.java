package ip.task;

public class Todo extends Task {

    /**
     * Constructor method
     *
     * @param description Sets the description (Extended from Task)
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Converts details to a string and returns the details
     *
     * @return Details of the task (Description)
     */
    @Override
    public String toString() {
        return " [T]" + super.toString();
    }
}