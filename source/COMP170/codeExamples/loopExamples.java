import java.util.Scanner;
import java.util.Random; 

class loopExamples {

    public static final int ASCII_LOWER_A =  97; 
    public static final int ASCII_UPPER_A =  65;

    Scanner keyboard = new Scanner(System.in);

    /**
     * method reverseWord() receives a String from the user, computes
     * its length, and places the String's letters in reverse order into
     * a second String which it then prints.
     *
     * n .................. (int) input String's length
     * wordToReverse ...... (String) user input
     * index .............. (int) counter for input String's letters
     * wordToReverse ...... (String) output String
     */

    public void reverseWord() {

        System.out.println("\n\nReverse word demo -- enter a word");
        String wordToReverse = keyboard.next();

        int n = wordToReverse.length();
        int index = n-1;
        String reversedWord = "";

        while ( index >= 0 ) {
            reversedWord = reversedWord + wordToReverse.charAt(index);
            index--;
        }
        System.out.println("\nThe reverse of \""+wordToReverse+"\" is: "+reversedWord);

    }

    /**
     * method randomWords() prints a sentence of randomly generated words.
     * The number of words in the sentence and the number of letters in those
     * words are specified by the user. The words do not follow any syntax
     * or grammar rules except that the first letter of the first word is
     * capitalized.
     *
     * random ............. random integers to select letters at random
     *                      based on ASCII values. For random upper case
     *                      letters, we add a random number 0-26 to
     *                      ASCII_UPPER_A (65). For random lower case letters,
     *                      we add a random number 0-26 to ASCII_LOWER_A (97).
     *                      ASCII_UPPER_A and ASCII_LOWER_A are public static
     *                      final fields for the class loopExamples.
     * numberOfWords ...... (int) The number of words in the output sentence.
     * maxLetters ......... (int) The maximun number of letters a word can have.
     * counter ............ (int) A counter for the words we build.
     * phrase ............. (String) The output sentence.
     * wordLength ......... (int) A random number 1-maxLetters that determines the number
     *                      letters in the current word.
     * word ............... (String) The current word we are building.
     * wordIndex .......... (int) The counte of current letter position in the current word.
     *                      It tells us that when we are done building a word with wordLength letters.
     * fromASCII .......... (int) Selects upper or lower case letters. We use upper case letters
     *                      only for the first letter of the first word of the sentence.
     * randomChar ......... (int) a random integer that selects a letter from A-Z or a-z.
     */
    public void randomWords() {
			
        int wordLength, wordIndex, fromASCII, toASCII, randomChar;
        String word, phrase;

        Random random = new Random();

        System.out.println("\n\nRandom words demo -- how many words do you want?");
        int numberOfWords = keyboard.nextInt();
        System.out.println("How many letters in the longest word do you wish?");
        int maxLetters = keyboard.nextInt();

        int counter = 1;
        phrase = "";

        while (counter < numberOfWords+1) {

            wordLength = 1+random.nextInt(maxLetters-1);
            wordIndex = 1;
            word = "";

            while (wordIndex <= wordLength+1) {

                if ( counter == 1 && wordIndex == 1) {
					// first letter of first word must be in upper case
                    fromASCII = ASCII_UPPER_A ;
                } else {
                    fromASCII = ASCII_LOWER_A ;
                }

                randomChar= fromASCII + random.nextInt(26);
                word = word+Character.toString((char) randomChar); 
                wordIndex++;
            }

            phrase = phrase+" "+word;
            counter++;
        }

        System.out.println("\nYour random phrase is:\n\t"+phrase+".");
    }

    /**
     * method zipWords() takes two words (as Strings) and interlaces them
     * letter for letter.
     *
     * firstWord .......... (String) The first of the two words to interlace.
     * secondWord ......... (String) The second of the two words to interlace.
     * lengthFirstWord .... (int) Length of first word.
     * lengthSecondWord ... (int) Length of second word.
     * maxLength .......... (int) Length of the longest word.
     * minLength .......... (int) Length of the longest word.
     * longWord ........... (String) The longest of the two words.
     * shortWord .......... (String) The shortest of the two words.
     * zipWord ............ (String) The two words interlaced together.
     * index .............. (int) A counter, moving through the longest word.
     */

    public void zipWords() {

        System.out.println("\n\nZip two words demo -- enter first word:");
        String firstWord = keyboard.next();
        System.out.println("Enter second word:");
        String secondWord = keyboard.next();

        int lengthFirstWord = firstWord.length();
        int lengthSecondWord = secondWord.length();
        int maxLength = lengthFirstWord;
        int minLength = lengthSecondWord;
        String longWord = firstWord;
        String shortWord = secondWord;
        if ( lengthFirstWord<lengthSecondWord) {
            maxLength = lengthSecondWord;
            minLength = lengthFirstWord;
            longWord = secondWord;
            shortWord = firstWord;
        }

        String zipWord = "";
        int index = 0;

        while ( index<maxLength ) {

            if ( index < minLength) {
                // As long as we still have letters to go in the shortest of the two words
                zipWord = zipWord + longWord.charAt(index) + shortWord.charAt(index);
            } else {
                // We are out of letters in the shortest of the two words; using letters
                // from the longest words now.
                zipWord = zipWord + longWord.charAt(index);
            }

            index++;
        }
        System.out.println("\nZipping \""+longWord+"\" and \""+shortWord+"\":\n\t"+zipWord);
    }

    /**
     * method centerStack() centers two words printed on two lines.
     */

    public void centerStack() {

        System.out.println("\n\nCenter-stack two words demo -- enter first word:");
        String firstWord = keyboard.next();
        System.out.println("Enter second word:");
        String secondWord = keyboard.next();

        int lengthFirstWord = firstWord.length();
        int lengthSecondWord = secondWord.length();
        if ( lengthFirstWord%2 == 1 ) lengthFirstWord=lengthFirstWord-1;
        if ( lengthSecondWord%2 == 1 ) lengthSecondWord=lengthSecondWord-1;
        int maxLength = 2+Math.max(lengthFirstWord, lengthSecondWord);
        String line1 = "-".repeat(2*maxLength);
        String line2 = " ".repeat(maxLength-lengthFirstWord/2)+firstWord;
        String line3 = " ".repeat(maxLength-lengthSecondWord/2)+secondWord;
        String line4 = "-".repeat(2*maxLength);

        System.out.println("\nCenter-stacking \""+firstWord+
            "\" and \""+secondWord+"\" yields:\n"+
            line1+"\n"+line2+"\n"+line3+"\n"+line4);
    }

    public void verticalWord() {

        System.out.println("\n\nVertical word demo -- enter word to print vertically:");
        String word = keyboard.next();
        int wordLength = word.length();
        int index = 0;
        System.out.println("\n\""+word+"\" printed vertically is:");

        while ( index < wordLength ) {
            System.out.println("\t"+word.charAt(index));
            index++;
        }

    }

    public void spaceOut(){

        System.out.println("\n\nSpace-out demo -- enter word to space-out:");
        String word = keyboard.next();
        int wordLength = word.length();
        int index = 0;
        String spacedOut = "";

        while ( index < wordLength ) {
            spacedOut = spacedOut + word.charAt(index)+" ";
            index++;
        }

        System.out.println("\n\""+word+"\" spaced-out: "+spacedOut);
    }

    public static void main(String[] args) {
        // Let's instantiate our class
        loopExamples examples = new loopExamples();

        boolean runMenu=true;
        String menuInput;

        Scanner menu = new Scanner(System.in);

        while (runMenu) {

            System.out.println("\n\n**********************************");
            System.out.println("*              Menu              *");
            System.out.println("**********************************");
            System.out.println("*   0. Exit this program         *");
            System.out.println("*   1. Reverse a word            *");
            System.out.println("*   2. Random words              *");
            System.out.println("*   3. Zip two words             *");
            System.out.println("*   4. Center-stack two words    *");
            System.out.println("*   5. Print a word vertically   *");
            System.out.println("*   6. Space out a word          *");
            System.out.println("**********************************");

            menuInput=menu.next();

            switch (menuInput) {

                case "0":
                runMenu=false;
                break;

                case "1":
                examples.reverseWord();
                break;

                case "2":
                examples.randomWords();
                break;

                case "3":
                examples.zipWords();
                break;

                case "4":
                examples.centerStack();
                break;

                case "5":
                examples.verticalWord();
                break;

                case "6":
                examples.spaceOut();
                break;
            }
        }
        System.out.println("\n\nTHANK YOU for using the demo.");
    }
}
 