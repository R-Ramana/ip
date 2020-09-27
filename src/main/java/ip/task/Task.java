package ip.task;

public class Task {
    // Tick and cross symbols
    public final static String tick = "[✓]";
    public final static String cross = "[✘]";

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    // Return task description
    public String getDescription() {
        return description;
    }

    // Return task description
    public boolean getIsDone() {
        return isDone;
    }

    // Mark task as complete
    public void markAsDone() {
        this.isDone = true;
    }

    //return tick or X symbols
    public String getStatusIcon() {
        return (isDone ? tick : cross);
    }

    public String toString() {
        return this.getStatusIcon() + " " + this.getDescription();
    }

}