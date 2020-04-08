public class Lake extends GeographicEntity {

    private int depth;

    public Lake() {
        depth = 0;
    }

    public void setDepth(int d) {
        depth = d;
    }

    public int getDepth() {
        return depth;
    }

    public void displayInfo() {
        System.out.println("You visited " + getName() + ", a lake whose depth is " + depth + "feet");

    }
}
