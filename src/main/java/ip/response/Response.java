package ip.response;

import ip.task.Deadline;
import ip.task.Event;
import ip.task.Task;
import ip.task.Todo;

public class Response {
    // Horizontal line
    public static void printHorizontalLine() {
        final int LINE_COUNT = 60;
        String line = "-".repeat(LINE_COUNT);
        System.out.println(line);
    }

    // Welcome Address
    public static void printWelcomeMessage() {
        String logo = " ____   ____    _____   _____   _    _  " + System.lineSeparator()
                + "|  __| |  _ \\  |_   _| |_   _| | |  | | " + System.lineSeparator()
                + "| |__  | | | |   | |     | |   | |__| | " + System.lineSeparator()
                + "|  __| | | | |   | |     | |   |  __  | " + System.lineSeparator()
                + "| |__  | |_| |  _| |_    | |   | |  | | " + System.lineSeparator()
                + "|____| |____/  |_____|   |_|   |_|  |_| ";
        System.out.println(logo);

        String greeting =
                " Hello, I'm Edith!\n" +
                " I am a chatbot and I am here to assist you.\n" +
                " What can I help you with?";

        printHorizontalLine();
        System.out.println(greeting);
        printHorizontalLine();
    }

    // Farewell Address
    public static void printFarewellMessage() {
        String bye = "Bye. I hope I have helped you. See you soon!";

        printHorizontalLine();
        System.out.println(bye);
        printHorizontalLine();
    }

    // Get Description Position
    public static int getDescriptionPosition(String userInput) {
        return userInput.indexOf(" ") + 1;
    }

    // Get Time Position (duration start and end)
    public static int getTimePosition(String userInput) {
        return userInput.indexOf("/") + 4;
    }

    // Get Description
    public static String getDescription(String userInput, int descriptionPosition) {
        return userInput.substring(descriptionPosition);
    }

    // Mark as done response
    public static void printDoneMessage(Task completedTask) {
        completedTask.markAsDone();
        printHorizontalLine();
        System.out.println(" Nice! I've marked this task as done:\n " +
                completedTask.toString());
        printHorizontalLine();
    }

    // Print list response
    public static void printListMessage(Task[] taskList) {
        printHorizontalLine();
        System.out.println(" Here are tasks in your list:");
        for (int i = 1; i <= Task.getTaskCount(); i++) {
            System.out.println(" " + i + ". " + taskList[i].toString());
        }
        printHorizontalLine();
    }

    // Print to do response
    public static void printTodoMessage(String description, Task[] taskList) {
        Todo newTask = new Todo(description);
        taskList[newTask.getTaskCount()] = newTask;

        printHorizontalLine();
        System.out.println(" Got it. I've added this task:\n" + newTask + '\n');
        System.out.println("Now you have " + newTask.getTaskId() + " tasks in the list.");
        printHorizontalLine();
    }

    // Print event response
    public static void printEventMessage(String userInput, int descriptionPosition, int timePosition, Task[] taskList) {
        String eventAndTime = userInput.substring(descriptionPosition, timePosition - 4);
        String eventTime =  userInput.substring(timePosition);
        Event newEvent = new Event(eventAndTime, eventTime);
        taskList[newEvent.getTaskCount()] = newEvent;

        printHorizontalLine();
        System.out.println(" Got it. I've added this task:\n" + newEvent + '\n');
        System.out.println("Now you have " + newEvent.getTaskId() + " tasks in the list.");
        printHorizontalLine();
    }

    public static void printDeadlineMessage(String userInput, int descriptionPosition, int timePosition, Task[] taskList) {
        String deadlineDescription = userInput.substring(descriptionPosition, timePosition - 4);
        String deadline =  userInput.substring(timePosition);
        Deadline newDeadline = new Deadline(deadlineDescription, deadline);
        taskList[newDeadline.getTaskCount()] = newDeadline;

        printHorizontalLine();
        System.out.println(" Got it. I've added this task:\n" + newDeadline + '\n');
        System.out.println(" Now you have " + newDeadline.getTaskId() + " tasks in the list.");
        printHorizontalLine();
    }
}
