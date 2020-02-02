import java.util.Scanner;
public class currencyConverterFormatted {
    /**
     * This is a currency conversion program between USD and EUR
     */
    public static final double EURUSD = 1.11;  // EUR to USD rate
    public static final String USD = "\u0024"; // unicode for USD symbol
    public static final String EUR = "\u20ac"; // unicode for EUR symbol

    public static void main(String[] args) {

        double amountToConvert, amountConverted;
        char fromThisCurrency;
        String fromSymbol, toSymbol;

        Scanner keyboard = new Scanner(System.in);
        amountToConvert = keyboard.nextDouble();
        fromThisCurrency = keyboard.next().charAt(0);

        if ( fromThisCurrency=='D') {
            amountConverted = amountToConvert*(1/EURUSD);
            fromSymbol = USD;
            toSymbol = EUR;
        } else {
            amountConverted = amountToConvert*EURUSD;
            fromSymbol = EUR;
            toSymbol = USD;
        }

        System.out.printf(fromSymbol+"%.2f",amountToConvert);
        System.out.printf(" is the equivalent of ");
        System.out.printf(toSymbol+"%.2f", amountConverted);

    }
}

