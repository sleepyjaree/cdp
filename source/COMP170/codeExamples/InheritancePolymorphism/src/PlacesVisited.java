public class PlacesVisited {
    public static void main(String args[]) {

        GeographicEntity[] placesIVisited = new GeographicEntity[5];

        placesIVisited[0] = new Country("Netherlands", "Amsterdam");
        placesIVisited[1] = new Country("Japan", "Tokyo");
        placesIVisited[2] = new City("Athlone", 30000, new Country("Ireland", "Dublin"));
        placesIVisited[3] = new USCity("Bellingham", new USState("Washington", "Seattle", true), 50000);
        placesIVisited[4] = new City("Istanbul", 12000000, new Country("Turkey", "Ankara"));

        for (GeographicEntity place : placesIVisited) {
            place.displayInfo();
        }
    }
}
