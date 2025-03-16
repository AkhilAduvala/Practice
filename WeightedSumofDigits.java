/*
 * Name : Ashwidhi Chidimilla
 * Roll No :
 * Course :
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author Ashiwdhi Chidimilla
 * WeightedSumofDigits is the logic to find weighted sum of input number
 * */
public class WeightedSumofDigits {

    /*
     * main method from where the program execution starts
     * */
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number : ");

        //read the input from user
        int number = scanner.nextInt();

        System.out.println("wsd(" + number + ") is " + wsd(number));

        scanner.close();
    }

    /*
     * @author Ashiwdhi Chidimilla
     *
     * wsd method finds the weight of digit in the number and sums it up
     * @param int number
     * @return int weighted sum of digits
     * */
    public static int wsd(int number){

        int place = 1;
        int sum = 0;

        //to store the digits of the input number
        List<Integer> digits = new ArrayList<>();

        //loop extract the digits and add in list
        while(number > 0){
            digits.add(number%10);
            number = number/10;
        }

        //sum of digits according to their weight(place)
        for(int i = digits.size() - 1; i >= 0; i--){
            sum += digits.get(i) * place;
            place++;
        }

        return sum;
    }
}
