package ip.ui;

import ip.task.Task;
import ip.task.TaskManager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Information is printed out to the user on the command line when commands have been successfully executed.
 */
public class Ui {

    // To scan and read user input
    public String readInput(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    // Prints Horizontal lines of length = LINE_COUNT
    public static void printHorizontalLine() {
        final int LINE_COUNT = 60;
        String line = "-".repeat(LINE_COUNT);
        System.out.println(line);
    }

    // Welcome Address displayed when Duke starts
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

    // Farewell Address to be called when user inputs bye command
    public static void printFarewellMessage() {
        String bye = "Bye. I hope I have helped you. See you soon!";

        printHorizontalLine();
        System.out.println(bye);
        printHorizontalLine();
    }

    // To be called when task is added (e.g. Deadline/Event)
    public static void printAddTaskMessage(Task task) {
        printHorizontalLine();
        System.out.println(" Got it. I've added this task:\n" + task + '\n');
        System.out.println(" Now you have " + TaskManager.getTasksCount() + " tasks in the list.");
        printHorizontalLine();
    }

    // Called when user requests to list
    public static void printListTasksMessage() {
        printHorizontalLine();
        System.out.println(" Here are the tasks in your list:");
        TaskManager.listTasks();
        printHorizontalLine();
    }

    // Mark task as done response. Called if task is successfully marked as done.
    public static void printDoneMessage(Task completedTask) {
        printHorizontalLine();
        System.out.println(" Nice! I've marked this task as done:\n " +
                completedTask.toString());
        printHorizontalLine();
    }

    // Called when user requests to delete task
    public static void printDeleteMessage(Task deletedTask) {
        printHorizontalLine();
        System.out.println(" Noted. I've removed this task:\n " +
                deletedTask.toString());
        System.out.println(" Now you have " + TaskManager.getTasksCount() + " tasks in the list.");
        printHorizontalLine();
    }

    // Called when user wants to find task via keyword
    public static void printFilterTaskMessage(ArrayList<Task> taskList) {
        printHorizontalLine();
        if(taskList.isEmpty()) {
            System.out.println(" Keyword returns no search result");
        } else {
            System.out.println(" Here are the matching tasks in your list:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(" " + (i+1) + "." + taskList.get(i).toString());
            }
        }
        printHorizontalLine();
    }

}
