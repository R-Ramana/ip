package ip.task;

public class Task {
    protected String description;
    protected boolean isDone;

    //
    protected int taskID = 0;
    // Track the number of tasks
    private static int taskCount = 0;

    public Task(String description) {
        this.description = description;
        this.taskID = ++taskCount;
        this.isDone = false;
    }

    // Return task Id
    public int getTaskId() {
        return taskID;
    }

    // Return total number of tasks
    public static int getTaskCount() {
        return taskCount;
    }

    // Return task description
    public String getDescription() {
        return description;
    }

    // Mark task as complete
    public void markAsDone() {
        this.isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713]" : "[\u2718]"); //return tick or X symbols
    }

    //...
}