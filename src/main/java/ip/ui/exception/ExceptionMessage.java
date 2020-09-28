package ip.ui.exception;

import static ip.ui.Ui.printHorizontalLine;


/**
 * Information is printed out to the user on the command line when commands have NOT been successfully executed.
 * Possible cause of error noted in the message
 */
public class ExceptionMessage {

    public static void printNoDescriptionExceptionMessage() {
        printHorizontalLine();
        System.out.println(" The description/time is missing. Please try again.");
        printHorizontalLine();
    }

    public static void printNoCommandExceptionMessage() {
        printHorizontalLine();
        System.out.println(" Please enter an input, I cannot read minds (But I wish I could)!");
        printHorizontalLine();
    }

    public static void printNoTaskIdMessage() {
        printHorizontalLine();
        System.out.println(" No/Invalid task ID listed. Unable to clear task.");
        printHorizontalLine();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
