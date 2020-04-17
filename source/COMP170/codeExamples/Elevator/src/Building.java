
public class Building {

    Floor ground = null;

    public void addFloor(Building building) {}

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