import java.util.Scanner;

/**
 * A simple class that prints a specified number of lines, each with an
 * increasing sequence of a symbol, like so:
 *    Line 1: #    (one copy of the symbol #)
 *    Line 2: ##   (two copies of the symbol #)
 *    Line 3: ###  (three copies of the symbol #), etc
 * using the .repeat() method.
 */

public class Midterm {

    /**
     * SILLYNUMBER sets an upper limit as to how many lines we can print
     */
    private static final int SILLYNUMBER=100;

    public static void main(String[] args) {

        boolean keepGoing=true;  // Controls main loop; false when howMany<1
        int i;                   // Loop index
        int howMany;             // Number of lines to print;  < SILLYNUMBER
        String symbol;           // Symbol to print

        Scanner keyboard = new Scanner(System.in);

        while (keepGoing) {

            System.out.println("\nHow many lines to print? (0 or negative number will end the program)");
            howMany = keyboard.nextInt();

            if ( howMany <= 0 ) {

                keepGoing = false; // End the program

            } else {

                if ( howMany > SILLYNUMBER ) {

                    System.out.println("Don't be silly!");

                } else {

                    System.out.println("What symbol shall I use?");
                    symbol = keyboard.next();

                    for ( i=1; i <= howMany; i++) {

                        System.out.println(symbol.repeat(i));

                    } // for

                } // if

            } // if

        } // while

    } // method main

} // class Midterm