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
    public static Command parseCommand(String userInput) throws DukeException {
        // Prevents empty inputs
        if(userInput.isBlank()) {
            ExceptionMessage.printNoCommandExceptionMessage();
        }

        // Isolate the command word
        String[] userInputWords = userInput.split(" ", 2);
        String command = userInputWords[0];

        int taskId;

        switch (command) {
        case "list":
            return new ListCommand();
        case "todo":
            return new AddCommand('T', userInputWords[1]);
        case "event":
            String[] eventInfo = parseEvent(userInputWords[1]);
            return new AddCommand('E', eventInfo[0], eventInfo[1]);
        case "deadline":
            String[] deadlineInfo = parseDeadline(userInputWords[1]);
            return new AddCommand('D', deadlineInfo[0], deadlineInfo[1]);
        case "delete":
            taskId = getTaskId(userInputWords[1]);
            return new DeleteCommand(taskId);
        case "done":
            taskId = getTaskId(userInputWords[1]);
            return new DoneCommand(taskId);
        case "find":
            String keyword = userInputWords[1];
            return new FindCommand(keyword);
        case "bye":
            return new ExitCommand();
        default:
            throw new DukeException("Invalid Command!");
        }
    }

    // @@author {R-Ramana}-reused
    // Reused from https://github.com/prachi2023/ip/blob/A-MoreOOP/src/main/java/duke/Parser.java with minor modifications
    public static String[] parseEvent(String userInput) throws DukeException{
        String[] information = userInput.split(" /at ", 2);

        if (!userInput.contains("at")){
            ExceptionMessage.printNoDescriptionExceptionMessage();
        }

        return information;
    }

    // @@author R-Ramana-reused
    // Reused from https://github.com/prachi2023/ip/blob/A-MoreOOP/src/main/java/duke/Parser.java with minor modifications
    public static String[] parseDeadline(String userInput) throws DukeException{
        String[] information = userInput.split(" /by ", 2);

        if (!userInput.contains("by")){
            ExceptionMessage.printNoDescriptionExceptionMessage();
        }

        return information;
    }

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