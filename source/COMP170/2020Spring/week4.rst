
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

The following code is a small demonstration of loop techniques applied on Strings. `The code is made available, for now, as bytecode <https://github.com/lgreco/cdp/raw/master/source/COMP170/codeExamples/loopExamples.class>`_, i.e., an executable that you can run on any JVM. 

To run the bytecode open the Terminal application in macOS or the command prompt on Windows, go to the folder where you've downloaded the bytecode, and enter the command: ``java loopExamples``.