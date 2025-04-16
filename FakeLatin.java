/* Name: Ashwidhi Chidimilla
*  Roll No :
* */

import java.util.Scanner;

/*
 * @author : Ashwidhi Chidimilla
 * FakeLatin class is used to convert text to latin and back
 * */
public class FakeLatin {

    /*
     * toFakeLatin convert original text to fake latin
     * @param String original input
     * @returns String converted to latin
     * */
    public static String toFakeLatin(String input){
        StringBuilder output = new StringBuilder();
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 1) {
                String fakeLatinWord = word.substring(1) + word.charAt(0) + "ay";
                if (i == 0) {
                    fakeLatinWord = Character.toUpperCase(fakeLatinWord.charAt(0)) + fakeLatinWord.substring(1).toLowerCase();
                }
                output.append(fakeLatinWord).append(" ");
            } else {
                output.append(word).append("ay ");
            }
        }
        return output.toString().trim();
    }

    /*
     * fromFakeLatin convert fake latin to original text
     * @param String fake latin
     * @returns String latin converted to original text
     * */
    public static String fromFakeLatin(String input){
        StringBuilder output = new StringBuilder();
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 2) {
                String originalWord = word.charAt(word.length() - 3) + word.substring(0, word.length() - 3);
                if (i == 0) {
                    originalWord = Character.toUpperCase(originalWord.charAt(0)) + originalWord.substring(1).toLowerCase();
                }
                output.append(originalWord).append(" ");
            } else {
                output.append(word).append(" ");
            }
        }
        return output.toString().trim();
    }

    /*
    * Main method from where the program starts
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to convert \"toLatin\" or \"fromLatin\"");
        String selection = scanner.next();
        //read the user selection
        scanner.nextLine();
        if (selection.equalsIgnoreCase("toLatin")) {
            System.out.println("Please enter the input you want to convert to Fake Latin: ");
            String userInput = scanner.nextLine();
            System.out.println("Here is the text converted to Fake Latin: " + toFakeLatin(userInput));
        } else if (selection.equalsIgnoreCase("fromLatin")) {
            System.out.println("Please enter the input you want to convert from Fake Latin: ");
            String userInput = scanner.nextLine();
            System.out.println("Here is the original text converted from Fake Latin: " + fromFakeLatin(userInput));
        } else {
            //if the user has not selceted from given option
            System.out.println("Please select valid input \"toLatin\" or \"fromLatin\"");
        }
    }
}