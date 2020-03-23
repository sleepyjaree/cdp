public class NotSoNaiveSeating {

    String[] passenger = new String[12];

    public void populateManifest() {
        for (int i = 0; i<12; i++) {
            passenger[i] = "Pfname"+i+" Plname"+i;
        }
    }

    public void populateManifestRealistically() {
        realisticNameGenerator realNames = new realisticNameGenerator();
        String[] realName = new String[2];
        for (int i = 0; i<12; i++) {
            realName = realNames.realisticName();
            passenger[i] = realName[0] + " " + realName[1];
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
        String seating, name, lineSeparator;
        int longestNameLength, thisLength;

        longestNameLength = passenger[0].length();
        for ( passengerIndex = 1; passengerIndex < 12; passengerIndex++) {
            thisLength = passenger[passengerIndex].length();
            if ( thisLength > longestNameLength) {
                longestNameLength = thisLength;
            }
        }

        for (int row = 1; row < 4; row++) {
            seating="| ";
            name="| ";
            lineSeparator = "|";

            for (int seat = 1; seat < 5; seat++) {
                passengerIndex = (row-1)*4 + seat - 1;
                seating = seating + row + " ".repeat(longestNameLength-0) + "| ";
                name = name
                        + passenger[passengerIndex]
                        + " ".repeat(longestNameLength-passenger[passengerIndex].length())
                        + " | ";
                lineSeparator = lineSeparator
                        + "-".repeat(longestNameLength+2)
                        + "+";
            }

            System.out.println(seating);
            System.out.println(name);
            System.out.println(lineSeparator+"|");
        }
    }
    public static void main(String[] args) {
        NotSoNaiveSeating myFlight = new NotSoNaiveSeating();
        myFlight.populateManifestRealistically();
        //myFlight.displayPassengerSeating();
        myFlight.displayPassengerSeatingAndName();
    }
}
