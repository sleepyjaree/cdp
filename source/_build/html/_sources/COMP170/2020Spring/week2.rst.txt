
Review of Week 1 and Week 2
=======================================================

During the first two weeks of the course we talked about the fundamentals of programming languages, how they interact with the computer hardware at a conceptual level, and how  the steps we take to perform various tasks in every day life (such as cooking, for example) as similar to the contents of a computer program.

Our first program in Java 
-------------------------

The typical first program in any language is a greeting to the world. In Java, this greeting is as follows.

.. code-block:: java
  :linenos:
  
  public class helloWord {
    public static void main(String[] args) {
      System.out.println("Hello World");
    }
  }
  
Our first *real* program
------------------------

Next, we wrote a program to covert kilograms to pounds, assuming a conversion factor of 2.2. In developing our approach to this program we essentially saw how the main operation involves three numbers:

.. math::
   p=c\cdot k
   
where :math:`c` is the conversion factor, :math:`k` is the weight in kilos, and :math:`p` is the weight in pounds. We operationalize this equation in Java by assigning more meaningful names to our variables, and using the the operator ``*`` to perform the multiplication. 

.. code-block:: java
  :linenos:
  
  public class kilosPounds {
    public static void main(String[] args) {
      public static final double conversionFactor=2.2;
	  double weightKilos = 10;
	  double weightPounds;
	  weightPounds = conversionFactor*weightKilos;
	  System.out.println(weightKilos + "kilograms are " + weightPounds + " pounds");
    }
  }
  
The program above also gave us an opportunity to discuss data types, and the difference between ``int`` variables and ``double`` variables.

Next, we introduced a technique to input data directly from the keyboard, allowing us to compile a program once and execute it multiple times:

.. code-block:: java
  :linenos:
  
  import java.util.Scanner;
  public class kilosPounds {
      void main(String[] args) {
      public static final double conversionFactor=2.2;
	  double weightKilos;
	  double weightPounds;
	  Scanner keyboard = new Scanner(System.in);
	  weightKilos = keyboard.nextDouble();
	  weightPounds = conversionFactor*weightKilos;
	  System.out.println(weightKilos + "kilograms are " + weightPounds + " pounds");
    }
  }
  
And finally we discussed about the ability to convert weights in either direction, i.e., from kilograms to pounds and from pounds to kilograms, by making our code a bit more flexible.


.. code-block:: java
  :linenos:

  import java.util.Scanner;
  public class weightConversion {
    public static void main(String[] args) {
        
        final double K2P=2.2;
        double weightInput, weightOutput;
        char weightSystem;
        String unitsIn, unitsOut;
        
        Scanner keyboard = new Scanner(System.in);
        weightInput = keyboard.nextDouble();
        weightSystem = keyboard.next().charAt(0);
		
        if (weightSystem == 'K') {
            // convert from Kilos to pounds
            weightOutput = K2P * weightInput;
            unitsIn = " kilograms ";
            unitsOut = " pounds";
        } else {
            // convert from Pounds to kilos
            weightOutput = (1/K2P) * weightInput;
            unitsIn = " pounds ";
            unitsOut = " kilograms";
        }
        System.out.println(weightInput + unitsIn + "are " + weightOutput + unitsOut);
    }
  }

In this context, we introduced Strings and emphasized their difference from ``char`` variables. That's why in line 12 above, we ask the Scanner object to read a String variable (via the ``next()`` method) and then we apply the ``charAt(0)`` method to obtain the first letter of the string, for our processing.,