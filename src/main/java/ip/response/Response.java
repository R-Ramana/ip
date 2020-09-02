package ip.response;

public class Response {
    // Horizontal line
    public static void horizontalLine() {
        final int LINE_COUNT = 60;
        String line = "-".repeat(LINE_COUNT);
        System.out.println(line);
    }

    // Welcome Address
    public static void printWelcomeMessage() {
        String logo = " ____   ____    _____   _____   _    _  " + System.lineSeparator()
                + "|  __| |  _ \\  |_   _| |_   _| | |  | | " + System.lineSeparator()
                + "| |__  | | | |   | |     | |   | |__| | " + System.lineSeparator()
                + "|  __| | | | |   | |     | |   |  __  | " + System.lineSeparator()
                + "| |__  | |_| |  _| |_    | |   | |  | | " + System.lineSeparator()
                + "|____| |____/  |_____|   |_|   |_|  |_| ";
        System.out.println(logo);

        String greeting =
                " Hello, I'm Edith!\n" +
                " I am a chatbot and I am here to assist you.\n" +
                " What can I help you with?";

        horizontalLine();
        System.out.println(greeting);
        horizontalLine();
    }

    // Farewell Address
    public static void printFarewellMessage() {
        String bye = "Bye. I hope I have helped you. See you soon!";

        horizontalLine();
        System.out.println(bye);
        horizontalLine();
    }
}
