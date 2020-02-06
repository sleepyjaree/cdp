import java.util.Scanner;

public class newton {
    public static void main(String[] args) {

        Scanner oxfordshire = new Scanner(System.in);
        System.out.println("Please enter a number and I'll find its square root:");
        double n = oxfordshire.nextDouble();
        System.out.println("Please enter accuracy: ");
        double epsilon = oxfordshire.nextDouble();

        double xCurrent = 1.0;
        double xNext, delta;
        int counter = 1;

        do {
            xNext = 0.5 * ( xCurrent + n/xCurrent );
            delta = Math.abs(xNext-xCurrent);     

            System.out.println("\nIteration: "+counter+
                "\n\tcurrent estimate is: "+xNext+
                "\n\twhich is within "+delta+" of previous estimate");

            xCurrent = xNext;
            
            counter++;

        } while (delta>epsilon);

        System.out.println("\nThe approximate square root of "+
            n+" is "+xNext);
        System.out.println("The actual square root of "+
            n+" is "+Math.sqrt(n));

    }
}
