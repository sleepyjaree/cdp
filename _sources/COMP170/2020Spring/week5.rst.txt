
Review of Week 5
=================

Our first formal introduction to Classes and objects is `available from the Github repository <https://github.com/lgreco/cdp/blob/master/source/COMP170/codeExamples/Person.java>`_. To download the file, open it in Raw view, then right-click and Save As.

We saw how to define a Person class in the example above. Next we worked on `a more intricate example <https://github.com/lgreco/cdp/tree/master/source/COMP170/codeExamples/Flying>`_, defining a class for airplanes as follows:

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

Notice that by making the fields of class Airplane private, we can no longer access them as casually outside the class Airplane as we did in the earlier example with class Person. In the example with class Person, we could set a person's first and last names quite casually from any method outside the class, e.g. in the ``main`` method:

.. code-block:: java 

   Person myBestFriend = new Person();
   myBestFriend.firstName = "Jean Luc";
   myBestFriend.lastName = "Picard";


But in the case of an Airplane object, we can no longer assign a value to a field as casually:
	 
.. code-block:: java
	 
   Airplane myFavAirplane = new Airplane();
   myFavAirplane.tailNumber = "N4335K";

This is now illegal, because the field ``tailNumber`` has been declared as private, and must be accessed only through class methods. That's why we defined the constructor method 

``Airplane(String tailNumber, String make, String model)``.

Going a bit deeper in Classes and access to them
++++++++++++++++++++++++++++++++++++++++++++++++

Our original approach to writing classes was simple and straightfoward:

.. code-block:: java

   public Class Airplane {
     String tailnumber;
     String make;
     String model;
   ...}
	  
This definition of the class's fields allowed us to access them directly whenever we needed them. For example, after creating a new object

.. code-block:: java 

   Airplane myFavAirplane = new Airplane();

we were able to directly access the object's fields from methods (such as ``main``) outside the class Airplane:

.. code-block:: java

   public static void main(String[] args) {
     ...
     myFavAirplane.make = "Cessna";
     myFavAirplane.model = "Skyhawk";
     ...
   }

This is fine for small programs when we want to test an idea quickly, but not so useful for larger scale projects. For larger projects we want to draw a line between the Classes that are used to build a program and the actions that orchestrate them. The line is drawn between **development** of classes and the **use** of them. A programmer creating classes is acting as a **Developer.** And a programmer who uses these classes is a **User.** Users, in this context, trust that classes built by developers will behave correctly if used according to specification. In exchange for this guarantee, users do not need to know the particular mechanisms of a class. 

One example is the String class we use extensively in our programs. We *use* the String class, and its methods, without ever looking into how the class is built. The String class itself `comprises about 3000 lines of code <https://github.com/lgreco/cdp/blob/master/source/COMP170/codeExamples/String.java>`_, that we take for granted. The comments in that code form the basis for the `String class documentation <https://docs.oracle.com/javase/7/docs/api/java/lang/String.html>`_. 

In using the String class, we follow its documentation. We create new String objects, we measure their length, we perform string substitutions, upper-to-lower case conversions, etc, without ever accessing (or even knowning the names of) the class's fields. Everything we do with Strings takes place through the class's methods which act as intermediaries between our program and the inner workings of the String. This class uses a field called ``count`` to enumerate the number of characters in a string. But instead of accessing the field ``count`` to find how many characters are in a string, we apply the ``.lenght()`` method. When we look up the definition of ``length()`` in String, we find that it just returns the value of ``count``.

.. code-block:: java

   public int length() {
     return count;
   }

Unless we look into the source code of the String class we can never tell now the length of the string is computed. We simply trust that it is computed correctly.


.. image:: images/N866US.jpg
   :align: right
   :width: 33%
   

When writing our own classes, we must separate our roles as Developers and as Users. To return to the airplane example above, we should never allow a User (even it that programmer is ourself) to access the class's fields directly. We must, as Developers, provide methods for users to interact with the class as needed. For example, in creating a new Airplane object we would like the user to pass the aircraft's specifics through a method, as follows:

.. code-block:: java
   
   Airplane myFavAirplane = new Airplane("N866US","Diamond","DA40");

To make that possible, we modify our initial Airplane class in the following manner: first, we make its fields inaccessible outside the class (no do direct access in the form ``object.field`` can take place), and second, we define a method to initialize a new object with specific information. To make fields inaccessible outside the class we use the modifier ``private``, i.e., we declare these fields to be private items of the class, available only to methods within the class but not outside it.

.. code-block:: java

   public Class Airplane {
     private String tailNumber;
     private String make;
     private String model;
		 
     /**
      * A method to construct a new airplane object.
      * @param tailNumber The registry number of the aircraft
      * @param make The manufacturer of the aircraft
      * @param model The model of the aircraft
      */
     public Airplane(String tailNumber, String make, String model) {
       this.tailNumber=tailNumber;
       this.make=make;
       this.model=model;
     }
     ...
   }

Notice the comments prior to the method ``Airplane``. These comments are instructions passed to the user of the class, and describe how the specific method is to be used. The comments follow specific syntax rules that are part of `the Javadoc tool <https://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html>`_. The user never touches the classes fields directly. Instead, users pass values to a class's fields through methods. This particular method above, i.e., a method that bears the same name as the class itself, and assigns values to the fields of a new object, is called a **constructor** method.

The constructor method above is fairly simplistic and it may cause us to ask what's the benefit of adding all that extra code to avoid direct access to a class's fields. Its usefulness becomes evident when we begin to apply logic that enforces specific rules. For example, airplane tail numbers for US-registed aircraft begin with the letter "N". If our application is meant for US-registered aircraft only, the constructor method can enforce a rule for proper tail numbers:



.. code-block:: java

   public Class Airplane {
   ...
     /**
      * A method to construct a new airplane object.
      * @param tailNumber The registry number of the aircraft
      * @param make The manufacturer of the aircraft
      * @param model The model of the aircraft
      */
     public Airplane(String tailNumber, String make, String model) {
       if (tailNumber.length()>0 && tailNumber.charAt(0)=='N') {
         this.tailNumber=tailNumber;
         this.make=make;
         this.model=model;
       } else {
         // ... return some error message about invalid tail number
       }
     }
     ...
   }

What happens when the constructor method above is invoked from a method outside the Airplane class, such as the ``main`` method?

.. code-block:: java

   public static void main(String[] args) {
   ...
   Airplane myFavAirplane = new Airplane("N866US","Diamond","DA40");
   ...
   }
 
The second half of the statement above, ``new Airplane("N866US",...)`` tells the Java Virtual Machine to allocate memory for a new Airplane object, and then initializes the new object's fields to the values provided as arguments, e.g. the tail number field will be set to ``N866US``, etc. Once the initialization is done, the new object is assigned a reference (a nickname if you wish) stored in variable ``myFavAirplane`` which is designated as a reference to an Airplane object by the first half of the statement above. Step by step, the process works as follows. ::


   create new object to be referenced as myFavAirplane
   go to the Airplane class and follow the constructor template
     is the length of string "N866US" greater than 0, and
     is the first character of string "N866US" equal to character 'N'?
       yes
         Good, now use the template
           this.tailNumber=tailNumber;
           this.make=make;
           this.model=model;
         only replace "this" with "myFavAirplane" and assign the values given
         myFavAirplane.tailNumber = "N866US"
         myFavAirplane.make = "Diamond"
         myFavAirplane.model = "DA40"



	   