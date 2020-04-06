public class GeographicEntity {
    private String name;

    public GeographicEntity() {
        name = "Give this place a name!";
    }

    public GeographicEntity(String initialName) {
        name = initialName;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Name: "+name);
    }

    public boolean hasSameName(GeographicEntity otherEntity) {
        return this.name.equalsIgnoreCase(otherEntity.name);
    }
}
