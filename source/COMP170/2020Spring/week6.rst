
Review of Week 6
=================

As we continue our exploration of Classes and Methods, and the fine line between programmers as Users and programmers as Developers, we are practicing the design and implementation of simple but illustrative examples.

.. image:: images/MenuItem.png
   :align: right
   :width: 44%
   
For this week's example, we act in our capacity as programmers-Developers to design and implement a class for menu items that will be part of a larger application for restaurants; shown to the right. After much deliberations, we settled on naming the class ``MenuItems``. 

The late Phil Karlton, an iconoclast pioneer in computer programming, once quipped that "there are only two hard things in Computer Science: cache invalidation and `naming things <https://www.njtierney.com/post/2018/06/20/naming-things/>`_." [*]_ So in a tribute to Phil, I changed the name of the class to ``MenuItem`` (singular)!

We readily mapped this design to the following code: 

.. literalinclude:: ../codeExamples/User-v-Dev/MenuItem.java
   :linenos:
   :language: java


.. [*] This story is corroborated by Phil Karlton's son, David, in a 2017 `post on Stackexchange <https://skeptics.stackexchange.com/a/39178>`_: "*As his only son, and colleague with him at Netscape from 95-97, I can attest that my dad did indeed throw that quote around, on more than one occasion. I'm fairly confident that he originated it (he was fond of coming up with clever quippets), though I haven't been able to figure out how it disseminated so widely over the past couple of decades. I'll keep looking around in old web archives and mails to see if I can dig something up.*"
