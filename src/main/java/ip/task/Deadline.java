package ip.task;

public class Deadline extends TaskManager {

    protected String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return " [D]" + super.toString() + "(by: " + deadline + ")";
    }
}
