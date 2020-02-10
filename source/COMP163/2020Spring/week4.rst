
Review of Week 4
=================

In week 4 we finished reviewing logic, propositions, conditional propositions, and necessary and sufficient conditions. For a change of pace we moved to discussing algorithms. Algorithms are groups of instructions that perform specific tasks, like solving problems. These groups of well defined instructions receive their name from `Muḥammad ibn Mūsā al-Khwārizmī <https://en.wikipedia.org/wiki/Muhammad_ibn_Musa_al-Khwarizmi>`_, a Persian scholar who lived in the 8th century and developed methods for problem solving that are considered the first algorithms.

Algorithms can be simple procedures, like the following one that finds the largest of two numbers::

  largestOfTwo(a,b)
  largest <-- a;
  if b > largest:
    largest <-- b;
  return largest; 
  
In the notation above, the left arrow ``<--``, is the assignment operator. ``largest<--a;`` means that the value of ``a`` is assigned to the variable ``largest``. This is similar to the algebraic operator :math:`=`, but with the following caveat. In algebra, the expression :math:`x=x+y` implies that :math:`y=0`. In algorithms (and in programming), the expression ``x=x+y`` (or ``x <-- x+y``) means that we first evaluate the right part and then we assign its value to the left part.

.. image:: images/max.png
  :align: right
  :height: 300 px
  
Algorithms are described visually, as flow charts shown to the right, or verbally, as shown above. The verbal description of algorithms is called **pseudocode.** In many ways pseudocode resembles a computer program but without the syntax rigor of programming languages. Because of that resemblance, pseudocode is usually a better way to express an algorithm than a flow chart.

Algorithms can be more complex, like the following one that finds the largest number in a sequence :math:`s(n)` of :math:`n` numbers, :math:`s_1, s_2, \ldots, s_n`::

  largestInSequence ( s(n) )
  largest <-- s[1];
  i <-- 2;
  while (i <= n) {
    if s[i] > largest:
      largest <-- s[i];
    i <-- i+1;
  }
  return largest;

