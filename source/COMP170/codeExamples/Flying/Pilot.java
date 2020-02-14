 
public class Pilot
{
    private String fname;
    private String lname;
    
    public Pilot(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String pilotName() {
        String pilotName = fname+" "+lname;
        return pilotName;
    }
}
