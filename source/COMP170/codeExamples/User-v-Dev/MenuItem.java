/**
 * A simple class to demonstrate information hiding
 * @author Leo Irakliotis
 */
public class MenuItem {

    private String name, description;
    private short calories; // we don't need int's 4 bytes here; 2 bytes are plenty
    private float price;    // we don't need a double here; 2 bytes are plenty

    /**
     * Default contstructor
     */
    public MenuItem() {
        this.name = "A fabulous menu item, coming soon";
        this.price = (float) 3.99;
    } // method MenuItem, default constructor for class MenuItem

    /**
     * Minimal constructor, requires at least a name and a price
     * @param name Name of new item to add to the menu
     * @param price Price of the new item
     */
    public MenuItem(String name, float price) {
        this.name = name;
        this.price = price;
    } // method MenuItem, minimal constructor for class MenuItem

    /**
     * A full constructor
     */
    public MenuItem(String name,String description,short calories,float price){
        this.name = name;
        this.description = description;
        this. price = price;
        this.calories = calories;
    } // method MenuItem, full constructor for class MenuItem

    /**
     * A method to edit/update the price of an item on the menu
     * @param newPrice The new price
     */
    public void setPrice(float newPrice) {
        this.price = newPrice;
    } // method setPrice

    /** A method that provides content to print the menu
     * @return A stylized string with the menu item, its price, and description
     */
    public String printMenu() {
        return name + " " + price + "\n" + description + " " + calories + " (cals)";
    } // method printMenu

} // class MenuItem