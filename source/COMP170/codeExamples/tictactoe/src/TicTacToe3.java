import java.util.Scanner;

public class TicTacToe3 {

    private static final int SIZE = 3;
    private static final char A = 'x'; // x marks
    private static final char B = 'o'; // o marks
    private static final char E = ' '; // empty squares

    private int filledSquares;         // helpful for determining a tie
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
        filledSquares = 0;
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
            if (wr) {
                winRow = true;
            }
            if (wc) {
                winCol = true;
            }
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
     * Controls the game.
     */
    public void play() {
        int x,y;
        String nameA, nameB;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter name of Player A");
        nameA = keyboard.next();
        System.out.println("Enter name of Player B");
        nameB = keyboard.next();
        setUpGame();
        // somewhere here we need a random selection who's on first

        while ( !gameWon() && !gameTie() ) {

            if ( !gameWon() && !gameTie() ) {
                displayBoard();
                System.out.println(nameA + " make a move");
                x = keyboard.nextInt() - 1; // later on we need to check if x,y are
                y = keyboard.nextInt() - 1; // proper values, i.e., 0...SIZE
                // is the square at x, y free?
                if (available(x, y)) {
                    occupy(x, y, A);
                }
                if (gameWon()) {
                    displayBoard();
                    System.out.println(nameA + " just won the game.");
                }
            }

            if ( !gameWon() && !gameTie() ) {
                displayBoard();
                System.out.println(nameB + " make a move");
                x = keyboard.nextInt() - 1; // later on we need to check if x,y are
                y = keyboard.nextInt() - 1; // proper values, i.e., 0...SIZE
                // is the square at x, y free?
                if (available(x, y)) {
                    occupy(x, y, B);
                }
                if (gameWon()) {
                    displayBoard();
                    System.out.println(nameB + " just won the game.");
                }
            }
        }
        if ( gameTie() && !gameWon() ) { System.out.println("Game is a tie"); }
    }

    public static void main(String[] args) {
        TicTacToe3 game = new TicTacToe3();
        game.play();
        System.out.println("\n Game won? " + game.gameWon());
    }

}
