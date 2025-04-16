/* Name: Ashwidhi Chidimilla
 * Roll No :
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Reads the data/integers from the file and sums them up.
 *
 * @author Ashwidhi Chidimilla
 */
public class FileIO {
    public static void main(String[] args) {
        try {
            // Create a File object for the file "3nums.txt"
            File file = new File("3nums.txt");

            // Create a Scanner object to read from the file
            Scanner scanner = new Scanner(file);

            int character;
            int sum = 0;

            System.out.println("Reading numbers from file '3nums.txt' ");

            // Read integers from the file and sum them up
            while (scanner.hasNextInt()) {
                character = scanner.nextInt();
                sum += character;
            }

            // Print the sum of the numbers read from the file
            System.out.println("Sum of the numbers read from file: " + sum);

        } catch (IOException ioException) {
            // Handle any IO exceptions that occur
            System.out.println("Exception while doing IO on file: " + ioException);
        }
    }
}