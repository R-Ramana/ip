package ip.response.exception;

import static ip.response.Response.printHorizontalLine;

public class ExceptionMessage {
    public static void printInvalidExceptionMessage() {
        printHorizontalLine();
        System.out.println(" Not wired to understand your command! Not as smart as you think I am :/");
        printHorizontalLine();
    }

    public static void printNoDescriptionExceptionMessage() {
        printHorizontalLine();
        System.out.println(" Hello, add what? You leave description/time blank you think I know meh?");
        printHorizontalLine();
    }

    public static void printNoCommandExceptionMessage() {
        printHorizontalLine();
        System.out.println(" Please enter an input, I cannot read minds!");
        printHorizontalLine();
    }

    public static void printNoTaskIdMessage() {
        printHorizontalLine();
        System.out.println(" You got put number or not? How to clear the task as done, I not as smart as you think uh!");
        printHorizontalLine();
    }

    public static void printIoExceptionMessage() {
        printHorizontalLine();
        System.out.println(" Error writing to file!");
        printHorizontalLine();
    }
}
