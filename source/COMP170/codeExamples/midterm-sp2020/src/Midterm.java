import java.util.Scanner;

public class Midterm {

    private static final int SILLYNUMBER=100;

    public static void main(String[] args) {

        boolean repeat=true; // what is this about
        int i,j=0;
        int howMany; // where am I using this
        String symbol; // etc
        Scanner keyboard = new Scanner(System.in);


        while (repeat) {
            System.out.println("How many lines to print? (0 or negative number will end the program)");
            howMany = keyboard.nextInt();
            if (howMany <= 0) {
                repeat = false;
            } else {
                if (howMany > SILLYNUMBER) {
                    System.out.println("Don't be silly!");
                } else {
                    System.out.println("What symbol shall I use?");
                    symbol = keyboard.next();
                    System.out.println("\n\nUsing the repeat method:\n");

                    for ( i=1; i <= 2*howMany; i++) {
                        /*
                        if (i <= howMany) {
                            j++;
                    } else {
                        j--;
                    }
 */
                        j = howMany - Math.abs(i-howMany);
                        System.out.println(symbol.repeat(j));
                    }

                }
            }
        }
    }
}