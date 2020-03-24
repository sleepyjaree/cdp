import java.util.Scanner;
import java.util.Random;

/**
 * A class that implements Tic Tac Toe in 2-dimensions, on an
 * arbitrary-sized board.
 */

public class TicTacToe3 {

    private static final int SIZE = 3; // board size
    private static final char A = 'x'; // x marks
    private static final char B = 'o'; // o marks
    private static final char E = ' '; // empty squares

    Scanner keyboard = new Scanner(System.in);

    private int x,y;

    private int filledSquares;         // helpful for determining a tie
    private String playerA, playerB;

    private char[][] gameBoard = new char[SIZE][SIZE];

    /**
     * Set up a clean game board. Set all squares to empty
     */
    public void setUpGame () {
        for ( int i = 0; i < SIZE; i++ ) {
            for ( int j = 0; j < SIZE; j++ ) {
                gameBoard[i][j] = E;
            }
        }
        filledSquares = 0; // at the beginning all squares are empty
    }

    /**
     * Display the board
     */
    public void displayBoard() {
        System.out.print("    +---+---+---+\n"); // at some point I need
        System.out.print("    | 1 | 2 | 3 |\n"); // to parametrize these
        System.out.print("+---+---+---+---+\n"); // strings ...
        for ( int i = 0; i < SIZE; i++ ) {
            System.out.print("| " + (i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print("| " + gameBoard[i][j] + " ");
            }
            System.out.print("|\n");
            System.out.print("+---+---+---+---+\n");

        }
    }

    /**
     * Determines if square (i,j) is available
     */
    public boolean available(int i, int j) {
        return gameBoard[i][j] == E;
    }

    /**
     * Method to let a player occupy square
     */
    public void occupy(int i, int j, char playerSymbol) {
        gameBoard[i][j] = playerSymbol;
        filledSquares++;
    }

    /**
     * Determines if game won
     */
    public boolean gameWon() {
        boolean wr, wc;
        boolean winRow = false, winCol = false;
        boolean winDiagonal = true, winAntiDiagonal = true;
        for ( int i = 0; i < SIZE; i++ ) {
            wr = gameBoard[i][0] != E ;
            wc = gameBoard[0][i] != E ;
            for ( int j = 0; j < SIZE - 1; j++ ) {
                wr = wr && gameBoard[i][j] == gameBoard[i][j+1];
                wc = wc && gameBoard[j][i] == gameBoard[j+1][i];
            }
            if (wr) { winRow = true; } // otherwise winRow false
            if (wc) { winCol = true; } // otherwise winCol false
        }

        winDiagonal = gameBoard[0][0] != E;
        winAntiDiagonal = gameBoard[0][SIZE-1] != E;

        for ( int i = 0; i < SIZE-1; i++) {
            winDiagonal = winDiagonal && (gameBoard[i][i] == gameBoard[i+1][i+1]) ;
            winAntiDiagonal = winAntiDiagonal && (gameBoard[i][SIZE-1-i] == gameBoard[i+1][SIZE-1-(i+1)]);
        }

        return (winRow || winCol || winDiagonal || winAntiDiagonal);
    }

    /**
     * Method to check if game is a tie
     */
    public boolean gameTie() { return ( filledSquares == SIZE*SIZE ); }

    /**
     * Obtain player names and determine, randomly, who's on first!
     */
    public void players() {
        System.out.println("Enter name of Player A");
        playerA = keyboard.next();
        System.out.println("Enter name of Player B");
        playerB = keyboard.next();
        Random rand = new Random();                 // we flip a coin to determine which player
        int coinFlip = rand.nextInt(10);    // will be first. Coin toss is simulated by
        if ( coinFlip > 4 ) {                       // a random integer from 0 to 9. If it is
            String tmp = playerA;                   // greater than 4, then player B is first,
            playerA = playerB;                      // otherwise, playerA is first.
            playerB = tmp;                          //
        }
        System.out.println("Following a coin flip,\n\tfirst player is "+ playerA + " and second player is "+playerB+"\n");
    }

    /**
     * Enables player to make a move
     */
    public void makeMove(String player, char playerSymbol) {
        displayBoard();
        System.out.println(player + " make a move");
        x = keyboard.nextInt() - 1; // later on we need to check if x,y are
        y = keyboard.nextInt() - 1; // proper values, i.e., 0...SIZE
        // is the square at x, y free?
        if (available(x, y)) {
            occupy(x, y, playerSymbol);
        }
        if (gameWon()) {
            displayBoard();
            System.out.println(player + " just won the game.");
        }
    }

    /**
     * Controls the game.
     */
    public void play() {
        players();
        setUpGame();
        while ( !gameWon() && !gameTie() ) {
            if ( !gameWon() && !gameTie() ) { makeMove(playerA,A); }
            if ( !gameWon() && !gameTie() ) { makeMove(playerB,B); }
        }
        if ( gameTie() && !gameWon() ) { System.out.println("Game is a tie"); }
    }

    public static void main(String[] args) {
        TicTacToe3 game = new TicTacToe3();
        game.play();
    }

}
