/* Name: Ashwidhi Chidimilla
 *  Roll No :
 * */

import java.util.Scanner;

/*
 * PascalTriangle class is used to print Pascal's Triangle up to a given number of rows
 * @author : Ashwidhi Chidimilla
 * */
public class PascalTriangle {

    /*
     * printPascalTriangle prints Pascal's Triangle up to n rows
     * @author : Ashwidhi Chidimilla
     * @param int n - number of rows
     * */
    public static void printPascalTriangle(int n) {
        for (int line = 0; line < n; line++) {
            int number = 1;
            for (int i = 0; i <= line; i++) {
                System.out.print(number + " ");
                number = number * (line - i) / (i + 1);
            }
            System.out.println();
        }
    }

    /*
     * Main method from where the program starts
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows for Pascal's Triangle: ");
        int rows = scanner.nextInt();
        printPascalTriangle(rows);
    }
}