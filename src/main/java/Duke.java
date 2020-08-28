import java.util.Scanner;
import ip.task.Task;
import ip.task.Deadline;
import ip.task.Event;
import ip.task.Todo;


public class Duke {
    public static void main(String[] args) {
        String logo = " ____   ____    _____   _____   _    _  " + System.lineSeparator()
                + "|  __| |  _ \\  |_   _| |_   _| | |  | | " + System.lineSeparator()
                + "| |__  | | | |   | |     | |   | |__| | " + System.lineSeparator()
                + "|  __| | | | |   | |     | |   |  __  | " + System.lineSeparator()
                + "| |__  | |_| |  _| |_    | |   | |  | | " + System.lineSeparator()
                + "|____| |____/  |_____|   |_|   |_|  |_| ";
        System.out.println(logo);

        String line = "____________________________________________________________\n";
        String greeting = line +
                " Hello, I'm Edith!\n" +
                " I am a chatbot and I am here to assist you.\n" +
                " What can I help you with?\n" +
                line;

        System.out.println(greeting);

        // Create scanner class to take in new user inputs
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        // Create a to do list
        String[] toDoList = new String[100];
        int taskNumber = 0;

        // Create a task list
        Task[] taskList = new Task[100];

        while (!userInput.equals("bye")) {
            // Create a string array to split user input into words
            String[] words = userInput.split(" ");

            // Get description and schedule of task (exclude commands)
            int descriptionPosition = userInput.indexOf(" ") + 1;
            int timePosition = userInput.indexOf("/") + 4;
            String description = userInput.substring(descriptionPosition);


            switch(words[0]) {
            // Mark Task as Done
            case "done":
                int taskId = Integer.parseInt(words[1]);
                Task completedTask = taskList[taskId];
                completedTask.markAsDone();
                System.out.println(line + "\n Nice! I've marked this task as done:\n " +
                        completedTask.toString() + '\n' + line);
                break;
            // Print out to do list
            case "list":
                System.out.println(line + "\n Here are tasks in your list:");
                for (int i = 1; i <= Task.getTaskCount(); i++) {
                    System.out.println(" " + i + ". " + taskList[i].toString());
                }
                System.out.println(line);
                break;
            // Add a to do task
            case "todo":
                Todo newTask = new Todo(description);
                taskList[newTask.getTaskCount()] = newTask;
                System.out.println(line + "\n Got it. I've added this task:\n" + newTask + '\n');
                System.out.println("Now you have " + newTask.getTaskId() + " tasks in the list.\n" + line);
                break;
            // Add an event task
            case "event":
                String eventAndTime = userInput.substring(descriptionPosition, timePosition - 4);
                String eventTime =  userInput.substring(timePosition);
                Event newEvent = new Event(eventAndTime, eventTime);
                taskList[newEvent.getTaskCount()] = newEvent;
                System.out.println(line + "\n Got it. I've added this task:\n" + newEvent + '\n');
                System.out.println("Now you have " + newEvent.getTaskId() + " tasks in the list.\n" + line);
                break;
            // Add a deadline task
            case "deadline":
                String deadlineDescription = userInput.substring(descriptionPosition, timePosition - 4);
                String deadline =  userInput.substring(timePosition);
                Deadline newDeadline = new Deadline(deadlineDescription, deadline);
                taskList[newDeadline.getTaskCount()] = newDeadline;
                System.out.println(line + "\n Got it. I've added this task:\n" + newDeadline + '\n');
                System.out.println("Now you have " + newDeadline.getTaskId() + " tasks in the list.\n" + line);
                break;
            }
            userInput = input.nextLine();
        }

        String bye = line + " Bye. I hope I have helped you. See you soon!\n" + line;
        System.out.println(bye);

    }
}
