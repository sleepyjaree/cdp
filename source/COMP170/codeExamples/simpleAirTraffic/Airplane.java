/**
 * Demo of Private fields
 */

public class Airplane {

    private String tailNumber;
    private String make;
    private String model;

    /**
     * A method to identify an airplane
     * @param tailNumber The registry number of the aircraft; must begin with N
     * @param make The manufacturer of the airplane
     * @param model The model of the airplane
     */

    public Airplane(String tailNumber, String make, String model) {
        // a test to make sure that tailNumber is a valid registry number;
        // for example, do not accept tailNumbers that do not begin with N.
        // if ( firstCharofTailNumber = "N") accept else reject
        this.tailNumber = tailNumber;
        this.make = make;
        this.model = model;
    } // constructor for Airplane

    /**
     * A method to return a message containing the tailNumber of an Airplane
     * @return tnMessage (String) message with the tailNumber
     */
    public String tn() {
        String tnMessage = "The tail number of the aircraft is " + tailNumber;
        return tnMessage;
    } // method tn()

    /**
     * A method to return a terse description of the airplane
     * @return description (String) showing tail number, make, and model
     */
    public String describe() {
        String description = tailNumber + " is a "+make+" "+model;
        return description;
    } // method describe()

    /**
     * a method to cause the airplane to fly
     */
    public void fly() {
    } // method fly()

}