public class Building {

   Floor ground = new Floor();

    /**
     * default constructor
     */
    public Building() {
    } // default constructor


    public static Floor lastFloor(Building building) {
        Floor current = building.ground;
        while (current.above != null) {
            current = current.above;
        }
        return current;
    }

    public static Building addFloor(Building building) {
        Floor currentLastFloor = lastFloor(building);
        int newFloorNumber = 1 + currentLastFloor.getFloorNumber();
        String newFloorName = "** "+newFloorNumber+" **";
        Floor floorToAdd = new Floor(newFloorName, newFloorNumber);
        currentLastFloor.above = floorToAdd;
        floorToAdd.below = currentLastFloor; // potential bug .. when at ground
    }

    static class Floor {
        private String floorName;
        private int floorNumber;
        Floor above;
        Floor below;
        Floor() {
            floorNumber = 0;
            floorName = "Ground";
            above = null;
            below = null;
        }
        Floor(String floorName, int floorNumber) {
            this.floorName = floorName;
            this.floorNumber = floorNumber;
        }
        void setFloor(String floorName, int floorNumber) {
            this.floorName = floorName;
            this.floorNumber = floorNumber;
        }
        void setFloor (String floorName, int floorNumber, Floor above, Floor below) {
            this.floorName = floorName;
            this.floorNumber = floorNumber;
            this.above = above;
            this.below = below;
        }
        void setAbove(Floor above) { this.above = above; }
        void setBelow(Floor below) { this.below = below; }
        String getFloorName() { return floorName; }
        String getAbove() { return above; }
        String getBelow() { return below; }
        int getFloorNumber() { return floorNumber; }
    }
}