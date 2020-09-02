import java.util.Scanner;
import ip.response.Response;
import ip.task.Task;
import ip.task.Deadline;
import ip.task.Event;
import ip.task.Todo;


public class Duke {
    public static void main(String[] args) {
        // Print Welcome Message
        Response.printWelcomeMessage();

        // Create scanner class to take in new user inputs
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        // Create Task List
        Task[] taskList = new Task[100];


        // To run the programme until user inputs "bye" (ends the programme)
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

                Response.horizontalLine();
                System.out.println(" Nice! I've marked this task as done:\n " +
                        completedTask.toString());
                Response.horizontalLine();
                break;
            // Print out to do list
            case "list":
                Response.horizontalLine();
                System.out.println(" Here are tasks in your list:");
                for (int i = 1; i <= Task.getTaskCount(); i++) {
                    System.out.println(" " + i + ". " + taskList[i].toString());
                }
                Response.horizontalLine();
                break;
            // Add a to do task
            case "todo":
                Todo newTask = new Todo(description);
                taskList[newTask.getTaskCount()] = newTask;

                Response.horizontalLine();
                System.out.println(" Got it. I've added this task:\n" + newTask + '\n');
                System.out.println("Now you have " + newTask.getTaskId() + " tasks in the list.");
                Response.horizontalLine();
                break;
            // Add an event task
            case "event":
                String eventAndTime = userInput.substring(descriptionPosition, timePosition - 4);
                String eventTime =  userInput.substring(timePosition);
                Event newEvent = new Event(eventAndTime, eventTime);
                taskList[newEvent.getTaskCount()] = newEvent;

                Response.horizontalLine();
                System.out.println(" Got it. I've added this task:\n" + newEvent + '\n');
                System.out.println("Now you have " + newEvent.getTaskId() + " tasks in the list.");
                Response.horizontalLine();
                break;
            // Add a deadline task
            case "deadline":
                String deadlineDescription = userInput.substring(descriptionPosition, timePosition - 4);
                String deadline =  userInput.substring(timePosition);
                Deadline newDeadline = new Deadline(deadlineDescription, deadline);
                taskList[newDeadline.getTaskCount()] = newDeadline;

                Response.horizontalLine();
                System.out.println(" Got it. I've added this task:\n" + newDeadline + '\n');
                System.out.println(" Now you have " + newDeadline.getTaskId() + " tasks in the list.");
                Response.horizontalLine();
                break;
            }
            userInput = input.nextLine();
        }

        // Print Farewell Message
        Response.printFarewellMessage();
    }
}
