/**
 * Seat uses a linear array to map an airplane's seating arrangement
 */
public class Seat {
    
    private int row;
    private String position;
    private String passenger;

    public Seat(int row, String position, String passenger) {
        this.row = row;
        this.position = position;
        this.passenger = passenger;
    }


}
