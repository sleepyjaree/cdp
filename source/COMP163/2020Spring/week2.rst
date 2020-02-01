
Review of Week 1 and Week 2
=======================================================

During the first two weeks of the course we talked about the fundamentals of sets. A *set* is a collection of distinct objects. For example the colors *red, green,* and *blue*, together form the set :math:`C=\{\text{red},\text{green},\text{blue}\}`. A set can also be defined in *set-builder* notation:

.. math::

   B = \{ x|x^2-4=0\}

The notation above means that :math:`B` is a set with two elements only: :math:`\{-2,2\}`.

Sets can also be denoted by pattern, e.g., :math:`A=\{1,3,5,\ldots, 1001\}` implies a set of odd numbers from  1 to 1001.

A very important property of a set is its *cardinality*. The cardinality is the size of the set, a number that tells us how many elements are in the set. For the sets in the previous examples, the cardinalities are:

.. math::

   |C|&=3 \\
   |B|&=2 \\
   |A|&=501
   
Sets exhibit two interesting behaviors: first, order is irrelevant. For example, :math:`\{1,2\}` is the same set as :math:`\{2,1\}`. And second, duplicate elements count only once. For example, :math:`\{1,2,2,2,2\}` and :math:`\{1,1,2\}` have the same number of elements, i.e., their cardinality is 2. And they are also equal sets because they have identical elements.

A set may be contained in another set. For example, set :math:`D` below is contained in set :math:`E`:

.. math::

   D &= \{0,1\} \\
   E &= \{0,1,2,3,4\}

When this happens, we say that :math:`D` is a subset of :math:`E`. The notation is :math:`D\subset E`. Conversely, :math:`E` is a superset of :math:`D`, i.e., :math:`E\supset D`.

Sets are fundamental constructs that affect every branch of mathematics and science. In computer science, sets are of particular interest because they form the mathematical foundation for relational databases. Since the 1980s, these databases are the dominant paradigm for collecting, organizing, and processing information.



Set operations
++++++++++++++

We looked at three set operations that can be very useful in the context of data analysis.

Set union
---------

The union of two sets is a set that contains all their elements. For example, if :math:`S=\{1,3,5\}` and :math:`T=\{2,4\}`, their union :math:`S\cup T` is the set :math:`\{1,2,3,4,5\}`. Here, :math:`\cup` is the union operator.

Set intersection
----------------

The intersection of two sets is a set that contains only the elements that are common to both sets. For example, if :math:`V=\{0,1,2,3,4\}` and :math:`X=\{0,1\}`, their intersection :math:`V\cap X` is the set :math:`\{0,1\}`.