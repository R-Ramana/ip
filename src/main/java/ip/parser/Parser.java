package ip.parser;

import ip.commands.AddCommand;
import ip.commands.Command;
import ip.commands.DeleteCommand;
import ip.commands.DoneCommand;
import ip.commands.ExitCommand;
import ip.commands.FindCommand;
import ip.commands.ListCommand;
import ip.ui.exception.DukeException;
import ip.ui.exception.ExceptionMessage;

public class Parser {

    /**
     * Method makes sense of user inputs.
     * Takes in the whole string and splits the entire input into the command word and description
     * Calls the respective commands to execute specific actions
     *
     * @param userInput User's input from the command line
     */
    public static Command parseCommand(String userInput) throws DukeException {
        final String LIST_COMMAND = "list";
        final String TODO_COMMAND = "todo";
        final String EVENT_COMMAND = "event";
        final String DEADLINE_COMMAND = "deadline";
        final String DELETE_COMMAND = "delete";
        final String DONE_COMMAND = "done";
        final String FIND_COMMAND = "find";
        final String BYE_COMMAND = "bye";

        // Prevents empty inputs
        if(userInput.isBlank()) {
            ExceptionMessage.printNoCommandExceptionMessage();
        }

        // Isolate command word
        String[] userInputWords = userInput.split(" ", 2);
        String command = userInputWords[0];

        int taskId;

        switch (command) {
        case LIST_COMMAND:
            return new ListCommand();
        case TODO_COMMAND:
            return new AddCommand('T', userInputWords[1]);
        case EVENT_COMMAND:
            String[] eventInfo = parseEvent(userInputWords[1]);
            return new AddCommand('E', eventInfo[0], eventInfo[1]);
        case DEADLINE_COMMAND:
            String[] deadlineInfo = parseDeadline(userInputWords[1]);
            return new AddCommand('D', deadlineInfo[0], deadlineInfo[1]);
        case DELETE_COMMAND:
            taskId = getTaskId(userInputWords[1]);
            return new DeleteCommand(taskId);
        case DONE_COMMAND:
            taskId = getTaskId(userInputWords[1]);
            return new DoneCommand(taskId);
        case FIND_COMMAND:
            String keyword = userInputWords[1];
            return new FindCommand(keyword);
        case BYE_COMMAND:
            return new ExitCommand();
        default:
            throw new DukeException("Invalid Command! Please check for typos or try something else.");
        }
    }

    /**
     * Method makes sense of the description from the user input. Only used for event command.
     * Splits the description and start duration.
     * Returns a String[] containing the description and start time.
     *
     * @param userInput Part of user's input from the command line. Exclude the command word [description and duration]
     * @return Description and Start Time
     */
    // @@author {R-Ramana}-reused
    // Reused from https://github.com/prachi2023/ip/blob/A-MoreOOP/src/main/java/duke/Parser.java with minor modifications
    public static String[] parseEvent(String userInput) {
        String[] information = userInput.split(" /at ", 2);

        // ensure start time is stated
        if (!userInput.contains("at")){
            ExceptionMessage.printNoDescriptionExceptionMessage();
        }

        return information;
    }

    /**
     * Method makes sense of the description from the user input. Only used for deadline command.
     * Splits the description and end duration.
     * Returns a String[] containing the description and end time.
     *
     * @param userInput Part of user's input from the command line. Exclude the command word [description and duration]
     * @return Description and End Time
     */
    // @@author R-Ramana-reused
    // Reused from https://github.com/prachi2023/ip/blob/A-MoreOOP/src/main/java/duke/Parser.java with minor modifications
    public static String[] parseDeadline(String userInput) {
        String[] information = userInput.split(" /by ", 2);

        // ensure end time is stated
        if (!userInput.contains("by")){
            ExceptionMessage.printNoDescriptionExceptionMessage();
        }

        return information;
    }

    /**
     * Takes in the String after the command word when done/delete command is entered.
     * Converts String to an Integer type and returns the Integer value.
     *
     * @param taskNumber
     * @return Task ID of the task to be deleted/marked as done
     */
    private static Integer getTaskId (String taskNumber) {
        int taskId = 0;

        try {
            taskId = Integer.parseInt(taskNumber);
        } catch (NumberFormatException e) {
            ExceptionMessage.printNoTaskIdMessage();
        }
        return taskId;
    }
}