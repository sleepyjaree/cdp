public class Country extends GeographicEntity {

    private String capital;

    public Country() {
        super();
        capital = "What's the capital city for this country?";
    }

    public Country(String countryName, String capitalCity) {
        super(countryName);
        capital = capitalCity;
    }

    public void setCountry(String newCountryName, String newCapitalCity) {
        setName(newCountryName);
        capital = newCapitalCity;
    }
    
    public void setCapital(String newCapitalCity) {
        capital = newCapitalCity;
    }

    public String getCapital() {
        return capital;
    }

    public void displayInfo() {
        System.out.println("Country: " + getName());
        System.out.println("Capital: " + capital);
    }
}
