
Review of Week 7: Midterm wrap-up
=================================

All Java files in this section are `available on Github <https://github.com/lgreco/cdp/tree/master/source/COMP170/codeExamples/midterm-sp2020/src>`_.

We wraped-up week 7 with the midterm exam for the course. In this review we focus on the third question of the test that asked to complete a Class given some specifications. The following code shows a simple and adequate solution to the first part of the third question, highlighting the code that we had to complete.

.. literalinclude:: ../codeExamples/midterm-sp2020/src/SimpleMidterm.java
   :linenos:
   :emphasize-lines: 16, 17
   :language: java
   
For the second part of the third question, we had to add some protection to ensure that our program would not print a large number of lines. The changes are highlighted in the code below. ``int`` variable ``sillyNumber`` is initialized to 100 which is the maximum number of lines we allow our program to print.

.. literalinclude:: ../codeExamples/midterm-sp2020/src/MidtermSimpleProtection.java
   :linenos:
   :lines: 11-21   
   :emphasize-lines: 2,6
   :language: java
   
From this point on, our discussion focused on how to improve and modify this code -- beyond the scope of the midterm test. Specifically, we wanted to test the following modifications:

* obtain the same output but without the use of the ``repeat`` method;
* allow the end-user of the program to determine the symbol to print (as to not limit the output to just rows of hashmarks);
* make the program repeat as long as the number of requested lines is greater than zero (and, of course, less than the maximum number of lines allowed), and;
* protect the input of the program from accidental of intentional mistakes that may lead to runtime errors.

One way to achieve the same output without the ``repeat`` method is shown below. We initialize a string to ``#`` to print, and we keep adding one more ``#`` for every iteration in the loop.

.. literalinclude:: ../codeExamples/midterm-sp2020/src/MidtermMultiple.java
   :lines: 25-29
   :language: java

Another way to achieve the same result, is to use two nested loops as follows:

.. literalinclude:: ../codeExamples/midterm-sp2020/src/MidtermMultiple.java
   :lines: 33-38
   :language: java
   
Allowing the end-user to determine which symbol to print, requires the input of another variable -- let's call it ``symbol``, as follows:

.. literalinclude:: ../codeExamples/midterm-sp2020/src/symbol.txt
   :language: java
   

To make the program repeat as long as the number of requested lines is greater than zero (and, of course, less than the maximum number of lines allowed), we need to create a loop that will execute until the termination condition is met. We initiative a boolean variable to ``true`` value, to allow a while-loop to continue, until the boolean variable is set, by the program, to ``false``. This is highlighted in the code below.

.. literalinclude:: ../codeExamples/midterm-sp2020/src/Midterm.java
   :linenos:
   :emphasize-lines: 21, 28, 35
   :language: java
   


