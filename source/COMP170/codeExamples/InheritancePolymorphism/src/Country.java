public class Country extends GeographicEntity {

    private String capital;

    public Country() {
        super(); // calls the default constructor of the parent class
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
        System.out.println("You visited " + getName() + ", a country whose capital is " + capital);
    }

    public boolean isSame(Country otherCountry) {
        return this.getName().equalsIgnoreCase(otherCountry.getName()) &&
                this.capital.equalsIgnoreCase(otherCountry.capital);
    }
}
