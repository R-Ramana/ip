import java.util.Scanner;
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
            String description = Response.getDescription(userInput, descriptionPosition);


            switch(words[0]) {
            // Mark Task as Done
            case "done":
                Task completedTask = Task.getCompletedTask(words, taskList);
                Response.printDoneMessage(completedTask);
                break;

            // Print out to do list
            case "list":
                Response.printListMessage(taskList);
                break;

            // Add a to do task
            case "todo":
                Response.printTodoMessage(description, taskList);
                break;

            // Add an event task
            case "event":
                Response.printEventMessage(userInput, descriptionPosition, timePosition, taskList);
                break;

            // Add a deadline task
            case "deadline":
                Response.printDeadlineMessage(userInput, descriptionPosition, timePosition, taskList);
                break;
            }
            userInput = input.nextLine();
        }

        // Print Farewell Message
        Response.printFarewellMessage();
    }
}
