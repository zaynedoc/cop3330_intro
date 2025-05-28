package file_io;
import java.io.*; // Importing all classes for file input/output operations

public class Main {
    public static void main(String[] args) {
        String filePath = "/workspaces/COP3330_intro/src/file_io/message.txt"; // Example of absolute path
        // Absolute file path example from IDE: "C:/Users/.../ideaProjects/IntroProj/src/file_io/message.txt"

        String fileText = """
                            I like Swedish Fish
                            They taste so good
                            Yummers
                            This is not a haiku
                            """;    // 3 pairs of quotes to do newlines from .java to .txt

        // File accessing:
        File file = new File(filePath);

        if(file.exists()) {
            System.out.println("Found file in src:");
             System.out.println(file.getPath()); // Prints file path
            // System.out.println(file.isFile());  boolean value; found = true; not found = false
            // file.delete(); deletes the file, very useful but dangerous
        } else {
            System.out.println("File not found in src");
        }

        // Exception handling; what if we don't find the file?
            // FileWriting; editing the file's contents
        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(fileText);
            System.out.println("\nFileWriter: file has been written");
        }
        catch(FileNotFoundException e) {    // "catch" exception/error
            System.out.println("\nFileWriter: could not locate file path");
        }
        catch(IOException e) {
            System.out.println("\nFileWriter: unable to write file");
        }

        // BufferedReader: read the file's contents
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            System.out.println("\nBufferedReader: file is being read\nFile contents:");

            String line;
            // "while we read line of [file], assuming line in [file] to String line"
            // "keep reading until EOF (end of file), which will return NULL"
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(FileNotFoundException e) {    // "catch" exception/error
            System.out.println("\nBufferedReader: could not locate file path");
        }
        catch(IOException e) {
            System.out.println("\nBufferedReader: unable to write file");
        }
    }
}