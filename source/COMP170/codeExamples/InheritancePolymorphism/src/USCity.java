public class USCity extends City {

    private USState state;

    public USCity() {
        super();
        state.setLower48(false);
    }

    public USCity(String cityName, USState isInState, int hasPopulation) {
        super(cityName,hasPopulation);
        state = isInState;
    }

    public boolean isSameCity(USCity otherUSCity) {
        return this.getName().equalsIgnoreCase(otherUSCity.getName()) &&
                this.state.getName().equalsIgnoreCase(otherUSCity.state.getName());
    }

    public void displayInfo() {
        String size = "town";
        if (getPopulation()>1000000) { size= "city"; }
        System.out.println("You visited "+getName() + ", "+state.getName() + ", a US " + size + " with population "+getPopulation());

    }
}
