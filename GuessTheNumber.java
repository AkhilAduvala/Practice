/*
 * Name : Ashwidhi Chidimilla
 * Roll No :
 * Course :
 * */
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/*
 * @author Ashiwdhi Chidimilla
 * GuessTheNumber is the logic to count how many attempts to guess a random number
 * */
public class GuessTheNumber {

    /*
     * main method from where the program execution starts
     * */
    public static void main(String[] args){

        //to store the numbers that user has guessed
        Set<Integer> guessed = new HashSet<>();

        //generate a random number
        int number = randomGenerator();

        Scanner scanner = new Scanner(System.in);
        int input;

        //continue to take input from user until the guessed value is same as expected
        do{
            System.out.println("Please enter a number between 20 & 10,000,000 : ");
            input = scanner.nextInt();
            guessed.add(input);
            if(number > input){
                System.out.println("Guessed value is too Small");
            } else if (number < input) {
                System.out.println("Guessed value is too Large");
            }
        }while(number != input);

        scanner.close();

        System.out.println(input + " Correct, you have guessed it in " + guessed.size() + " steps!");
    }

    /*
     * @author Ashiwdhi Chidimilla
     *
     * randomGenerator method to generate a number between 20 & 10000000
     * @param no params
     * @return int
     * */
    public static int randomGenerator(){
        Random random = new Random();
        return random.nextInt(10000000 - 20 + 1) + 20;
    }
}
