import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class ReadNumbers {
    public static void main(String[] args) {
        String filename = "scores.txt";
        readFile(filename);
    }

    static void readFile(String filename) {
        // Read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // check to see if it's a number; print if it is
                try {
                    int n = Integer.parseInt(line.trim());
                    System.out.println(n);
                } catch (NumberFormatException e) {
                    // Ignore non-numeric lines
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
} 