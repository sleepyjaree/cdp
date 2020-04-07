public class City extends GeographicEntity {

    private Country isIn;
    private int population;

    public City() {
        super();
        population=0;
    }

    public City(String cityName, int cityPopulation) {
        super(cityName);
        population = cityPopulation;
    }

    public void setIsIn(Country newCountry) {
        isIn = newCountry;
    }

    public void setPopulation(int )
}
