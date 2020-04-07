public class USState extends Country {

    private boolean lower48;

    public USState() {
        super();
        lower48=true;
    }

    public USState(String stateName, String capitalName, boolean stateLower48) {
        super(stateName,capitalName);
        lower48 = stateLower48;
    }

    public void setLower48(boolean newLower48) {
        lower48 = newLower48;
    }

    public void setUSState(String newStateName, String newStateCapital, boolean newStateLower48) {
        setCountry(newStateName,newStateCapital);
        lower48 = newStateLower48;
    }

    public String getUSStataName() {
        return getName();
    }

    public boolean isSameState(USState otherState) {
        return this.getName().equalsIgnoreCase(otherState.getName());
    }

    public void displayInfo() {
        System.out.println("US State: "+getName());
        System.out.println(" Capital: "+getCapital());
        System.out.println("Lower 48: "+lower48);
    }
}
