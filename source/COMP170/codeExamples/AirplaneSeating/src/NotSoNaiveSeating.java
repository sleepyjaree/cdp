public class NotSoNaiveSeating {

    String[] passenger = new String[12];

    public void populateManifest() {
        for (int i = 0; i<12; i++) {
            passenger[i] = "Pfname"+i+" Plname"+i;
        }
    }

    public void displayPassengerSeating() {
        for (int i = 0; i<12; i++) {
            if ( (i) % 4 == 0 ) {
                System.out.print("+----+----+---+----+----+\n");
            }
            int row = 1+Math.round(i/4);
            String seatPlace = Character.toString ((char) 65+ (i%4));
            System.out.print("| " + row + seatPlace + " ");
            if ((i+1)%2 == 0) {
                System.out.print("|   ");
            }
            if ((i+1)%4 == 0) { System.out.print("\n"); }
        }
        System.out.print("+----+----+---+----+----+\n\n\n");
    }

    public void displayPassengerSeatingAndName() {
         int passengerIndex;
         String seating=null, name=null;
        for (int row = 1; row <= 3; row++) {
            for (int seat = 1; seat <=4; seat++) {
                passengerIndex = (row-1)*4 + seat;
                seating = seating + "| " + row;
                name = name + "| " + passenger[passengerIndex];
            }
            System.out.println(seating);
            System.out.println(name);
        }
    }
    public static void main(String[] args) {
        NotSoNaiveSeating myFlight = new NotSoNaiveSeating();
        myFlight.populateManifest();
        myFlight.displayPassengerSeating();
        myFlight.displayPassengerSeatingAndName();
    }
}
