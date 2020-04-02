import java.util.Scanner;

/**
 * A class that tests a string input to determine if it is a palindrome.
 * This is programming project 2, chapter 7
 */
public class Palindrome {

    private static final int MAX_STRING_LENGTH = 80;
    private String input;
    private char[] a = new char[MAX_STRING_LENGTH];
    private int lengthInputString;

    /**
     * Obtains an input, checks length, converts to lower case
     */
    public String obtainInput(int maxLength) {
        boolean keepAsking = true;
        String inputString;
        Scanner keyboard = new Scanner(System.in);
        keyboard.useDelimiter("[.]"); // reads until a period is detected
        do {
            System.out.println("\nEnter a string with up to 80 characters or STOP to exit.");
            System.out.println("Terminate your input with a period (.)");
            inputString = keyboard.next();
            int len = inputString.length();
            if (len <= maxLength ) { keepAsking = false; }
            if (inputString.equals("STOP")) { keepAsking = false; }
        } while (keepAsking);
        return inputString.toLowerCase();
    }

    /**
     * Converts a string into a char[]
     * @param stringToConvert
     * @return
     */
    private char[] convertToArray(String stringToConvert) {
        char[] contents = new char[MAX_STRING_LENGTH];
        lengthInputString = stringToConvert.length();
        for (int i=0;i<lengthInputString;i++) {
            contents[i] = stringToConvert.charAt(i);
        }
        return contents;
    }


    /**
     * Determines if the contents of array a[] constitute a palindrome
     * @param a char array with contents of string:input
     * @param used number of used positions in array; we are planning for up
     *             to 80 characters but string:input.length may be < 80
     * @return true is contents in a[] form a palindrome
     *
     * [0] [1] [2] ..... [n-3] [n-2] [n-1]
     *  |   |   |          |     |     |
     *  |   |   |__________|     |     |
     *  |   |____________________|     |
     *  |______________________________|
     *
     */
    private static boolean isPalindrome(char[] a, int used) {
        boolean isPalindrome = true;
        int halfPoint = (int) Math.round(used/2.0)+1;
        for ( int i = 0; i < halfPoint; i++ ) {
            isPalindrome = isPalindrome && (a[i] == a[used-i-1]);
        }
        return isPalindrome;
    }

    public static void main(String args[]) {
        Palindrome demo = new Palindrome();
        boolean runProgram = true;
        do {
            String candidatePalindrome = demo.obtainInput(MAX_STRING_LENGTH);
            if (candidatePalindrome.equals("stop")) {
                runProgram = false;
            } else {
                // isPalindrome requires a char array and its used count as arguments. In the call
                // below, the char array is given as convertToArray(candidatePalindrome), and its
                // used count is lengthInputString.
                //                                                char[]                           int
                //                               ___________________/\__________________  __________/\__________
                boolean isIt = demo.isPalindrome(demo.convertToArray(candidatePalindrome),demo.lengthInputString);
                if (isIt) {
                    System.out.println("\t You got yourself a palindrome");
                } else {
                    System.out.println("\t Not a palindrome");
                }
            }
        } while (runProgram);
    }
}