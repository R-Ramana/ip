package ip.task;


public class Task {
    // Tick and cross symbols
    public final static String tick = "[✓]";
    public final static String cross = "[✘]";

    protected String description;
    protected boolean isDone;

    /**
     * Constructor method.
     * Sets description of task and the status of task completion to incomplete (isDone = false)
     *
     * @param description Sets the description for the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * @return description of task
     */
    public String getDescription() {
        return description;
    }

    /**
     * isDone = true (task is completed)
     * isDone = false (task is incomplete)
     * @return completed status of task
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Sets isDone = true (task is completed)
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * @return a String representation of tick/cross
     */
    public String getStatusIcon() {
        return (isDone ? tick : cross);
    }

    /**
     * Converts details to a string and returns the details
     *
     * @return Details of Task (isDone Status + Description + Duration [if any])
     */
    public String toString() {
        return this.getStatusIcon() + " " + this.getDescription();
    }

}