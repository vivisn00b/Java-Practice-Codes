package OOPs.src.com.viv.ExceptionHandeling;

import java.io.*;

public class ThrowThrows {

    // throws keyword is used here to declare that this method might throw IOException
    public static void readFile(String filename) throws IOException {
        File file = new File(filename);

        if (!file.exists()) {
            // throw keyword used here to throw an actual exception
            throw new IOException("File not found!");
        }
    }

    public static void main(String[] args) {
        try {
            readFile("anything.txt");
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());;
        }
    }
}
