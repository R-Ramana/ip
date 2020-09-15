package ip.task;

import java.util.ArrayList;

public class Task {
    // Tick and cross symbols
    public final static String tick = "[✓]";
    public final static String cross = "[✘]";

    protected String description;
    protected boolean isDone;

    // Track the individual id of the tasks
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

    public Task deleteTask(int id, ArrayList<Task> taskList) {
        Task task = taskList.get(id-1);
        taskList.remove(id-1);
        taskCount--;
        return task;
    }

    public static Task getCompletedTask(String[] words, ArrayList taskList) {
        int taskId = Integer.parseInt(words[1]);
        return (Task) taskList.get(taskId - 1);
    }

    public static Task getDeletedTask(String[] words, ArrayList taskList) {
        int taskId = Integer.parseInt(words[1]);
        return (Task) taskList.get(taskId - 1);
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
        return (isDone ? tick : cross); //return tick or X symbols
    }

    public String toString() {
        return this.getStatusIcon() + " " + this.getDescription();
    }
}