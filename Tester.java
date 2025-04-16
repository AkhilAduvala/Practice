import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args){
//        System.out.println("Please enter a Number : ");
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//
//        RecursionLevel1 r = new RecursionLevel1();
//        r.print(n);
//        r.printReverse(n);
//        int sum = RecursionLevel1.SumOfFirstNNumbers(n);
//        System.out.println(sum);
//        BigInteger factorial =  r.factorial(n);
//        System.out.println(factorial);
//        int digitsSum = r.sumOfDigits(n);
//        System.out.println(digitsSum);

//        System.out.println("Please enter a String : ");
//        //String s = input.nextLine();
//
//        RecursionLevel2 r2 = new RecursionLevel2();
//        //System.out.println(r2.reverseString(s));
//        System.out.println(r2.fibonacci(4));
//        input.close();

//        Solution s = new Solution();
//        int[] a = new int[]{0,0,1,1,1,2,2,3,3,4,4};
//        List<List<Integer>> l = s.threeSum(a);
//        System.out.println(l);
//        int nonDuplicateCount = s.removeDuplicates(a);
//        for (int i = 0; i <= nonDuplicateCount; i++){
//            System.out.println(a[i]);
//        }

        ReverseInput rip = new ReverseInput();
        System.out.println(rip.reverse(123450050));

    }
}
