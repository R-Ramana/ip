import ip.commands.Command;
import ip.parser.Parser;
import ip.storage.Storage;
import ip.ui.Ui;
import ip.ui.exception.DukeException;
import ip.ui.exception.ExceptionMessage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Duke {

    // @@author {R-Ramana}-reused
    // Reused from https://stackoverflow.com/questions/4362786/getting-the-default-root-directory-in-java with minor modifications
    private static final String ROOT = System.getProperty("user.dir");
    private static final String FILE_NAME = "duke.txt";


    private static final String FILE_PATH = Paths.get(ROOT, FILE_NAME).toString();
    private static final boolean FILE_EXISTS = Files.exists(Path.of(FILE_PATH));

    private static Ui ui;

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
        // Prints opening message on startup
        ui.printWelcomeMessage();

        boolean isExit = false;

        /**
         * Program runs until user inputs bye
         * Otherwise user input is parsed and actions are executed accordingly with respect to the command
         */
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