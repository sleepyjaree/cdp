public class Airplane {

    private String tailNumber;
    private String make;
    private String model;
    private int altitude, airspeed;

    public Airplane() {
        airspeed = 0;
        altitude=0;
    } // default constructor

    public Airplane(String tailNumber, String make, String model) {
        this.tailNumber = tailNumber;
        this.make = make;
        this.model = model;
        airspeed = 0;
        altitude = 0;
    } // standard constructor

    public void takeOff(String tailNumber) {
        airspeed = 100;
        altitude = 100;
    } // method takeOff

    public int sayAltitude() {
        return altitude;
    } // method sayAltitude (an accessor method)

    public int sayAirspeed() {
        return airspeed;
    } // method sayAirspeed (an accessor method)

    public static void main(String[] args) {
        Airplane myFavAirplane = new Airplane("N4335K", "Piper", "Archer");
        Airplane myOtherFavAirplane = new Airplane("N866US", "Diamond", "Star");

        System.out.println(myFavAirplane.sayAltitude());
    }
}