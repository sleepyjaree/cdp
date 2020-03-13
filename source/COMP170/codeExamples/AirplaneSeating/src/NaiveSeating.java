public class NaiveSeating {

    private static final int MAX_PASSENGER = 100;

    static String[] passenger = new String[80];

    public void populateManifest() {
        for (int i = 0; i<80; i++) {
            passenger[i] = "Pfname"+i+" Plname"+i;
        }
    }

    public void displayPassengerSeating() {
        for (int i = 0; i<80; i++) {
            int row = 1+Math.round(i/4);
            String seatPlace = Character.toString ((char) 65+ (i%4));
            System.out.print(row+seatPlace+" ");
            if ((i+1)%2 == 0) { System.out.print("  "); }
            if ((i+1)%4 == 0) { System.out.print("\n"); }
        }
    }


    public static void main(String[] args) {
        NaiveSeating myFlight = new NaiveSeating();
        myFlight.populateManifest();
        myFlight.displayPassengerSeating();
    }

}
