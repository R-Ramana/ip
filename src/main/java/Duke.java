import java.util.Scanner;

import ip.response.DukeException;
import ip.response.ExceptionMessage;
import ip.response.Response;
import ip.task.Task;


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
            int descriptionPosition = Response.getDescriptionPosition(userInput);
            int timePosition = Response.getTimePosition(userInput);

            switch(words[0]) {
            // Mark Task as Done
            case "done":
                try {
                    Task completedTask = Task.getCompletedTask(words, taskList);
                    Response.printDoneMessage(completedTask);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You got put number or not? How to clear the task as done, I not as smart as you think uh!");
                }
                break;

            // Print out to do list
            case "list":
                Response.printListMessage(taskList);
                break;

            // Add a to do task
            case "todo":
                try {
                    Response.printTodoMessage(userInput, descriptionPosition, taskList);
                } catch (StringIndexOutOfBoundsException e) { // add more catch blocks here
                    ExceptionMessage.printNoDescriptionExceptionMessage();
                }
                break;

            // Add an event task
            case "event":
                try {
                    Response.printEventMessage(userInput, descriptionPosition, timePosition, taskList);
                } catch (StringIndexOutOfBoundsException e) { // add more catch blocks here
                    ExceptionMessage.printNoDescriptionExceptionMessage();
                }
                break;

            // Add a deadline task
            case "deadline":
                try {
                    Response.printDeadlineMessage(userInput, descriptionPosition, timePosition, taskList);
                } catch (StringIndexOutOfBoundsException e) { // add more catch blocks here
                    ExceptionMessage.printNoDescriptionExceptionMessage();
                }
                break;

            // Empty commands
            case "":
                ExceptionMessage.printNoCommandMessage();
                break;

            // Other random commands
            default:
                ExceptionMessage.printInvalidExceptionMessage();
                break;
            }
            userInput = input.nextLine();
        }

        // Print Farewell Message
        Response.printFarewellMessage();
    }
}
