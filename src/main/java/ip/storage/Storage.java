package ip.filemanager;

import ip.commands.AddCommand;
import ip.commands.Command;
import ip.parser.Parser;
import ip.task.Deadline;
import ip.task.Event;
import ip.task.Todo;
import ip.task.Task;
import ip.ui.Ui;
import ip.ui.exception.DukeException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileManager {

    private static String fileName;

    public FileManager(String fileName) {
        FileManager.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    // @@author {R-Ramana}-reused
    // Reused from https://www.javatpoint.com/how-to-create-a-file-in-java with minor modifications
    public static void createFile() throws IOException {
        File file = new File(fileName);

        try {
            if (file.createNewFile()) {
                System.out.println("File created at location: " + file.getCanonicalPath());
            } else {
                System.out.println("File updated. View file here: " + file.getCanonicalPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // @@author {R-Ramana}-reused
    // Reused from https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java with minor modifications
    public static void readFile(ArrayList<Task> taskList, Ui ui) {

        try {
            FileReader file = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(file);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] substring = line.split(" ",2);
                if (substring[0].contains("[T]")) {
                    new AddCommand("todo", substring[0]);
                }


                if (substring[0].contains("[E]")) {
                    String[] eventInfo = Parser.parseEvent(substring[0]);
                    new AddCommand("event", eventInfo[0], eventInfo[1]);
                }

                if (substring[0].contains("[D]")) {
                    String[] deadlineInfo = Parser.parseDeadline(substring[0]);
                    new AddCommand("deadline", deadlineInfo[0], deadlineInfo[1]);
                }
            }

            file.close();

        } catch (IOException | DukeException e) {
            e.printStackTrace();
        }
    }

    // @@author {R-Ramana}-reused
    // Reused from https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java with minor modifications
    public static void writeToFile(String textInput) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(textInput);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void overwriteFile(String textInput) {
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(textInput);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
