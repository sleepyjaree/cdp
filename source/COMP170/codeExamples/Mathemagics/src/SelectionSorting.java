import java.util.Random;

public class SelectionSorting {

    public int[] randomArray(int n) {
        int[] a = new int[n];
        Random rand = new Random();
        for ( int i = 0; i < n; i++) {
            a[i] = rand.nextInt(100);
        }
        return a;
    }

}