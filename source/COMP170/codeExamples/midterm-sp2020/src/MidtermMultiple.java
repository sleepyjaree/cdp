import java.util.Scanner;
/**
 * A simple class that prints a specified number of lines, each with an
 * increasing sequence of a symbol, like so:
 *    Line 1: #    (one copy of the symbol #)
 *    Line 2: ##   (two copies of the symbol #)
 *    Line 3: ###  (three copies of the symbol #), etc
 * using the .repeat() method.
 */
public class MidtermMultiple {
    public static void main(String[] args) {
        int sillyNumber = 100;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How many lines to print?");
        int howMany = keyboard.nextInt();

        System.out.println("\nUsing the repeat() method:");
        if ( (howMany > 0 ) && ( howMany <= sillyNumber ) ) {
            for (int i = 1; i <= howMany; i++) {
                System.out.println("#".repeat(i));
            }
        }

        System.out.println("\nNot using the repeat() method:");
        String s = "#";
        for ( int i = 1; i <= howMany; i++ ) {
            System.out.println(s);
            s = s+"#";
        }

        System.out.println("\nAnother way without the repeat() method:");
        for ( int i = 1; i <= howMany; i++ ) {
            for ( int j = 1 ; j <= i; j++ ) {
                System.out.print("#");
            }
            System.out.print("\n");
        }
    }
}