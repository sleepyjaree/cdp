 public class AirTraffic {
     
     public static void main(String[] args) {
         
        Airplane myFavAirplane = new Airplane("N4335K", "Piper", "Archer");
        Airplane myOtherFavAirplane = new Airplane("N866US", "Diamond", "Star");
        
        // create a few airports
        
        Airport kmdw = new Airport("KMDW","Midway International Airport","Chicago, IL");
        Airport kmsn = new Airport("KMSN","Dane County Regional Airport","Madison, WI");
        Airport khpn = new Airport("KHPN","Westchester County Airport","White Plains, NY");
        
        // and pilots
        
        Pilot leo = new Pilot("Leo","Irakliotis");
        Pilot jon = new Pilot("Jon","Ross");
        
        // let's plan a flight
        
        Flight flight801 = new Flight(kmdw,khpn,leo,myFavAirplane);
    }
}