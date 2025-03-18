import java.util.Scanner;

public class ReverseInput {
    public static long reverse(long n){
        long result = 0;
        //remove the extra zero's at the end of the input, so when we reverse they don't appear at start
        while(n%10 == 0){
            n /= 10;
        }
        //take each number using remainder and form the reversed number 
        while(n > 0){
            result = (result * 10) + (n%10);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println("Please provide a input number that you wish to see in reverse order : ");
        //to read the input from user
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();
        input.close();
        System.out.println("Here is your number in reverse order : " + reverse(number));
    }
}
