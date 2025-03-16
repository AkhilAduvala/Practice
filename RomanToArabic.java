/*
 * Name : Ashwidhi Chidimilla
 * Roll No :
 * Course :
 * */
import java.util.*;

/*
 * @author Ashiwdhi Chidimilla
 * Convert the number from Roman to Arabic
 * */
public class RomanToArabic {
    // Roman numeral values
    private static final Map<Character, Integer> ROMAN_VALUES = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000
    );

    // Valid symbols for subtraction
    private static final Map<Character, Set<Character>> VALID_SUBTRACTIONS = Map.of(
            'I', Set.of('V', 'X'),
            'X', Set.of('L', 'C'),
            'C', Set.of('D', 'M')
    );

    /*
     * main method from where the program execution starts
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String roman = scanner.nextLine().trim();
            int result = convertRomanToArabic(roman);
            if (result != -1) {
                System.out.println(result);
            }
        }
        scanner.close();
    }

    /*
     * @author Ashiwdhi Chidimilla
     *
     * convertRomanToArabic method to convert Roman(String) to Arabic(int)
     * @param String
     * @return int
     * */
    public static int convertRomanToArabic(String roman) {
        if (roman.isEmpty()) return -1;

        // Rule 1: Check for invalid characters
        for (char c : roman.toCharArray()) {
            if (!ROMAN_VALUES.containsKey(c)) {
                System.out.println("1 Invalid character in input. Valid characters are I,V,X,L,C,D,M.");
                return -1;
            }
        }

        int length = roman.length();
        int total = 0;
        int prevValue = 0;
        int repeatCount = 1;
        char lastChar = roman.charAt(0);
        boolean lastWasSubtraction = false;

        for (int i = 0; i < length; i++) {
            char currentChar = roman.charAt(i);
            int currentValue = ROMAN_VALUES.get(currentChar);

            // Rule 5: Check for invalid repetition of V, L, D
            if ((currentChar == 'V' || currentChar == 'L' || currentChar == 'D') && i > 0 && currentChar == lastChar) {
                System.out.println("5 Invalid repetition of V, L or D.");
                return -1;
            }

            // Rule 6: Check for excessive repetition
            if (i > 0 && currentChar == lastChar) {
                repeatCount++;
                if (repeatCount > 3) {
                    System.out.println("6 Too long repetition.");
                    return -1;
                }
            } else {
                repeatCount = 1;
            }

            // Rule 2: Can't subtract auxiliary symbols (V, L, D)
            if (prevValue > 0 && prevValue < currentValue) {
                if (lastChar == 'V' || lastChar == 'L' || lastChar == 'D') {
                    System.out.println("2 Invalid numeral: can't subtract auxiliary symbol.");
                    return -1;
                }

                // Rule 3: Can't do two consecutive subtractions
                if (lastWasSubtraction) {
                    System.out.println("3 Invalid numeral: two consecutive subtractions.");
                    return -1;
                }

                // Rule 7: Check valid subtraction pairs
                if (!VALID_SUBTRACTIONS.containsKey(lastChar) || !VALID_SUBTRACTIONS.get(lastChar).contains(currentChar)) {
                    System.out.println("7 Wrong subtraction.");
                    return -1;
                }

                // Rule 8: Cannot subtract more than one from a particular symbol
                if (i > 1 && roman.charAt(i - 2) == lastChar && prevValue < currentValue) {
                    System.out.println("8 Cannot subtract more than one from a particular symbol.");
                    return -1;
                }

                total += currentValue - 2 * prevValue; // Adjust for subtraction
                lastWasSubtraction = true;
            } else {
                // Rule 4: Additions must decrease
                if (prevValue > 0 && currentValue > prevValue) {
                    System.out.println("4 Invalid numeral: additions don't decrease.");
                    return -1;
                }

                total += currentValue;
                lastWasSubtraction = false;
            }

            prevValue = currentValue;
            lastChar = currentChar;
        }
        return total;
    }
}
