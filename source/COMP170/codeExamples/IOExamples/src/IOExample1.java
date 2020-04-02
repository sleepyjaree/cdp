
import java.util.Scanner;

public class IOExample1 {

    private static final String[] namesOfDays =  {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    private int[] temperature = new int[7];

    public IOExample1() {} // default constructor placeholder

    public void collectData() {
        Scanner k = new Scanner(System.in);
        for (int i=0;i<7;i++) {
            System.out.println("Enter the temperature for "+namesOfDays[i]+": ");
            temperature[i] = k.nextInt();
        }
    }

    public double computerAverage() {
        double avg = 0;
        for (int i=0; i<temperature.length; i++) {
            avg = avg + temperature[i];
        }
        return avg/temperature.length;
    }

    public int computeMin() {
        int minimum = temperature[0];
        for (int i=1;i<temperature.length;i++) {
            if (temperature[i]<minimum) { minimum = temperature[i]; }
        }
        return minimum;
    }
    public int computeMax() {
        int maximum = temperature[0];
        for (int i=1;i<temperature.length;i++) {
            if (temperature[i]>maximum) { maximum = temperature[i]; }
        }
        return maximum;
    }

    public static void main(String[] args) {
        IOExample1 ioDemo = new IOExample1();
        ioDemo.collectData();
        System.out.println("The average temperature for the week was: " + ioDemo.computerAverage());
        System.out.println("The highest temperature for the week was: " + ioDemo.computeMax());
        System.out.println("The lowest temperature for the week was: " + ioDemo.computeMin());
    }
}
