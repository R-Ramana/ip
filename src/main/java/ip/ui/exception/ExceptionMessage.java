package ip.ui.exception;

import static ip.ui.Ui.printHorizontalLine;

public class ExceptionMessage {
    public static void printInvalidExceptionMessage() {
        printHorizontalLine();
        System.out.println(" I am unable to understand your command! Please check for typos or try something else.");
        printHorizontalLine();
    }

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
