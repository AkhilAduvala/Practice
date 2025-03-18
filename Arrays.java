/*
* Write a program to shuffle the elements in an array.
* For example:
* Input : { 1, 2, 3, 4, 5, 6 }
* Output: [4, 2, 6, 5, 1, 3]
* */
import java.util.Random;

public class Arrays {
    public static void shuffle(int[] input) {
        Random rand = new Random();
        for (int i = input.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap input[i] with the element at random index
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5, 6 };
        shuffle(input);
        for (int i : input) {
            System.out.println(i);
        }
    }
}