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
        isIn = null;
    }

    public City(String cityName, int cityPopulation, Country countryIsIn) {
        super(cityName);
        population = cityPopulation;
        isIn = countryIsIn;
    }

    public void setIsIn(Country newCountry) {
        isIn = newCountry;
    }

    public void setPopulation(int newPopulation) {
        population = newPopulation;
    }

    public void setCity(String newCityName, Country newCountry, int newPopulation) {
        setName(newCityName);
        isIn = newCountry;
        population = newPopulation;
    }

    public String getCountry() {
        return isIn.getName();
    }

    public int getPopulation() {
        return population;
    }

    public void displayInfo() {
        String size = "town";
        if (population>100000) { size= "city"; }
        System.out.println("You visited "+getName() + ", a "+size+" with population "+population + " in "+isIn.getName());
    }

    public boolean isSameCity(City otherCity) {
        return this.getName().equalsIgnoreCase(otherCity.getName()) &&
                this.population == otherCity.population &&
                this.isIn.getName().equalsIgnoreCase(otherCity.isIn.getName());
    }
}
