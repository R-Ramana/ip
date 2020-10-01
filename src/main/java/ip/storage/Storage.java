package ip.storage;

import ip.task.Task;
import ip.task.TaskManager;
import ip.ui.exception.DukeException;
import ip.ui.exception.ExceptionMessage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Storage Class is where all methods related to files can be accessed from.
 * File is accessed at teh beginning when Duke starts up and only for delete, done, add (e.g. deadline/event) commands
 */
public class Storage {

    private static String fileName;

    /**
     * Constructor
     *
     * @param fileName Name of file that is used for storage
     */
    public Storage(String fileName) {
        Storage.fileName = fileName;
    }

    /**
     * Method is called at the very beginning when Duke runs, if a file exists
     * Reads inputs from the file line by line and adds the existing task and status.
     * Acts like a local storage drive
     */
    // @@author {R-Ramana}-reused
    // Reused from https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java with minor modifications
    public static void readFile() {

        try {
            FileReader file = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(file);

            String line;
            Task task;

            while ((line = bufferedReader.readLine()) != null) {
                String[] fileLines = line.split("\\| ");
                String taskType = fileLines[0].strip();
                String doneStatus = fileLines[1].strip();

                switch (taskType) {
                case "T":
                    task = TaskManager.addTodo(fileLines[2]);
                    break;
                case "D":
                    task = TaskManager.addDeadline(fileLines[2], fileLines[3]);
                    break;
                case "E":
                    task = TaskManager.addEvent(fileLines[2], fileLines[3]);
                    break;
                default:
                    throw new DukeException("Cannot read file");
                }

                if (doneStatus.contains("Y")) {
                    task.markAsDone();
                }
            }

            file.close();

        } catch (IOException | DukeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method is called when user adds a new task
     * Method takes in the status, description, type, and time of the task to be added.
     * Method appends new lines to the existing file
     * Outputs in the form of TASK_TYPE (T/E/D) | STATUS (Y/N) | DESCRIPTION | DURATION
     * e.g T | Y | Read Book
     * e.g E | N | Tutorial | Today 2-4pm
     *
     * @param isDone Completed Status of task
     * @param command Type of task to be added (e.g deadline, event)
     * @param description Description of the task to be added
     * @param duration Takes in vargs parameter (only applicable for deadline and event) of the end/start time
     */
    // @@author {R-Ramana}-reused
    // Reused from https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java with minor modifications
    public static void writeToFile(Boolean isDone, char command, String description, String... duration) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            char isDoneStatus;

            if(isDone) {
                isDoneStatus = 'Y';
            } else {
                isDoneStatus = 'N';
            }

            String delimiter = " | ";

            if (command == 'T') {
                bufferedWriter.write(command + delimiter + isDoneStatus + delimiter + description);
            } else if (command == 'E' || command == 'D') {
                bufferedWriter.write(command + delimiter + isDoneStatus + delimiter + description + delimiter + Arrays.toString(duration));
            }

            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method is called when user requests to mark a particular task as done
     * Method takes in the description of the task to be marked as done.
     * duke.txt file is read line by line and is parsed into StringBuffer
     * Replaces the status of the task found using the description
     * Overwrites duke.txt
     *
     * @param description  Description of the task to be marked as done.
     */
    // Solution adapted from
    // https://stackoverflow.com/questions/20039980/java-replace-line-in-text-filehttps://stackoverflow.com/questions/20039980/java-replace-line-in-text-file with minor modifications
    public static void replaceDoneStatus(String description) {
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));

            // input the file content from duke.txt to StringBuffer so that the done status can be replaced
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }

            String inputStr = inputBuffer.toString();
            file.close();

            inputStr = inputStr.replace("| N | " + description, "| Y | " + description);

            // write the new string with the replaced line on the duke.txt file
            FileWriter writer = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(inputStr);
            bufferedWriter.close();

        } catch (Exception e) {
            ExceptionMessage.printErrorMessage("Cannot read file.");
        }
    }

    /**
     * Method is called when user requests to delete a particular task
     * Method takes in the description of the task to be deleted.
     * Creates a new temporary file called temp.txt
     * Reads the lines from duke.txt, and copies it over to temp.txt
     * If the line contains the description it replaces it with an empty String.
     * Deletes duke.txt and renames temp.txt to duke.txt
     *
     * @param description  Description of the task to be deleted
     */
    // Solution adapted from
    // https://stackoverflow.com/questions/45211060/how-to-delete-or-remove-a-specific-line-from-a-text-filehttps://stackoverflow.com/questions/45211060/how-to-delete-or-remove-a-specific-line-from-a-text-file
    public static void removeLine(String description) throws IOException{
        File tempFile = new File("temp.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));

        FileReader file = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(file);

        String currentLine;

        while((currentLine = bufferedReader.readLine()) != null){
            if(currentLine.trim().contains(description)){
                currentLine = "";
                bufferedWriter.write(currentLine);
            } else {
                bufferedWriter.write(currentLine + System.getProperty("line.separator"));
            }

        }

        bufferedWriter.close();
        bufferedReader.close();

        // Solution adapted from
        // https://www.w3schools.com/java/java_files_delete.asphttps://www.w3schools.com/java/java_files_delete.asp
        File renameFile = new File("duke.txt");
        if (renameFile.delete()) {
            System.out.println("Deleted the file: " + renameFile.getName());
        }

        boolean rename = tempFile.renameTo(renameFile);
        if(rename) {
            System.out.println("Created and updated the file: " + renameFile.getName());
        }
    }

}
