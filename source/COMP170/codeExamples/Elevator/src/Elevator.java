
public class Elevator {

    private Floor ground;

    public Elevator() {
        ground = new Floor(0,"Ground");
    }

    public void buildElevator() {

        Floor first  = new Floor(1, "First");
        Floor second = new Floor(2, "Second");
        Floor third  = new Floor(3, "Third");

        ground.floorUp(first);
        first.upDown(second,ground);
        second.upDown(third,first);
        third.floorDn(second);
    }

    public void groundToTop() {
        Floor current = ground;
        while (current != null) {
            current = current.whichFloorUpNext();
        }
    }


    private class Floor {
        int floorNumber;
        String floorName;
        Floor nextFloorUp;
        Floor nextFloorDown;
        public Floor() {
            floorNumber=0;
            floorName=null;
            nextFloorDown=null;
            nextFloorUp=null;
        }
        public Floor(int n, String s) {
            floorName = s;
            floorNumber = n;
        }
        public void floorUp(Floor up) {nextFloorUp=up;}
        public void floorDn(Floor dn) {nextFloorDown=dn;}
        public void upDown(Floor up, Floor dn) {
            nextFloorDown = dn;
            nextFloorUp = up;
        }
        public Floor whichFloorUpNext() { return nextFloorUp;}
    }

    public static void main(String args[]) {
        Elevator demo = new Elevator();
    }
}