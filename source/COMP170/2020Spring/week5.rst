
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
	 print int altitude, airspeed;
	 
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
	 
	 public int sayAltitude(String tailNumber) {
	   return altitude;
	 }} // method sayAltitude (an accessor method)
	 
	 public int sayAirspeed(String tailNumber) {
	   return airspeed;
	 } // method sayAirspeed (an accessor method)
	 
	 
   }