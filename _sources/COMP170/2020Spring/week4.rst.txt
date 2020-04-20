
Review of Week 4
=================

In week 4, we reviewed loops. Loops are control structures that repeat groups of operations until certain conditions are met. Useful as they are, loops are also inherently dangerous. If the terminating condition is not correct, the loop will execute "for ever". Meaning that we'll have to restart the JVM or event the computer, to make the runaway loop stop.

Loops repeat operations and that's very helpful for iterative operations. Consider, for example, that we want to compute the sum 

.. math::
   
   \sum_{k=1}^{n} k
   
Of course we know that the num of the first :math:`n` numbers is :math:`n(n+1)/2` but we can also compute it iteratively as follows:
  
.. code-block:: java
  :linenos:
  
  import java.util.Scanner;
  public class sumExample {
      public static void main(String[] args) {
	  
          int sum=0;
          int k=0;

          Scanner keyboard = new Scanner(System.in);
          System.out.println("\n Enter an integer number to add up to: ");
          int N = keyboard.nextInt();

          while ( k < N+1 ) {
              sum = sum+k;
              k++;
          }
		  
          System.out.println("\nThe sum of the first " + N + " numbers is: "+sum);
		  
      }
  }
  
The loop structure in the program above comprises just four lines of code:
  
.. code-block:: java

          while ( k < N+1 ) {
              sum = sum+k;
              k++;
          }
		  

The first line contains the condition that terminates the loop. The repetitive part of the loop follows the ``while`` statement and is contained within curly brackets. A loop usually contains operations that get it closer to termination. In the example above, we increase variable ``k`` by 1 each time we execute the loop. Eventually, the value of ``k`` will exceed the value of ``N`` and the termination condition will be satisfied.

The loop above can also be constructed as:

.. code-block:: java

          do {
              sum = sum+k;
              k++;
          } while ( k < N+1 ) ;

The difference between the while-loop and the do-loop is best illustrated by the following cartoon:

.. figure:: images/coyote.jpg
   
   A compelling presentation of the difference between the while-loop and the do-loop.
   Source unknown; most verifiable citation: `Reddit, 2019 <https://www.reddit.com/r/ProgrammerHumor/comments/a5mghb/the_importance_of_knowing_how_to_correctly_use/>`_.

Loop demos
----------

The following code is a small demonstration of loop techniques applied on Strings. `The code was made available, originally, as bytecode <https://github.com/lgreco/cdp/raw/master/source/COMP170/codeExamples/loopExamples.class>`_, i.e., an executable that you can run on any JVM. 

To run the bytecode open the Terminal application in macOS or the command prompt on Windows, go to the folder where you've downloaded the bytecode, and enter the command: ``java loopExamples``.

The source code is `available on Github <https://github.com/lgreco/cdp/blob/master/source/COMP170/codeExamples/loopExamples.java>`_.

Loops in mathematical iterations
--------------------------------

Loops are very useful when we write programs to perform numerical computations that are iterative in nature. Consider, for example, the Newton method for finding the square root of a number, :math:`n`. Its square root, :math:`\sqrt{n}` is approximated by the sequence :math:`x_{k+1}`:

.. math::
   x_{k+1} = \frac{1}{2}(x_k+\frac{n}{x_k}) \\
   
with :math:`x_0=1`.

The formula above generates a sequence :math:`x_0, x_1, \ldots, x_k, x_{k+1}, \ldots` that converges to :math:`\sqrt{n}`. Each member of the sequence is generated using the value of the previous member, so really we only need two variables to compute the sequence: one variable for the current value and one for the next value.

.. code-block:: java

   xNext = 0.5 * ( xCurrent + n/xCurrent );
   
We need to wrap this formula in a loop:

.. code-block:: java
   
   xCurrent = 0;
   keepGoing = true;
   do {
     xNext = 0.5 * ( xCurrent + n/xCurrent );
	 // need to make a decision to continue or stop
   } while (keepGoing);

The next step is to determine how and when to exit the loop. If we looked at the sequence for :math:`n=10`, we notice the following progression:

+--------------------------------+----------------------+-----------------------+
| **Term**                       | **Value**            | :math:`\delta`        |
+================================+======================+=======================+
| :math:`x_0`                    | 1                    | :math:`|x_{k+1}-x_k|` |
+--------------------------------+----------------------+-----------------------+
| :math:`x_1=(x_0+n/x_0)/2`      | 5.5                  | 4.5                   |
+--------------------------------+----------------------+-----------------------+
| :math:`x_2=(x_1+n/x_1)/2``     | 3.659090909          | 1.840909091           |
+--------------------------------+----------------------+-----------------------+
| :math:`x_3=(x_2+n/x_2)/2``     | 3.196005082          | 0.4630858272          |
+--------------------------------+----------------------+-----------------------+
| :math:`x_4=(x_3+n/x_3)/2``     | 3.162455623          | 0.03354945907         |
+--------------------------------+----------------------+-----------------------+
| :math:`x_5=(x_4+n/x_4)/2``     | 3.162277665          | 0.0001779576282       |
+--------------------------------+----------------------+-----------------------+
| :math:`x_6=(x_5+n/x_5)/2``     | 3.16227766           | 0.000000005007295911  |
+--------------------------------+----------------------+-----------------------+
| :math:`x_7=(x_6+n/x_6)/2``     | 3.16227766           | 0                     |
+--------------------------------+----------------------+-----------------------+



Notice that after 5-6 iterations the sequence converges to the value 3.16227766, that happens to be the square root of 10. As the sequence converges, the difference between successive values becomes smaller and smaller. Eventually, at convergence, the difference :math:`\delta` becomes 0 or very close to it. This could be our mechanism for exiting the loop:


.. code-block:: java
   
   EPSILON = 0.00001;
   xCurrent = 0;
   keepGoing = true;
   do {
     xNext = 0.5 * ( xCurrent + n/xCurrent );
     delta = Math.abs( xNext-xCurrent );
     if ( delta < EPSILON )
       keepGoing = false;
   } while ( keepGoing );
   
Finally, we put everything together. We declare two final variables, ``EPSILON`` AND ``RUNAWAY`` that control when and how the program ends. ``EPSILON`` is our tolerance for convergence: how close we wish the successive valued of :math:`x_{k+1}` and :math:`x_k` to get, before we accept the approximate square root? ``RUNAWAY`` is the number of iterations we allow our program to perform before we end without result, to avoid an infinite loop.

.. code-block:: java
   :linenos:
   
   import java.util.Scanner;

   public class sqrt { 
     public static final double EPSILON = 0.00001;
     public static final int RUNAWAY = 10000;
	
     public static void main(String[] args) { 
	 
       double n=0;
       int counter=0;
       double xCurrent = 1, xNext, delta;
       boolean keepGoing = true;
	  
       Scanner keyboard = new Scanner(System.in);
	  
       while (n>=0) {
	  
         System.out.println("\n\nEnter a number to computer its square root.");
         System.out.println("(Negative number will terminate the program)");
         n = keyboard.nextDouble();
	  
         if ( n>=0 ) {
		 
           do { 
		   
             xNext = 0.5 * ( xCurrent + n/xCurrent ); 
             delta = Math.abs( xNext-xCurrent ); 
			
             if ( delta < EPSILON ) {
               keepGoing = false; 
             } else {
               xCurrent = xNext;
             }
			
             if ( counter > RUNAWAY) {
               keepGoing=false;
             } else {
               counter++;
             }
			
           } while ( keepGoing ); 
		  
           System.out.println("Approximate square root of "+n+" is  "+xNext+"\n\t("+counter+" iterations)");
		  
         }
        } 
      }
    }
	
