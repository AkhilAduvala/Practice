import java.util.Scanner;

public class SumOfDigits {
    public static long merge(long n){
        long result = 0;
        //we take each digit and add it up to the result
        while(n > 0){
            result += n%10;
            n /= 10;
        }
        System.out.println(result);
        //we will recursively call the merge method to sum up digits if the result is not a single digit
        if(result > 9){
            result = merge(result);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println("Please provide a input number that you wish to know sum of its digits : ");
        //to read the input from user
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();
        input.close();
        System.out.println("Here is sum of digits for your input : " + merge(number));
    }
}
