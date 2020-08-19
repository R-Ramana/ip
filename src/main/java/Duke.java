import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____   ____    _____   _____   _    _  \n"
                + "|  __| |  _ \\  |_   _| |_   _| | |  | | \n"
                + "| |__  | | | |   | |     | |   | |__| | \n"
                + "|  __| | | | |   | |     | |   |  __  | \n"
                + "| |__  | |_| |  _| |_    | |   | |  | | \n"
                + "|____| |____/  |_____|   |_|   |_|  |_| \n";
        System.out.println(logo);

        String line = "____________________________________________________________\n";
        String greeting = line +
                " Hello, I'm Edith!\n" +
                " I am a chatbot and I am here to assist you.\n" +
                " What can I help you with?\n" +
                line;

        System.out.println(greeting);

        // Create scanner class to take in new user inputs
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while (!userInput.equals("bye")) {
            System.out.println(line + ' ' + userInput + '\n' + line);
            userInput = input.nextLine();
        }

        String bye = line + " Bye. I hope I have helped you. See you soon!\n" + line;
        System.out.println(bye);

    }
}
