
Direct proofs
-------------

This is the easiest kind of proofs, relatively speaking. We use axioms, definitions, and proven theorems, to establish a proof. An example of a direct proof is to show that if two numbers are odd, their sum is an even number, i.e.,

.. math::
   \text{if}\ x,y\ \text{odd} \Rightarrow x+y\ \text{even}
   
The proof is quite straight forward: if :math:`x` is odd then :math:`x=2m+1`, i.e. it is, by definition, a multiple of 2 (:math:`2m`) plus one. Similarly, :math:`y=2n+1`; where :math:`m\ \text{and}\ n` are arbitrary integer numbers. Adding them together:

.. math::
   \left.\begin{array}{c}x=2m+1\\y=2n+1\end{array}\right\} \Rightarrow x+y = 2n+2m+2 = 2(n+m+1) = 2k

with :math:`k=n+m+1`. Thus we showed that the sum of two odd numbers is a multiple of 2, which by definition is an even number.