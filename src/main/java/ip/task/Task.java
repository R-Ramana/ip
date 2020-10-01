package ip.task;

import java.time.LocalDate;
import java.time.LocalTime;


public class Task {
    // Yes and No character representation for isDone status
    public final static String IS_DONE_YES = "[Y]";
    public final static String IS_DONE_NO = "[N]";

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
        return (isDone ? IS_DONE_YES : IS_DONE_NO);
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