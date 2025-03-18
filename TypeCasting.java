/*
* Write a program to help detective Parker to decode the message sent to his collegue.
* message = {74, 97, 118, 97, 32, 105, 115, 32, 103, 114, 101, 97, 116};
* */

public class TypeCasting {

    public String decode(int[] input){
        char[] decodedChars = new char[input.length];
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < input.length; i++){
            decodedChars[i] = (char) input[i];
        }
        for (char decodedChar : decodedChars) {
            result.append(decodedChar);
        }
        return result.toString();
    }

    public static void main(String[] args){
        int[] encodedMsg = {74, 97, 118, 97, 32, 105, 115, 32, 103, 114, 101, 97, 116};
        TypeCasting typeCasting = new TypeCasting();
        String decodeMsg = typeCasting.decode(encodedMsg);
        System.out.println("Here is the decode msg for you : " + decodeMsg);
    }
}
