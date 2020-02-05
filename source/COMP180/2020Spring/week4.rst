
Review of Week 4
=======================================================


We are exploring a `data set with information about measles cases <https://github.com/lgreco/cdp/blob/master/source/COMP180/code/measles.csv>`_ for each state and each week, from 1928 to 2002. To manipulate the measles data, we are developing `a notebook that allows us to transform and process the information in the data set <https://github.com/lgreco/cdp/blob/master/source/COMP180/code/US%20Measles%20analysis.ipynb>`_.

The notebook contains the following components.

Dependences
-----------
This cell loads the necessary tools for our work.

.. code-block:: python
  :linenos:
  
  import pandas as pd
  import numpy as np
  import matplotlib.pyplot as plt
  %matplotlib inline

Extraction
----------
This cell reads the data from a *comma separated values* (CSV) file to a ``pandas`` dataframe. We also print a few rows from the dataframe (using the ``.head()``) method, to make sure that the information was brought it correctly. 


.. code-block:: python
  :linenos:
  
  measles = pd.read_csv("measles.csv")
  measles.head()

Transform
---------

As we look at the data, we notice that the set compounds the information about year and week into a six-digit field, of the form ``YYYYWW``, where ``YYYY`` is the year value and ``WW`` is the week value, e.g., 192801 is a label for the first week of 1928. Our analysis can benefit from clear separate values for year and number-of-week in that year, and that's what happens in the block below.
	
.. code-block:: python
  :linenos:
  

  measles["year"] = measles["week"].apply(lambda x: int(str(x)[0:4]))
  measles["week_num"] = measles["week"].apply(lambda x: int(str(x)[4:7]))
  measles.drop("week", axis = 1, inplace = True)  

By inspecting the data set, we note that the first four characters of the field ``week`` represent the actual year while the remaining two, a week in that year. Thus we use the Python function ``str`` to cleave the first four characters (via the ``[0:4]`` reference, and return that value as an ``int`` number into a new column within the dataframe, that we label ``year``).
