import ip.commands.Command;
import ip.storage.Storage;
import ip.parser.Parser;
import ip.task.Task;
import ip.ui.Ui;
import ip.ui.exception.ExceptionMessage;
import ip.ui.exception.DukeException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Duke {

    // @@author {R-Ramana}-reused
    // Reused from https://stackoverflow.com/questions/4362786/getting-the-default-root-directory-in-java with minor modifications
    private static final String ROOT = System.getProperty("user.dir");
    private static final String FILE_NAME = "duke.txt";


    private static final String FILE_PATH = Paths.get(ROOT, FILE_NAME).toString();
    private static final boolean FILE_EXISTS = Files.exists(Path.of(FILE_PATH));

    private static Ui ui;
    private static ArrayList<Task> taskList;

    public static void main(String[] args) {
        Storage storage;

        if (FILE_EXISTS) {
            // if file exists, use the file
            storage = new Storage(FILE_PATH);
            storage.readFile();
        } else {
            // else create a new file called duke.txt
            storage = new Storage(FILE_NAME);
        }

        ui = new Ui();
        ui.printWelcomeMessage();

        boolean isExit = false;

        // Runs until user inputs bye
        while (!isExit) {
            try {
                String fullCommand = ui.readInput();
                ui.printHorizontalLine();
                Command command = Parser.parseCommand(fullCommand);
                command.execute(ui);
                isExit = command.getIsExit();
            } catch (DukeException e) {
                ExceptionMessage.printErrorMessage(e.getErrorMessage());
            }
        }
    }
}