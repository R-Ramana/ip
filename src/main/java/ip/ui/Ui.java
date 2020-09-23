package ip.ui;

import ip.filemanager.FileManager;
import ip.task.Deadline;
import ip.task.TaskManager;

import java.util.ArrayList;

public class Ui {
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

    public static void printAddTaskMessage(Task task, int taskCount) {
        printHorizontalLine();
        System.out.println(" Got it. I've added this task:\n" + task + '\n');
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
        printHorizontalLine();
    }

    public void printListTasksMessage(TaskManager taskManager) {
        printHorizontalLine();
        System.out.println(" Here are the tasks in your list:");
        taskManager.listTasks();
        printHorizontalLine();
    }

    // Mark as done response
    public static void printDoneMessage(TaskManager completedTask) {
        printHorizontalLine();
        System.out.println(" Nice! I've marked this task as done:\n " +
                completedTask.toString());
        printHorizontalLine();
    }

    // Delete task
    public static void printDeleteMessage(TaskManager deletedTask, ArrayList<TaskManager> taskList) {
        printHorizontalLine();
        System.out.println(" Noted. I've removed this task:\n " +
                deletedTask.toString());
        System.out.println("");
        printHorizontalLine();
    }

}
