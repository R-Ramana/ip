package ip.task;

import ip.ui.exception.DukeException;
import ip.filemanager.FileManager;
import ip.ui.Ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TaskManager {
    // Tick and cross symbols
    public final static String tick = "[✓]";
    public final static String cross = "[✘]";

    private final ArrayList<Task> tasks = new ArrayList<>();
    private int tasksCount = 0;
    private final FileManager fileManager;

    protected String description;
    protected boolean isDone;

    // Track the individual id of the tasks
    protected int taskID = 0;
    // Track the number of tasks
    //private static int taskCount = 0;

    public TaskManager(String description) {
        this.description = description;
        //this.taskID = ++taskCount;
        this.isDone = false;
    }

    // Return task Id
    /*public int getTaskId() {
        return taskID;
    }*/

    public TaskManager deleteTask(int id, ArrayList<TaskManager> taskList) {
        TaskManager task = taskList.get(id-1);
        taskList.remove(id-1);
        taskCount--;
        return task;
    }

    public static TaskManager getCompletedTask(String[] words, ArrayList taskList) {
        int taskId = Integer.parseInt(words[1]);
        return (TaskManager) taskList.get(taskId - 1);
    }

    public static TaskManager getDeletedTask(String[] words, ArrayList taskList) {
        int taskId = Integer.parseInt(words[1]);
        return (TaskManager) taskList.get(taskId - 1);
    }

    // Return total number of tasks
    //public static int getTaskCount() {
        //return taskCount;
    //}

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