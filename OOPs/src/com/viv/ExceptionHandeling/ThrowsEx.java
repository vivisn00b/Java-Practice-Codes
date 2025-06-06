package OOPs.src.com.viv.ExceptionHandeling;

import java.io.*;

public class ThrowsEx {
    // It is used to declare that a method might throw one or more exceptions.
    public static void readFile(String filename) throws IOException{
        FileReader file = new FileReader(filename);
        BufferedReader reader = new BufferedReader(file);
        String line = reader.readLine();
        System.out.println("File content: " + line);
        reader.close();
    }

    public static void main(String[] args) {
        try {
            readFile("input.txt");
        } catch (IOException e) {
            System.out.println("Exception caught: "+e.getMessage());
        }
    }
}
