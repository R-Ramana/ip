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


public class Storage {

    private static String fileName;

    public Storage(String fileName) {
        Storage.fileName = fileName;
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
    public static void readFile() {

        try {
            FileReader file = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(file);

            String line;
            Task task;

            while ((line = bufferedReader.readLine()) != null) {
                String[] fileLines = line.split("\\|");

                switch (fileLines[0]) {
                case "T ":
                    task = TaskManager.addTodo(fileLines[2]);
                    break;
                case "D ":
                    task = TaskManager.addDeadline(fileLines[2], fileLines[3]);
                    break;
                case "E ":
                    task = TaskManager.addEvent(fileLines[2], fileLines[3]);
                    break;
                default:
                    throw new DukeException("Cannot read file");
                }

                if (fileLines[1].equals(" Y ")) {
                    task.markAsDone();
                }
            }

            file.close();

        } catch (IOException | DukeException e) {
            e.printStackTrace();
        }
    }

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

    // Solution adapted from https://stackoverflow.com/questions/20039980/java-replace-line-in-text-filehttps://stackoverflow.com/questions/20039980/java-replace-line-in-text-file with minor modifications
    public static void replaceDoneStatus(String description) {
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));

            // input the file content from duke.txt to StringBuffer
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }

            String inputStr = inputBuffer.toString();
            file.close();

            // replace task in the string when to done status
            inputStr = inputStr.replace("| N |" + description, "| Y |" + description);

            // write the new string with the replaced line on the duke.txt file
            FileWriter writer = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(inputStr);
            bufferedWriter.close();

        } catch (Exception e) {
            ExceptionMessage.printErrorMessage("Cannot read file.");
        }
    }

    // Solution adapted from https://stackoverflow.com/questions/45211060/how-to-delete-or-remove-a-specific-line-from-a-text-filehttps://stackoverflow.com/questions/45211060/how-to-delete-or-remove-a-specific-line-from-a-text-file
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

        // Solution adapted from https://www.w3schools.com/java/java_files_delete.asphttps://www.w3schools.com/java/java_files_delete.asp
        File renameFile = new File("duke.txt");
        if (renameFile.delete()) {
            System.out.println("Deleted the file: " + renameFile.getName());
        }

        boolean rename = tempFile.renameTo(renameFile);
    }

}
