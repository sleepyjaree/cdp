
Review of Week 9: Arrays, TicTacToe
===================================
 

A copy of `the TicTacToe Class we designed on Friday 3/20/20 is available on Github <https://github.com/lgreco/cdp/blob/master/source/COMP170/codeExamples/tictactoe/src/TicTacToe.java>`__. This implementation is missing some functionality. It cannot tell when the game is a tie or when there is a diagonal winning strike. 

These issues are corrected in versions 2 and 3 of the game. `For now we'll focus on version 3 <https://github.com/lgreco/cdp/blob/master/source/COMP170/codeExamples/tictactoe/src/TicTacToe3.java>`__. Take a look at the code and see if you can explain to someone who is just starting to learn programming, what each method does. The comments in the code are there to help you, so you need to go a bit further than that.

For example, method ``setUpGame()``, is designed to "set up a clean game board. Set all squares to empty" according to the comments. But you should be able to explain that this is accomplished by two nested loops and maybe describe how nest loops work, by writing down the values of their indices, at every step. In this case:

+-------+---------------+---------------+---------------+---------------+
| ``i`` |        0      |        1      |        2      |        3      |
+-------+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
| ``j`` | 0 | 1 | 2 | 3 | 0 | 1 | 2 | 3 | 0 | 1 | 2 | 3 | 0 | 1 | 2 | 3 |
+-------+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
