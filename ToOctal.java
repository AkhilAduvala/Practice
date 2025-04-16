import java.util.Scanner;

public class ToOctal {

    public static long toOctal(long n) {
        long result = 0;
        long place = 1;
        //convert the give decimal to octal by deviding it with 8 and adding to the reuslt based on place of digit
        while (n > 0) {
            long remainder = n % 8;
            result += remainder * place;
            place *= 10;
            n /= 8;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Please enter a decimal number to convert it to octal: ");
        //to read the input from user
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();
        input.close();
        System.out.println("Octal representation: " + toOctal(number));
    }
}
