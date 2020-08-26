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

        // Create a to do list
        String[] toDoList = new String[100];
        int taskNumber = 0;

        // Create a task list
        Task[] taskList = new Task[100];

        while (!userInput.equals("bye")) {
            // Create a string array to split user input into words
            String[] words = userInput.split(" ");

            // Mark Task as Done
            if(words[0].equals("done") || words[0].equals("Done")) {
                int taskId = Integer.parseInt(words[1]);
                Task completedTask = taskList[taskId];
                completedTask.markAsDone();
                System.out.println(line + "\n Nice! I've marked this task as done:\n " +
                        completedTask.getStatusIcon() + " " + completedTask.getDescription() + '\n' + line);
            } else if(userInput.equals("list") || userInput.equals("List")) {
                // Print out to do list
                System.out.println(line + "\n Here are tasks in your list:");
                for (int i = 1; i <= Task.getTaskCount(); i++) {
                    System.out.println(" " + i + ". " +
                            taskList[i].getStatusIcon() +
                            " " + taskList[i].getDescription());
                }

                System.out.println(line);

            } else {
                // Add task to to do list
                Task newTask = new Task(userInput);
                taskList[newTask.getTaskCount()] = newTask;
                System.out.println(line + "\n added: " + userInput + '\n' + line);
            }

            userInput = input.nextLine();
        }

        String bye = line + " Bye. I hope I have helped you. See you soon!\n" + line;
        System.out.println(bye);

    }
}
