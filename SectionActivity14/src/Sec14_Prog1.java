
public class Sec14_Prog1 {
	/* --- METHODS THAT YOU NEED TO IMPLEMENT --- */

	public static char[][] initBoard() {
		char board[][] = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				board[i][j] = ' ';

				if (j == 0 || j == 1 || j == 2) {
					if (i % 2 == 0 && (j == 0 || j == 2)) {
						board[i][j] = 'r';
					}
					if (i % 2 == 1 && j == 1) {
						board[i][j] = 'r';
					}
				} else if (j == 5 || j == 6 || j == 7) {
					if (i % 2 == 1 && (j == 5 || j == 7)) {
						board[i][j] = 'b';
					}
					if (i % 2 == 0 && j == 6) {
						board[i][j] = 'b';
					}
				}

			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

		return board;
	}

	public static void drawBoard(char[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						StdDraw.setPenColor(32, 32, 32);
						StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
					} else {
						StdDraw.setPenColor(192, 192, 192);
						StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
					}
				} else {
					if (j % 2 == 1) {
						StdDraw.setPenColor(32, 32, 32);
						StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
					} else {
						StdDraw.setPenColor(192, 192, 192);
						StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
					}
				}
				if (board[i][j] == 'r') {
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledCircle(i + 0.5, j + 0.5, 0.4);
				}
				if (board[i][j] == 'b') {
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.circle(i + 0.5, j + 0.5, 0.4);
				}

			}
		}
		
		StdDraw.show(0);

	}

	/*
	 * --- METHODS THAT ARE ALREADY DONE ---
	 *
	 * You are allowed to change these methods if you like, but it shouldn't be
	 * necessary.
	 */

	public static void main(String[] args) {
		StdDraw.setScale(0, 8);
		StdDraw.show(0); // turns on buffered mode, so the board all appears at
							// once

		// allocate a brand-new board
		char[][] board = initBoard();
		if (!sanityCheckBoard(board))
			return;

		// draw the board to the screen
		drawBoard(board);

		// we use System.out (which prints to the Interactions pane)
		// as a way to communicate with the user; it's not a very good
		// one (text on the board would be better!), but I don't want
		// to interfere with the picture that the students have drawn.
		System.out.println("***********************");
		System.out.println("* WELCOME TO CHECKERS *");
		System.out.println("***********************");
		System.out.println("Click (don't drag!) on any piece to move it.");
		System.out.println();

		// the main loop of the game: wait for mouse moves
		while (true) {
			// wait for the click on the *FIRST* square, which
			// should be a piece.
			while (StdDraw.mousePressed() == false)
				StdDraw.show(10);

			// read the current mouse position, at the start of the click (drags
			// are ignored)
			int startX = (int) StdDraw.mouseX();
			int startY = (int) StdDraw.mouseY();

			// loop until the user is *NO LONGER* clicking. Note that our loop
			// is more aggressive here (shorter wait time)
			while (StdDraw.mousePressed())
				StdDraw.show(1);

			// the user is no longer holding the mouse button...now process the
			// click.
			System.out.printf("You clicked on the location (%d,%d)\n", startX, startY);
			if (startX < 0 || startX > 7 || startY < 0 || startY > 7) {
				System.out.printf("  ERROR: The location (%d,%d) is not on the board.  Your click has been ignored.\n",
						startX, startY);
				continue; // go back to the head of the loop
			}
			if (board[startX][startY] == ' ') {
				System.out.println(
						"  ERROR: You clicked on a location which is not occupied by a piece.  Please try again.");
				continue; // go back to the head of the loop
			}

			// wait for the next click; do the same algo as before...
			while (StdDraw.mousePressed() == false)
				StdDraw.show(10);
			int endX = (int) StdDraw.mouseX();
			int endY = (int) StdDraw.mouseY();
			while (StdDraw.mousePressed())
				StdDraw.show(1);
			System.out.printf("Your second click was at the location (%d,%d)\n", endX, endY);
			if (endX < 0 || endX > 7 || endY < 0 || endY > 7) {
				System.out.printf(
						"  ERROR: The location (%d,%d) is not on the board.  Please start over from the beginning.\n",
						endX, endY);
				continue; // go back to the head of the loop
			}

			// update the board by moving the piece to its new location; clear
			// the start
			board[endX][endY] = board[startX][startY];
			board[startX][startY] = ' ';
			drawBoard(board);
		}
	}

	public static boolean sanityCheckBoard(char[][] board) {
		/*
		 * confirm that the size of the array is correct. This is the first
		 * dimension.
		 */
		if (board.length != 8) {
			System.out.println("ERROR: Your initBoard() method does not allocate an 8x8 array!");
			return false;
		}

		/*
		 * confirm that the size of the array is correct. This is the second
		 * dimension for each sub-array.
		 */
		for (int i = 0; i < 8; i++) {
			if (board[i].length != 8) {
				System.out.println("ERROR: Your initBoard() method does not allocate an 8x8 array!");
				return false;
			}
		}

		/* confirm that every element of the array is valid */
		for (int x = 0; x < 8; x++)
			for (int y = 0; y < 8; y++) {
				if (board[x][y] != ' ' && board[x][y] != 'r' && board[x][y] != 'b' && board[x][y] != 'R'
						&& board[x][y] != 'B') {
					System.out.printf("ERROR: Your initBoard() method gives an invalid character at element [%d][%d]\n",
							x, y);
					return false;
				}
			}

		return true;
	}
}
