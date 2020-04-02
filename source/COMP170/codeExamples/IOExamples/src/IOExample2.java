
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOExample2 {

    private static final String[] namesOfDays =  {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    private int[] temperature = new int[7];

    public IOExample2() {} // default constructor placeholder

    public void collectData() {
        String fn = "temperatures.txt";
        Scanner f = null;
        try {
             f = new Scanner(new File(fn));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error opening file " + e);
                    System.exit(0);
        }
        int i=0;
        while (f.hasNextLine()) {
            temperature[i] = f.nextInt();
            i++;
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
        IOExample2 ioDemo = new IOExample2();
        ioDemo.collectData();
        System.out.println("The average temperature for the week was: " + ioDemo.computerAverage());
        System.out.println("The highest temperature for the week was: " + ioDemo.computeMax());
        System.out.println("The lowest temperature for the week was: " + ioDemo.computeMin());
    }
}
