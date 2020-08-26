import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____   ____    _____   _____   _    _  " + System.lineSeparator()
                + "|  __| |  _ \\  |_   _| |_   _| | |  | | " + System.lineSeparator()
                + "| |__  | | | |   | |     | |   | |__| | " + System.lineSeparator()
                + "|  __| | | | |   | |     | |   |  __  | " + System.lineSeparator()
                + "| |__  | |_| |  _| |_    | |   | |  | | " + System.lineSeparator()
                + "|____| |____/  |_____|   |_|   |_|  |_| ";
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

        // Creating a task list
        String[] toDoList = new String[100];
        int taskNumber = 0;

        while (!userInput.equals("bye")) {
            //Add to do list
            if(!userInput.equals("list")) {
                toDoList[taskNumber] = userInput;
                taskNumber++;
                System.out.println(line + "\n added: " + userInput + '\n' + line);
            }
            // Print out to do list
            if(userInput.equals("list") || userInput.equals("List")) {
                System.out.println(line);
                for (int i = 1; i <= taskNumber; i++) {
                    System.out.println(" " + i + ". " + toDoList[i-1] );
                }
                System.out.println(line);
            }

            userInput = input.nextLine();
        }

        String bye = line + " Bye. I hope I have helped you. See you soon!\n" + line;
        System.out.println(bye);

    }
}
