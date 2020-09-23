package ip.filemanager;

import ip.response.Response;
import ip.task.Deadline;
import ip.task.Event;
import ip.task.TaskManager;
import ip.task.Todo;

import java.io.*;
import java.util.ArrayList;


public class FileManager {

    static private String fileName = "duke.txt";

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
    public static void readFile(ArrayList<TaskManager> taskList) {
        // Create Task List

        try {
            FileReader file = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(file);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                // Get description and schedule of task (exclude commands)
                int descriptionPosition = Response.getReadDescriptionPosition(line);
                int timePosition = Response.getReadTimePosition(line);

                if(line.contains("[T]")) {
                    String description = line.substring(7);
                    Todo newTask = new Todo(description);
                    taskList.add(newTask);
                }
                if(line.contains("[E]")) {
                    String description = line.substring(7);
                    String event = description.substring(descriptionPosition, timePosition - 11);
                    String eventTime =  line.substring(timePosition, line.length() - 1);
                    Event newEvent = new Event(event, eventTime);
                    taskList.add(newEvent);
                }
                if(line.contains("[D]")) {
                    String description = line.substring(7);
                    String deadlineDescription = description.substring(descriptionPosition, timePosition - 11);
                    String deadline =  line.substring(timePosition, line.length() - 1);
                    Deadline newDeadline = new Deadline(deadlineDescription, deadline);
                    taskList.add(newDeadline);
                }
            }
            file.close();
        } catch (IOException e) {
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
