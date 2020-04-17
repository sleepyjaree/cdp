
public class Building {

    Floor ground = null;

    public void addFloor(Building building) {
        if (ground==null) {
            // complete ground floor
        } else {
            // put a floor on top of the highest floor in the building
            // ... ok, but HOW do you find the highest floor
            Floor highest = highestFloor(building);
            int hightestFloorNumber = highest.getFloorNumber();
            int newFloorNumber = 1+hightestFloorNumber;
            Floor newFloor = new Floor();
        }
    }

    public Floor highestFloor(Building building) {
        Floor current = building.ground;
        while (current.above != null) {
            current = current.above;
        }
        return current;
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

        public void setFloorNumber(int floorNumber) { this.floorNumber = floorNumber; }
        public void setFloorName(String floorName) { this.floorName = floorName;}
        public void setAbove(Floor above) { this.above = above;}
        public void setBelow(Floor below) { this.below = below;}

        public int getFloorNumber() { return floorNumber; }
    }
}