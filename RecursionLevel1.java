import java.math.BigInteger;

public class RecursionLevel1 {
    public void print(int n){
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print(n - 1);
    }

    public void printReverse(int n){
        if(n == 0){
            return;
        }
        printReverse(n-1);
        System.out.println(n);
    }

    public static int SumOfFirstNNumbers(int n){
        if(n == 1) return 1;
        return n + SumOfFirstNNumbers(n-1);
    }

    public BigInteger factorial(int n){
        if(n == 0) return BigInteger.valueOf(1);
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }

    public int sumOfDigits(int n){
        if(n == 0) return 0;
        return n%10 + sumOfDigits(n/10);
    }
}
