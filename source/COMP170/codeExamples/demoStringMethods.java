
/**
 * A brief demo for select String methods. These methods are described on
 * page 88 of the Savitch textbook.
 *
 * @author Leo Irakliotis
 * @version 01 FEB 2020
 */
public class demoStringMethods
{
    /**
     * quotation is one of the two strings we use for the demo
     */
    public static final String quotation = 
        "It was the best of times, it was the worst of times";

    /**
     * capsLocked is an upper case version of the quotation string
     */
    public static final String capsLocked = 
        "IT WAS THE BEST OF TIMES, IT WAS THE WORST OF TIMES";

    public static void main(String[] args) {

        System.out.println("\nA demonstration of String class methods");   
        System.out.println("\nMethods will be applied on the following String:");
        System.out.println(quotation);

        // method length
        int n = quotation.length();
        System.out.println("\n\nThe length of the string is " + n + " characters.");

        //method charAt
        char fourthCharacter = quotation.charAt(3);
        System.out.println("\n\nThe fourth character of the string is " + fourthCharacter + ".");

        // method concat
        String nextPhrase = ", it was the age of wisdom, it was the age of foolishness";
        String newQuotation = quotation.concat(nextPhrase);
        System.out.println("\n\nThe concatenation of the string with the phrase:\n\t"+
            nextPhrase + "\nis:");
        System.out.println(newQuotation);

        // method equals
        boolean same = (quotation.equals(capsLocked));
        System.out.println("\n\nAre the strings\n\t" + quotation +
            "\nand\n\t" + capsLocked +
            "\n\nthe same? Answer: " + same);

        // method equalsIgnoreCase
        //        Notice that in Savitch (p.88) this method is mentioned but its
        //        name is misprinted to equals() instead equalsIgnoreCase()
        same = (quotation.equalsIgnoreCase(capsLocked));
        System.out.println("\n\nAre the strings\n\t" + quotation +
            "\nand\n\t" + capsLocked +
            "\n\nthe same when ignoring upper/lower case? Answer: " + same);

        // method index
        String lookFor = "was";
        int position = quotation.indexOf(lookFor);
        System.out.println("\n\nIn the string:\n\t" +
            quotation +
            "\nthe first appearance of:\n\t" +
            lookFor +
            "\nis at position: " + position);

        // method lastIndexOf
        position = quotation.lastIndexOf(lookFor);
        System.out.println("\n\nIn the string:\n\t" +
            quotation +
            "\nthe last appearance of:\n\t" +
            lookFor +
            "\nis at position: " + position);

        // method toUpperCase
        String quotationUpper = quotation.toUpperCase();
        System.out.println("\n\nThe string\n\t"+
            quotation +
            "\nin upper case is:\n\t"+
            quotationUpper);

        // method replace
        String present = quotation.replace("was","is");
        System.out.println("\n\nThe string\n\t"+
            quotation +
            "\nin present tense, becomes:\n\t"+
            present);

        // method substring
        String littleQuotation;
        littleQuotation= quotation.substring(19,32);
        System.out.println("\n\nA substring of\n\t"+
            quotation +
            "\nis:\n\t"+
            littleQuotation);

    }
}
