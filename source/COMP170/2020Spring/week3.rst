
Review of Week 3
=================

In week 3 we looked at String variables and their relation to ``char`` primitive types. We also looked that the basic ``if-then-else`` control structure.

A not-so-simple look into ``char`` and Strings
----------------------------------------------

One problem we saw in class has to do with the comparison between a `char` primitive and a `String` variable. Specifically, we saw that

.. code-block:: java
  :linenos:
  
  char letter1 = 'a';
  String letter2 = "a";
  
results into two variables that although they *appear* to hold the same information, i.e., the letter **a,** they are two different entities. And therefore, the comparison between the two of them is not possible: 

.. code-block:: java
  
  if ( letter1 == letter2 ) ...
  
If we tried to compile a statement like the one above, we will get an error message. Because one entity is an object; the other is a primitive variable. The example we used in class is trying to compare two apples: on our left hand we have an apple. On our right hand we have a box that contains another apple. Both fruits are identical. But until we open the box, we are simply comparing an apple to a box. In this analogy, `String` is the boxed apple; `char` is the plain one. To make the entities comparable, in Java, we have to "deference" the String object, i.e., we must make it look like a primitive. This is accomplished with the `.equals()` method:

.. code-block:: java
  
  if ( letter2.equals(letter2) ) ...
  
If only things were that straightforward! Consider the following program (which you can copy and paste and compile and run to test it):
  
  
.. code-block:: java
  :linenos:
  
  public class equalStrings {
    public static void main(String[] args) {

        // Part 1

        String s1 = "Hello";
        String s2 = "Hello";

        if ( s1 == s2 ) {
            System.out.println("The strings s1 and s2 are equal");
        } else {
            System.out.println("The strings s1 and s2 are NOT equal");
        }

        // Part 2

        String t1 = new String("Hello");
        String t2 = new String("Hello");

        if ( t1==t2 ) {
            System.out.println("The strings t1 and t2 are equal");
        } else {
            System.out.println("The strings t1 and t2 are NOT equal.");
        }
    }
  }

In the code above, strings `s1` and `s2` are equal but `t1` and `t2` are not, even though both pairs contain the same data (the word "Hello"). What's happening here?

Java is smart enough to realize, as it is compiling the code above, that the value "Hello" is used at least twice: once for `String s1` and once more for `String s2`. So it makes these two variables reference the same memory location where a single copy of "Hello" is stored. 

And what about variables `t1` and `t2`? There variables are created as **new** strings. This is forcing the compiler to allocate separate memory space for these two copies of "Hello".

The end result is that ``s1==s2`` evaluates to true because both entities point to the same memory location, but ``t1==t2`` evaluates to false because these entities point to different memory locations. In other words, the ``==`` operator between strings compares the entities' locations in memory, not their content. To compare the content between two entities that occupy different memory locations, as is the case with `t1` and `t2`, we must apply the `.equals()` method: ``t1.equals(t2)`` will evaluate to true.

Notice that the method ``.equals()`` works between entities of similar structure and complexity -- in the example above, ``t1`` and ``t2`` are *string objects*, and as such have the similar complexity and structure that allows them to be compared to each other.

Assigning `s1` and `s2` to the same memory location is called *string interning*. String interning is beyond the scope of COMP 170. Its description however, can be found in the `Java Language Specification, section 3.10.5 <https://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.5>`_ and in the documentation for the `java.lang package <https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#intern()>`_.

Currency converter
----------------------------------------------

It is the mismatch between ``char`` and ``String`` that prevents our currency conversion program to work correctly.

.. code-block:: java
  :linenos:
  
  import java.util.Scanner;
  public class currencyConverter {

      public static final double EURUSD = 1.2; // from EUR to USD

      public static void main(String[] args) {

          double amountToConvert, amountConverted;
          char fromThisCurrency;

          Scanner keyboard = new Scanner(System.in);
          amountToConvert = keyboard.nextDouble();
          fromThisCurrency = keyboard.next().charAt(0);

          if ( "D".equals(fromThisCurrency) ) {
              amountConverted = amountToConvert*(1/EURUSD);
          } else {
              amountConverted = amountToConvert*EURUSD;
          }

          if ( "D".equals(fromThisCurrency) ) {
              System.out.println ("Executing USD to EUR conversion");
              System.out.println ( "$ "+ amountToConvert + " equal to " 
                  + "E " + amountConverted); 
          } else {
              System.out.println ("Executing EUR to USD conversion");
              System.out.println ( "E "+ amountToConvert + " equal to " 
                  + "$ " + amountConverted); 
          }
      }
  }

The mismatch between ``char`` and ``String`` can be addressed by comparing the ``charAt(0)`` value we read from the ``Scanner`` to the primitive ``'D'``, i.e., the letter D enclosed in *single* quotes. The improved version of the currency conversion program is listed below.

.. code-block:: java
  :linenos:
  
  import java.util.Scanner;
  public class currencyConverterFormatted {
      /**
       * This is a currency conversion program between USD and EUR
       */
      public static final double EURUSD = 1.11;  // EUR to USD rate
      public static final String USD = "\u0024"; // unicode for USD symbol
      public static final String EUR = "\u20ac"; // unicode for EUR symbol

      public static void main(String[] args) {

          double amountToConvert, amountConverted;
          char fromThisCurrency;
          String fromSymbol, toSymbol;

          Scanner keyboard = new Scanner(System.in);
          amountToConvert = keyboard.nextDouble();
          fromThisCurrency = keyboard.next().charAt(0);

          if ( fromThisCurrency=='D') {
              amountConverted = amountToConvert*(1/EURUSD);
              fromSymbol = USD;
              toSymbol = EUR;
          } else {
              amountConverted = amountToConvert*EURUSD;
              fromSymbol = EUR;
              toSymbol = USD;
          }

          System.out.printf(fromSymbol+"%.2f",amountToConvert);
          System.out.printf(" is the equivalent of ");
          System.out.printf(toSymbol+"%.2f", amountConverted);

      }
  }
  

