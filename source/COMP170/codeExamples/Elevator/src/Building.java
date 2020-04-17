
public class Building {

    Floor ground = null;

    public void addFloor(Building building) {
        if (ground==null) {
            // complete ground floor
        } else {
            // put a floor on top of the highest floor in the building
            // ... ok, but HOW do you find the highest floor
        }
    }

    public int countFloors() { return 1;}



    private class Floor {

        int floorNumber;
        String floorName;
        Floor above;
        Floor below;

        public Floor() {
            floorNumber = 0;
            floorName = "N/A";
            above = null;
            below = null;
        }

        public void setFloorName(String floorName) { this.floorName = floorName;}
        public void setAbove(Floor above) { this.above = above;}
        public void setBelow(Floor below) { this.below = below;}

        public int getFloorNumber() { return floorNumber; }
    }
}