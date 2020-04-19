/**
 * A class that implements a building as a collection of floors linked to
 * each other. The class has one field called ground. The base type of ground
 * is Floor. Floor is defined as a static class within Building and has
 * three fields: a floor number and two pointers to the floor above and the
 * floor below. These pointers are also of base type Floor. Building also
 * contains a method to add a floor to an existing structure, a method to
 * find the highest floor on a building, and a main method to run the program.
 */

public class Building {

    /**
     * We assume that all buildings start from a ground floor; ie no basements!
     */

    private Floor ground;

    /**
     * Class Floor is made static to keep the code need; i.e., to eliminate the
     * need for a separate file Floor.java. (That's not the only usefulness of
     * nested static classes). A simple default constructor is provided, and the
     * rest is done with direct access to the Floor's fields from outside the class.
     * And a floorString method facilitates visualization, later in the program.
     */

    static class Floor {
        int floorNumber;
        Floor above, below;
        Floor() {
            floorNumber = 0;
            above = null;
            below = null;
        } // default constructor Floor
        String floorString() {
            return  "+" + "-".repeat(10) + "+\n" +
                    "| " + floorNumber + "        |\n" +
                    "+" + "-".repeat(10) + "+";
        }
    }

    /**
     * Method addFloor() returns a Building object with a new floor added to it.
     * The floor is added above the highest existing floor. A separate method called
     * highestFloor() is used to find the highest existing floor. Method addFloor()
     * checks first to determine if the ground floor of the building is completed
     * or not. If there is no ground floor, it creates one. If there is a ground
     * floor, the method looks for the highest floor (which can be just the
     * ground floor).
     *
     * @param ourBuilding the building to expand
     * @return the expanded building with one more floor added on the top
     */

    public static Building addFloor(Building ourBuilding) {

        // Get a new floor object ready. We use the default constructor for Floor
        // that gives us a minimal object, whose fields will be set to the
        // appropriate values in the following few lines of code.

        Floor newFloor = new Floor();

        // Determine where to attach this new floor to.

        if ( ourBuilding.ground == null ) {

            // If the ground floor has not be completed, make the new floor
            // object, the ground floor. And since this is now the only existing
            // floor of the building, its above and below points remain null
            // (the default constructor for Floor, took care of that).

            ourBuilding.ground = newFloor;

        } else {

            // ourBuilding has a ground floor, so the new floor we are adding
            // needs to go to the top of the building. Method highestFloor
            // finds the highest existing floor. And then we can obtain its
            // floor number as well.

            Floor highestExistingFloor = ourBuilding.highestFloor();
            int highestExistingFloorNumber = highestExistingFloor.floorNumber;

            // The floor number for the new floor we are adding to the building
            // is the floor number of the highest existing floor, increased by 1.

            newFloor.floorNumber = highestExistingFloorNumber+1;

            // The pointer above the highest existing floor which was null until now,
            // becomes the new floor we just added.

            highestExistingFloor.above = newFloor;

            // And the floor below the new floor we just added, is the floor that
            // until now was the highest existing floor.

            newFloor.below = highestExistingFloor;
        }
        return ourBuilding;
    } // method addFloor

    /**
     * Method highestFloor searches from the ground floor up to find the
     * highest floor in a building. The highest floor is identified as
     * the Floor object whose .above pointer is null (ie there is no
     * floor above it).
     * @return First floor object with a null .above pointer.
     */

    public Floor highestFloor() {
        Floor current = ground;
        while (current.above != null)

            // If the current floor has a pointer to a floor above,
            // make the floor above the current floor and repeat.
            // (Notice, No {} after while() if there is only 1 line to process )

            current = current.above;
        return current;
    } // method highestFloor

    /**
     * Method traverseBuilding creates a simple visual display of a building.
     * @param thisBuilding is the object to visualize.
     */

    public static void traverseBuilding(Building thisBuilding) {
        Floor current = thisBuilding.ground;
        if (current == null ) {
            System.out.println("This is an empty building. Add some floors first.");
        } else {
            while (current.above != null) {
                System.out.println(current.floorString());
                current = current.above;
            }
            System.out.println(current.floorString());
        }
    } // method traverseBuilding

    public static void main(String[] args) {
        Building demo = new Building();
        addFloor(demo);
        addFloor(demo);
        addFloor(demo);
        addFloor(demo);
        addFloor(demo);
        traverseBuilding(demo);
    } // main
}