/* Name: Ashwidhi Chidimilla
 *  Roll No :
 * */
import java.io.*;
import java.util.Scanner;
/**
 * EncryptDecrypt class provides functionality to encrypt and decrypt names using XOR operation.
 * It reads a password from the keyboard and offers two options: saving an encrypted name to a file
 * or loading and decrypting a name from a file.
 *
 * @author Ashwidhi Chidimilla
 */
public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.println("Choose an option:");
        System.out.println("1. Enter your name and a filename to save");
        System.out.println("2. Enter a filename to load and decrypt");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter filename to save: ");
                String saveFilename = scanner.nextLine();
                saveEncryptedName(name, password, saveFilename);
                break;
            case 2:
                System.out.print("Enter filename to load: ");
                String loadFilename = scanner.nextLine();
                String decryptedName = loadAndDecryptName(password, loadFilename);
                System.out.println("Decrypted name: " + decryptedName);
                break;
            default:
                System.out.println("Invalid option");
        }

        scanner.close();
    }

    /**
     * Saves the encrypted name to a file.
     *
     * @author Ashwidhi Chidimilla
     * @param name The name to be encrypted.
     * @param password The password used for encryption.
     * @param filename The name of the file to save the encrypted name.
     */
    private static void saveEncryptedName(String name, String password, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String encryptedName = xorEncryptDecrypt(name, password);
            writer.write(encryptedName);
            System.out.println("Name saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the encrypted name from a file and decrypts it.
     *
     * @author Ashwidhi Chidimilla
     * @param password The password used for decryption.
     * @param filename The name of the file to load the encrypted name from.
     * @return The decrypted name.
     */
    private static String loadAndDecryptName(String password, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String encryptedName = reader.readLine();
            return xorEncryptDecrypt(encryptedName, password);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Encrypts or decrypts a string using XOR operation with the given key.
     *
     * @author Ashwidhi Chidimilla
     * @param input The string to be encrypted or decrypted.
     * @param key The key used for XOR operation.
     * @return The encrypted or decrypted string.
     */
    private static String xorEncryptDecrypt(String input, String key) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) ^ key.charAt(i % key.length())));
        }
        return output.toString();
    }
}