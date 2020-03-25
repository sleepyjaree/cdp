
import java.util.Random;

public class SelectionSorting {

    private static void swap(int p, int q, int[] arrayToSwap) {
        int temp = arrayToSwap[p];
        arrayToSwap[p] = arrayToSwap[q];
        arrayToSwap[q] = temp;
    }

    private static int locationOfSmallerValue(int[] arrayToScan,int positionToScanFrom) {
        int smallestValue = arrayToScan[positionToScanFrom];
        int smallestValueLocation = positionToScanFrom;
        for ( int i =positionToScanFrom+1; i < arrayToScan.length; i++ ) {
            if (arrayToScan[i] < smallestValue) {
                smallestValue = arrayToScan[i];
                smallestValueLocation = i;
            }
        }
        return smallestValueLocation;
    }

    private static int[] randomArray(int n) {
        int[] a = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(100);
        }
        return a;
    }

    private static void displayArray(int[] arrayToPrint) {
        System.out.print("\nYour array is:\n\t[");
        for (int i=0;i<arrayToPrint.length-2; i++) {
            System.out.print(" "+arrayToPrint[i]+" |");
        }
        System.out.print(" "+arrayToPrint[arrayToPrint.length-1]+" ]");
    }

    public static void main(String[] args) {
        SelectionSorting demo = new SelectionSorting();
        int[] testArray = randomArray(10);
        displayArray(testArray);

        for (int i=0; i<testArray.length;i++) {
            int locationOfSmallest = locationOfSmallerValue(testArray,i);
            swap(i,locationOfSmallest,testArray);
        }

        displayArray(testArray);
    }
}