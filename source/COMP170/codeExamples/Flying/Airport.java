 
public class Airport
{
    private String icaoCode;
    private String name;
    private String city;
    
    public Airport(String icaoCode, String name, String city) {
        this.icaoCode = icaoCode;
        this.name = name;
        this.city = city;
    }
    
    public String airportCity() {
        return city;
    }
}
