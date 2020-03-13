/**
 * Class FlightSeating is our demo class
 */
public class FlightSeating{

    private static final int MAX_PASSENGER = 100;

    String[] manifest = new String[MAX_PASSENGER];

    /**
     * populateManifest produces a mockup list of passenger names,
     * with sequential values FirstName1 LastName1, FirstName2, ...
     * for testing purposes
     * @param capacity Number of passengers on flight
     * @return String array with passenger names
     */
    public String[] populateManifest(int capacity) {
        if (capacity>MAX_PASSENGER) { capacity=MAX_PASSENGER; }
        String[] passenger = new String[capacity];
        for (int i=0; i<capacity; i++) {
            passenger[i] = "FirstName"+i+" LastName"+i;
        }
        return passenger;
    }

    /**
     * assignSeats takes an array of passenger names and injects
     * one passenger at-a-time to a Seat object
     * @param manifest array with passenger names
     * @param rows number or rows in airplane, assuming single aisle, 2-2 cabin
     * @return seating, an array with Seat objects for each passenger
     */
    public void assignSeats(String[] manifest, int rows) {
        int row, pos = 0;
        int numberOfPassengers = manifest.length;
        String position;
        FlightSeating seating = new FlightSeating();

        if (numberOfPassengers % 4 <= rows) { // make sure passengers fit in aircraft
            for (int i = 0; i < numberOfPassengers; i++) {
                row = 1 + i % 4;
                position = Character.toString((char) 65 + pos); // A, B, C, D, A, B, ...
                seating = addSeat(seating,row, position, passenger);
                pos++;
                if(pos==4) { pos = 0; }
            }
        }
    }

    /**
     * printSeating provides a nicely formatted seat map
     * @param seating an array of Seat assignments
     */
    public void printSeating(Seat[] seating) {
        int numberOfPassengers = seating.length;
        int rows = numberOfPassengers % 4;
        for (int row=1)

    }
}
