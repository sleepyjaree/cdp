public class TicTacToe {

    private static final int SIZE = 3;
    private static final char A = 'x'; // x marks
    private static final char B = 'o'; // o marks
    private static final char E = ' '; // - for empty squares

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
    }

    /**
     * Display the board
     */
    public void displayBoard() {
        System.out.print("    +---+---+---+\n");
        System.out.print("    | 1 | 2 | 3 |\n");
        System.out.print("+---+---+---+---+\n");
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
        //boolean squareAvailable;
        //if (gameBoard[i][j] == E) {
        //    squareAvailable = true;
        //} else {
        //    squareAvailable = false;
        //}
        //return squareAvailable;}
        return gameBoard[i][j] == E;
    }

    /**
     * Determines if game won
     */
    public boolean gameWon() {
        boolean win = false;
        for ( int i = 0; i < SIZE; i++ ) {
            if ( (gameBoard[i][0] == gameBoard[i][1]) && (gameBoard[i][1] == gameBoard[i][2]) &&  (gameBoard[i][0] != E) )  {
                win=true;
            }
        }
        for ( int j = 0; j < SIZE; j++ ) {
            if ( (gameBoard[0][j] == gameBoard[1][j]) && (gameBoard[1][j] == gameBoard[2][j]) && (gameBoard[0][j] != E) ) {
                win=true;
            }
        }

        return win;
    }

    /**
     * Controls the game.
     */
    public void play() {}

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.setUpGame();
        game.displayBoard();
        System.out.println("\n Game won? " + game.gameWon());
    }

}
