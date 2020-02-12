 public class AirTraffic {
     
     public static void main(String[] args) {
        Airplane myFavAirplane = new Airplane("N4335K", "Piper", "Archer");
        Airplane myOtherFavAirplane = new Airplane("N866US", "Diamond", "Star");

        System.out.println(myFavAirplane.sayAltitude());
    }
}