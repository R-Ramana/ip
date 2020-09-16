package ip.filemanager;

import java.io.*;


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
    public static void readFile() {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
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

}
