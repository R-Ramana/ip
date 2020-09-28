package ip.task;

public class Deadline extends Task {

    protected String deadline;

    /**
     * Constructor method
     *
     * @param description Sets the description (Extended from Task)
     * @param deadline Sets the deadline
     */
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    /**
     * Converts details to a string and returns the details
     *
     * @return Details of Deadline (Description and End Time)
     */
    @Override
    public String toString() {
        return " [D]" + super.toString() + "(by:" + deadline + ")";
    }
}
