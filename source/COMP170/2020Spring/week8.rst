
Review of Week 8: Arrays
=================================
 
A good way to introduce arrays is with a concrete example, showing some of the things we can do with them. An array is a collection of similar items. Each item occupies a position within the array and can be referenced by that position. Because each item is stored in the array, it does not require its own individual variable name. For example, the following code snippet computers the average temperature for one week.

.. code-block:: java
  
 float montemperatureAtNoon = 70;
 float tuetemperatureAtNoon = 63;
 float wedtemperatureAtNoon = 72;
 float thutemperatureAtNoon = 67;
 float fritemperatureAtNoon = 68;
 float sattemperatureAtNoon = 68;
 float suntemperatureAtNoon = 71;
 
 float weekAverage = ( montemperatureAtNoon + tuetemperatureAtNoon 
                     + wedtemperatureAtNoon + thutemperatureAtNoon 
                     + fritemperatureAtNoon + sattemperatureAtNoon
                     + suntemperatureAtNoon ) / 7.0;

In the code above, we initialize seven variables, one for each day of the week to record the temperature. Then we add these variables together and divide the sum by 7, to obtain the average temperature.
The code below achieves the same result, with a different approach.

The difference in the code below begins with the highlighted line. The command initializes an array to hold 7 different float values. The program then proceeds to add the values stored in an array, using a for-loop accessing one element of the array at a time.


.. code-block:: java
 :emphasize-lines: 1
  
 float[] temperatureAtNoon = new float(7);
 
 temperatureAtNoon[0] = 70;
 temperatureAtNoon[1] = 63;
 temperatureAtNoon[2] = 72;
 temperatureAtNoon[3] = 67;
 temperatureAtNoon[4] = 68;
 temperatureAtNoon[5] = 68;
 temperatureAtNoon[6] = 71;
 
 float weekAverage = 0;
 
 for (int day = 0; day < 7; day++) {
   weekAverage = weekAverage + temperatureAtNoon[day];
 }
 
 weekAverageHigh = weekAverageHigh / 7.0;

As the code above shows, an array is declared by an empty pair of square brakets next to the data type we wish to use; in the example above ``float[]``. The declaration includes the name we wish to give to the array. Next, the array is initialized to a specific size, by the command ``new`` and the size specification; in this example we initialize an array of 7 float variables. 

Values stored in the array can be accessed by the referencing the corresponding element, using an array index. The array index is an integer number enclosed in square brackets. The first element of the array corresponds to index ``[0]``. Often we need to traverse an array, looking at every element. This is accomplished with a loop in which an ``int`` variable is increment by 1 (using the ``++`` operator). In the example above, the variable ``day`` is used in a for-loop to access the 0th, 1st, 2nd, 3rd, 4th, 5th, and 6th place of the array -- in other words, all of its seven elements.

What makes arrays so useful and so interesting in programming is the ability to traverse them so easily. We can store values with a common property -- e.g., daily temperatures -- and then analyze them by traversing the array to find average values, as well as extreme values, and other properties. Using the example above, here's a simple code snippet to find the maximum daily high temperature

.. code-block:: java

 maxTemperature = temperatureAtNoon[0];
 for (int day = 1; day < 7; day++) {
   if ( temperatureAtNoon[day] > maxTemperature ) {
     maxTemperature = temperatureAtNoon[day];
   }
 }
 
Data analysis, shown in the examples above, is one of arrays' many application. Arrays, and array-based Classes, can be used to search data, map information, and organize knowledge. The next example shows how a linear (one-dimensional) array can produce two-dimensional information.

Airplane Seating
----------------

This example shows how we can use an array to map information. It's a simple, almost naive, example but there are things to learn from it. First, let's frame the problem. We have an one-dimensional array holding the names of passengers for a small airplane. And we'd like to assign these passengers to airplane seats, in a specific order. The airplane is a small one, with 12 seats only. The cabin has a single aisle, with two seats on either side. There are 3 rows of seats and 4 seats per row. Rows are numbered 1,2, and 3. Seats are labeled A, B, C, and D, from left to right. We want the first passenger in the passenger list to be seated on seat 1A, the second on 1B, the 5th on 2A, and so on. The figure below shows the placing order.
 
| 

 
.. figure:: images/AirplaneSeating.jpg
   :width: 90%
   :align: center
   
   Converting a passenger manifest to seating assignments in a (small) airplane. The manifest is a linear (one-dimensional) entity, while the seating assignment is a two-dimensional construct.

| 

The placing order shown in the figure above is called *row-major*. It fills one row at a time, from left-to-right, beginning with the front row. The implementation of this technique is showin in Class ``NaiveSeating`` below.  The code  prints only the seat labels in the proper arrangement, ie, it does not concern itself with the names of the passengers. All that ``NaiveSeating`` does is to create the following output::

 1A 1B   1C 1D
 2A 2B   2C 2D
 3A 3B   3C 3D

For compactness, the code for ``NaiveClass`` has no comments. A line-by-line narrative of this Class follows after the code.


.. literalinclude:: ../codeExamples/AirplaneSeating/src/NaiveSeating.java
   :linenos:
   :emphasize-lines: 3
   :language: java
   
Let's look, line-by-line, what the code above does (the narrative below omits blank lines).

**Line 1:** defines the name of the Class.

**Line 3:** creates an array of ``String`` variables, named ``passengers`` and initializes it to hold 12 values.

**Lines 5-9:** define a method that populates the array ``passengers`` with mockup names. The first name is "LName1 FName1", the second "FName2 LName2", and so on. Line 6 initiates a for-loop that assignes the values 1 through 12 to variable ``i``, sequentially. Then, in line 7, the value of ``i`` is concatenated with strings to produce the desired mockup names. Admittedly, this is *pathetic*. We want passenger names to be more realistic than Mr. FName1 LName1. But we'll worry about it later.

.. Note to self: use two arrays for popular fname and lname, 
   maybe [20] each, and  use a random index to select and compose.

.. things to talk about ... ascii values ...

**Lines 11-19:** define a method that prints out the simple seat layout shown earlier: 1A, 1B, etc. Ultimately we want to print something like::

 +--------+--------+--+--------+--------+
 | 1A     | 1B     |  | 1C     | 1D     |
 | Fname1 | Fname2 |  | Fname3 | Fname4 |
 | LName1 | Lname2 |  | LName3 | Lname4 |
 +--------+--------+--+--------+--------+
 | 2A     | 2B     |  | 2C     | 2D     |
 | Fname5 | Fname6 |  | Fname7 | Fname8 |
 | LName5 | Lname6 |  | LName7 | Lname8 |
 +--------+--------+--+--------+--------+
 | 3A     | 3B     |  | 3C     | 3D     |
 | Fname9 | Fname10|  | Fname11| Fname12|
 | LName9 | Lname10|  | LName11| Lname12|
 +--------+--------+--+--------+--------+


For now, however, the simple layout with just the seat numbers and without the names, is sufficient.

The method comprises a for-loop, with its variable ``i`` running from 0 to 11 in increments of 1 (**line 12**). We would like to map these numbers into the row in which the corresponding passenger (``passenger[i]``) seats. The grouping is straightforward:

+------------------+-----+
| ``passenger[i]`` | row |
+==================+=====+
| ``passenger[0]`` | 1   |
+------------------+-----+
| ``passenger[1]`` | 1   |
+------------------+-----+
| ``passenger[2]`` | 1   |
+------------------+-----+
| ``passenger[3]`` | 1   |
+------------------+-----+
| ``passenger[4]`` | 2   |
+------------------+-----+
| ``passenger[5]`` | 2   |
+------------------+-----+
| ``passenger[6]`` | 2   |
+------------------+-----+
| ``passenger[7]`` | 2   |
+------------------+-----+
| ``passenger[8]`` | 3   |
+------------------+-----+
| ``passenger[9]`` | 3   |
+------------------+-----+
| ``passenger[10]``| 3   |
+------------------+-----+
| ``passenger[11]``| 3   |
+------------------+-----+

Such grouping can be achieved by the following formula


.. math::

   \text{row} = [i/4]+1

where the square brackets denote the integer part of the fraction :math:`i/4`. Note that the square brackets in a mathematical equation like the one above have no relation to the square brackets we use in Java for array purposes.
The equation above is implemented in **line 13.**   
   
**Lin