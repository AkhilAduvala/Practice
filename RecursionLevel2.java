public class RecursionLevel2 {

    public String reverseString(String s) {
        if (s.isEmpty()) return "";
        String x = Character.toString(s.charAt(s.length() - 1)).concat(reverseString(s.substring(0, s.length() - 1)));
        return x;
    }

    public boolean palindrome(String s){
        int i = 0;
        if (i >= s.length()/2) return true;
        if(s.charAt(i) == s.charAt(s.length()-1)){
            palindrome(s.substring(1, s.length()-1));
        }else{
            return false;
        }
        return false;
    }

    public int fibonacci(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}