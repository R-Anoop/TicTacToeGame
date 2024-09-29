package TicTacToeG;

import java.util.Scanner;

public class TicTacToeGame {
		private static char[][] board = new char[3][3];
	    private static char currentPlayer = 'X';
	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean playAgain = true;
	        
	        while (playAgain) {
	            initializeBoard();
	            boolean gameEnded = false;
	            
	            while (!gameEnded) {
	                printBoard();
	                playerMove(scanner);
	                
	                gameEnded = checkWinner() || checkDraw();
	                
	                if (!gameEnded) {
	                    switchPlayer();
	                }
	            }
	            
	            printBoard();
	            System.out.println("Do you want to play again? (yes/no): ");
	            playAgain = scanner.next().equalsIgnoreCase("yes");
	        }
	        
	        System.out.println("Thanks for playing!");
	        scanner.close();
	    }
	    
	    // Initialize the board with empty spaces
	    private static void initializeBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = ' ';
	            }
	        }
	    }
	    
	    // Print the current board
	    private static void printBoard() {
	        System.out.println("-------------");
	        for (int i = 0; i < 3; i++) {
	            System.out.print("| ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " | ");
	            }
	            System.out.println("\n-------------");
	        }
	    }
	    
	    // Player move input and validation
	    private static void playerMove(Scanner scanner) {
	        int row = -1, col = -1;
	        boolean validInput = false;
	        
	        while (!validInput) {
	            System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1 2): ");
	            row = scanner.nextInt() - 1;
	            col = scanner.nextInt() - 1;
	            
	            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
	                validInput = true;
	                board[row][col] = currentPlayer;
	            } else {
	                System.out.println("This move is invalid. Try again.");
	            }
	        }
	    }
	    
	    // Switch to the next player
	    private static void switchPlayer() {
	        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	    }
	    
	    // Check if the current player has won
	    private static boolean checkWinner() {
	        // Check rows, columns, and diagonals
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
	                System.out.println("Player " + currentPlayer + " wins!");
	                return true;
	            }
	            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
	                System.out.println("Player " + currentPlayer + " wins!");
	                return true;
	            }
	        }
	        
	        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
	            System.out.println("Player " + currentPlayer + " wins!");
	            return true;
	        }
	        
	        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
	            System.out.println("Player " + currentPlayer + " wins!");
	            return true;
	        }
	        
	        return false;
	    }
	    
	    // Check if the game is a draw (no more empty spaces)
	    private static boolean checkDraw() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == ' ') {
	                    return false;
	                }
	            }
	        }
	        System.out.println("The game is a draw!");
	        return true;
	}

}
