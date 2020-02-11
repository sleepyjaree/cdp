import java.util.*;

public class Person {
    public String firstName;
    public String lastName;
    public int yearOfBirth;

    /**
     * Prints a descriptive sentence about the person
     */
    public void describePerson() {
        System.out.println("\n"+firstName+" "+
            lastName+" was born in "
            +yearOfBirth);
    }

    /**
     * Shows the person's affinity for a study topic
     * @param topic to study
     */
    public void study(String topic) {
        System.out.println("\n"+firstName+
            " loves to study "+topic);
    }

    /** 
     * Returns the age of the person
     */
    public int showAge() {
        int age = 2020-yearOfBirth;
        return age;
    }

    /** 
     * Causes a person to sleep and when called to respond with Zzzz
     * @param hours Hours of sleep; each hour shows a Zzz as a response
     */
    public void goSleep(int hours) {
        System.out.print("\nHey, "+firstName+"?");
        for (int i=1; i<=hours; i++) {
            System.out.print(" Zzzz ");
        }
        System.out.println("\n\t( Shhhhh! "+firstName+" is sleeping)");
    }
    
    /**
     * Causes a person to have a meal
     * @param food item to eat
     */
    public void eatSome(String food) {
        System.out.println("\n"+firstName+" is enjoying a bit of "+food);
    }

    public static void main(String[] args) {

        Person leo = new Person();
        leo.firstName = "Leo";
        leo.lastName = "Irakliotis";
        leo.yearOfBirth = 1967;

        Person john = new Person();
        john.firstName = "John";
        john.lastName = "Go";
        john.yearOfBirth = 2000;

        leo.describePerson();
        john.describePerson();

        System.out.println("\n"+leo.firstName+
            " is "+
            leo.showAge()+
            " years old");

        leo.study("Databases");
        leo.goSleep(8);

        john.study("Java");
        
        john.eatSome("soup");
        leo.eatSome("noodles");
    }
}