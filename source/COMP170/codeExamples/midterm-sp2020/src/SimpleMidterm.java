import java.util.Scanner;
/**
 * A simple class that prints a specified number of lines, each with an
 * increasing sequence of a symbol, like so:
 *    Line 1: #    (one copy of the symbol #)
 *    Line 2: ##   (two copies of the symbol #)
 *    Line 3: ###  (three copies of the symbol #), etc
 * using the .repeat() method.
 */
public class SimpleMidterm {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How many lines to print?");
        int howMany = keyboard.nextInt();
        if ( howMany > 0 ) {
            for ( int i = 1; i <= howMany; i++ ) {
                System.out.println("#".repeat(i));
            }
        }
    }
}