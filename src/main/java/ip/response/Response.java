package ip.response;

import ip.filemanager.FileManager;
import ip.task.Deadline;
import ip.task.Event;
import ip.task.TaskManager;
import ip.task.Todo;

import java.util.ArrayList;

import static ip.ui.Ui.printHorizontalLine;

public class Response {



    // Get Description Position
    public static int getDescriptionPosition(String userInput) {
        return userInput.indexOf(" ") + 1;
    }

    // Get Time Position (duration start and end)
    public static int getTimePosition(String userInput) {
        return userInput.indexOf("/") + 4;
    }

    // Get Description Position
    public static int getReadDescriptionPosition(String line) {
        return line.indexOf(" ", line.indexOf(" "));
    }

    // Get Time Position (duration start and end)
    public static int getReadTimePosition(String line) {
        return line.indexOf("(") + 4;
    }

    // Get Description
    public static String getDescription(String userInput, int descriptionPosition) {
        return userInput.substring(descriptionPosition);
    }

    // Mark as done response
    public static void printDoneMessage(TaskManager completedTask) {
        completedTask.markAsDone();
    }

    // Print list response
    public static void printListMessage(ArrayList<TaskManager> taskList) {
        printHorizontalLine();
        System.out.println(" Here are tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(" " + (i+1) + "." + taskList.get(i).toString() );
            if(i == 0) {
                FileManager.overwriteFile(taskList.get(i).toString());
            } else {
                FileManager.writeToFile(taskList.get(i).toString());
            }
        }
        printHorizontalLine();
    }

    // Print to do response
    public static void printTodoMessage(String userInput, int descriptionPosition, ArrayList taskList) {
        String todoDescription = userInput.substring(userInput.indexOf("todo "));
        String description = todoDescription.substring(5);
        Todo newTask = new Todo(description);
        taskList.add(newTask);
        FileManager.writeToFile(newTask.toString());

        printHorizontalLine();
        System.out.println(" Got it. I've added this task:\n" + newTask + '\n');
        System.out.println("Now you have " + taskList.size()+ " tasks in the list.");
        printHorizontalLine();
    }

    // Print event response
    public static void printEventMessage(String userInput, int descriptionPosition, int timePosition, ArrayList taskList) {
        String event = userInput.substring(descriptionPosition, timePosition - 4);
        String eventTime =  userInput.substring(timePosition);
        Event newEvent = new Event(event, eventTime);
        taskList.add(newEvent);
        FileManager.writeToFile(newEvent.toString());

        printHorizontalLine();
        System.out.println(" Got it. I've added this task:\n" + newEvent + '\n');
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
        printHorizontalLine();
    }

    public static void printDeadlineMessage(String userInput, int descriptionPosition, int timePosition, ArrayList taskList) {
        String deadlineDescription = userInput.substring(descriptionPosition, timePosition - 4);
        String deadline =  userInput.substring(timePosition);
        Deadline newDeadline = new Deadline(deadlineDescription, deadline);
        taskList.add(newDeadline);
        FileManager.writeToFile(newDeadline.toString());

        printHorizontalLine();
        System.out.println(" Got it. I've added this task:\n" + newDeadline + '\n');
        System.out.println(" Now you have " + taskList.size() + " tasks in the list.");
        printHorizontalLine();
    }

    // Delete task
    public static void printDeleteMessage(TaskManager deletedTask, ArrayList<TaskManager> taskList) {
        int taskId = deletedTask.getTaskId();
        deletedTask.deleteTask(taskId, taskList);
        printHorizontalLine();
        System.out.println(" Noted. I've removed this task:\n " +
                deletedTask.toString());
        System.out.println(" Now you have " + taskList.size() + " tasks in the list.");
        printHorizontalLine();
    }
}
