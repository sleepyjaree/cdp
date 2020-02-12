
Review of Week 5
=================

Our first formal introduction to Classes and objects is `available from the Github repository <https://github.com/lgreco/cdp/blob/master/source/COMP170/codeExamples/Person.java>`_. To download the file, open it in Raw view, then right-click and Save As.

We saw how to define a Person class in the example above. Next we worked on a more intricate example, defining a class for airplanes as follows:

.. code-block:: java
   :linenos:
   
   public class Airplane {

    private String tailNumber;
    private String make;
    private String model;
    private int altitude, airspeed;

    public Airplane() {
        airspeed = 0;
        altitude=0;
    } // default constructor

    public Airplane(String tailNumber, String make, String model) {
        this.tailNumber = tailNumber;
        this.make = make;
        this.model = model;
        airspeed = 0;
        altitude = 0;
    } // standard constructor

    public void takeOff(String tailNumber) {
        airspeed = 100;
        altitude = 100;
    } // method takeOff

    public int sayAltitude() {
        return altitude;
    } // method sayAltitude (an accessor method)

    public int sayAirspeed() {
        return airspeed;
    } // method sayAirspeed (an accessor method)

    public static void main(String[] args) {
        Airplane myFavAirplane = new Airplane("N4335K", "Piper", "Archer");
        Airplane myOtherFavAirplane = new Airplane("N866US", "Diamond", "Star");

        System.out.println(myFavAirplane.sayAltitude());
    }
   }

Notice that by making the fields of class Airplane private, we can no longer access them as casually as we did in the earlier example with class Person. In the example with class Person, we could set a person's first and last names quite casually:

.. code-block:: java 

   Person myBestFriend = new Person();
   myBestFriend.firstName = "Jean Luc";
   myBestFriend.lastName = "Picard";


But in the case of an Airplane object, we can no longer assign a value to a field as casully:
 
 .. code-block:: java
 
    Airplane myFavAirplane = new Airplane();
	myFavAirplane.tailNumber = "N4335K";

This is now illegal, because the field ``tailNumber`` has been declared as private, and must be accessed only through class methods. That's why we defined the constructor method ``Airplane(String tailNumber, String make, String model)``.
  
