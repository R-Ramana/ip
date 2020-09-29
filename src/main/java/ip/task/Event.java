package ip.task;

public class Event extends Task {

    protected String startTime;

    /**
     * Constructor method
     *
     * @param description Sets the description (Extended from Task)
     * @param startTime Sets the start time for the event
     */
    public Event(String description, String startTime) {
        super(description);
        this.startTime = startTime;
    }

    /**
     * Converts details to a string and returns the details
     *
     * @return Details of Deadline (Description and Start Time)
     */
    @Override
    public String toString() {
        return " [E]" + super.toString() + " (at: " + startTime + ")";
    }
}