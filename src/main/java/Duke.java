import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ip.filemanager.FileManager;
import ip.ui.exception.ExceptionMessage;
import ip.response.Response;
import ip.task.TaskManager;
import ip.ui.Ui;


public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    // Create Task List
    public static final ArrayList<TaskManager> taskList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Read from file
        // Solution below adapted from https://alvinalexander.com/java/java-file-exists-directory-exists/#:~:text=To%20test%20to%20see%20if,directory%20exists%2C%20and%20false%20otherwise.
        File file = new File("duke.txt");
        file = new File(file.getCanonicalPath());
        boolean exists = file.exists();
        if(exists) {
            FileManager.readFile(taskList);
        }

        // Print Welcome Message
        Ui.printWelcomeMessage();

        // Create scanner class to take in new user inputs
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

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
                    TaskManager completedTask = TaskManager.getCompletedTask(words, taskList);
                    Ui.printDoneMessage(completedTask);
                    FileManager.createFile();
                } catch (ArrayIndexOutOfBoundsException e) {
                    ExceptionMessage.printNoTaskIdMessage();
                } catch (IOException e) {
                    ExceptionMessage.printIoExceptionMessage();
                }
                break;

            // Print out to do list
            case "list":
                Response.printListMessage(taskList);
                FileManager.createFile();
                break;

            // Add a to do task
            case "todo":
                try {
                    Response.printTodoMessage(userInput, descriptionPosition, taskList);
                    FileManager.createFile();
                } catch (StringIndexOutOfBoundsException e) { // add more catch blocks here
                    ExceptionMessage.printNoDescriptionExceptionMessage();
                } catch (IOException e) {
                    ExceptionMessage.printIoExceptionMessage();
                }
                break;

            // Add an event task
            case "event":
                try {
                    Response.printEventMessage(userInput, descriptionPosition, timePosition, taskList);
                    FileManager.createFile();
                } catch (StringIndexOutOfBoundsException e) { // add more catch blocks here
                    ExceptionMessage.printNoDescriptionExceptionMessage();
                } catch (IOException e) {
                    ExceptionMessage.printIoExceptionMessage();
                }
                break;

            // Add a deadline task
            case "deadline":
                try {
                    Response.printDeadlineMessage(userInput, descriptionPosition, timePosition, taskList);
                    FileManager.createFile();
                } catch (StringIndexOutOfBoundsException e) { // add more catch blocks here
                    ExceptionMessage.printNoDescriptionExceptionMessage();
                } catch (IOException e) {
                    ExceptionMessage.printIoExceptionMessage();
                }
                break;

            // Delete task entries
            case "delete":
                try {
                    TaskManager deletedTask = TaskManager.getDeletedTask(words, taskList);
                    Response.printDeleteMessage(deletedTask, taskList);
                } catch (IndexOutOfBoundsException e) { // add more catch blocks here
                    ExceptionMessage.printNoDescriptionExceptionMessage();
                }
                break;

            // Empty commands
            case "":
                ExceptionMessage.printNoCommandExceptionMessage();
                break;

            // Other random commands
            default:
                ExceptionMessage.printInvalidExceptionMessage();
                break;
            }
            userInput = input.nextLine();
        }

        // Print Farewell Message
        Ui.printFarewellMessage();
    }
}
