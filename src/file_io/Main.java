package file_io;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "/workspaces/COP3330_intro/src/file_io/message.txt";
        String fileText = "I like Swedish Fish";

        // File accessing:
        File file = new File(filePath);
        // Could also do "C:\Users\...\IdeaProjects\IntroProj\src\file_io" <- for deskot IDE
        // or "C:\Users\...\IdeaProjects\IntroProj\src\file_io/message.txt" for specific file

        // In Codespace, the file path is relative to the workspace root
        // Right click on a file/folder, and copy file path to get the absolute path

        if(file.exists()) {
            System.out.println("Found file in src:");
            System.out.println(file.getPath());
            System.out.println(file.isFile());  // False if file is a folder
            // file.delete(); deletes the file, very useful but dangerous
        } else {
            System.out.println("File not found in src");
        }

        // Exception handling
        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(fileText);
            System.out.println("File has been written");
        }
        catch(FileNotFoundException e) {
            System.out.println("Could not locate file path");
        }
        catch(IOException e) {
            System.out.println("Unable to write file");
        }
    }
}