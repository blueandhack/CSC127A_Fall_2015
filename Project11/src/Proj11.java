
/* Proj11
 *
 * CSc 127a Fall 15 - Project 11
 *
 * Author: Russell Lewis
 *
 * This implements the main() method for 2048, which we are implementing for
 * Project 11.  This handles user interaction (keyboard) and the basic game
 * loop; it creates an object of type Proj11Board, and then uses instance
 * methods in that class to implement the game mechanics.
 */

import java.awt.event.KeyEvent;

public class Proj11 {
	public static void main(String[] args) {
		Proj11Board board = new Proj11Board();

		// for (int i = 0; i < 4; i++) {
		// for (int j = 0; j < 4; j++) {
		// System.out.print(board.getArray()[i][j]);
		// }
		// System.out.println();
		// }

		board.addOne();
		board.addOne();

		board.draw();

		while (true) {
			// see if the user is hitting a key that involves moving something.
			// If they aren't hitting any key, or if it's the wrong type, then
			// sleep for 10 ms.
			int dir = -1;

			if (StdDraw.isKeyPressed('w') || StdDraw.isKeyPressed('W') || StdDraw.isKeyPressed(KeyEvent.VK_UP))
				dir = 0;
			if (StdDraw.isKeyPressed('a') || StdDraw.isKeyPressed('A') || StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
				dir = 3;
			if (StdDraw.isKeyPressed('s') || StdDraw.isKeyPressed('S') || StdDraw.isKeyPressed(KeyEvent.VK_DOWN))
				dir = 2;
			if (StdDraw.isKeyPressed('d') || StdDraw.isKeyPressed('D') || StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
				dir = 1;

			if (dir == -1) {
				// no key recognized.
				StdDraw.show(10);
				continue;
			}

			// OK, so they are trying to move. See if we can do something.
			boolean changesMade = false;

			if (dir == 0)
				changesMade = board.shiftUp();
			else if (dir == 1)
				changesMade = board.shiftRight();
			else if (dir == 2)
				changesMade = board.shiftDown();
			else
				changesMade = board.shiftLeft();

			if (changesMade == true) {
				board.draw();
				StdDraw.show(500);
			}

			// see if we can collapse anything.

			if (dir == 0)
				changesMade |= board.collapseUp();
			else if (dir == 1)
				changesMade |= board.collapseRight();
			else if (dir == 2)
				changesMade |= board.collapseDown();
			else
				changesMade |= board.collapseLeft();

			if (changesMade) {
				board.draw();
				StdDraw.show(500);
			} else {
				System.out.println("SORRY, no changes can be made sliding in that direction!");
				StdDraw.show(10); // pause, so that we don't flood the user with
									// messages.
				continue;
			}

			// we have altered the board. Add at least one new tile.
			board.addOne();
			if (Math.random() < .25)
				board.addOne(); // it's OK if this one didn't fit...that won't
								// end the game.

			board.draw();
			StdDraw.show(10);
		}
	}

	public static int[][] flip2ndIndex(int[][] input) {
		int size = input.length;

		int[][] retval = new int[size][size];
		for (int x = 0; x < size; x++)
			for (int y = 0; y < size; y++)
				retval[x][size - 1 - y] = input[x][y];

		return retval;
	}

	public static int[][] swapIndices(int[][] input) {
		int size = input.length;

		int[][] retval = new int[size][size];
		for (int x = 0; x < size; x++)
			for (int y = 0; y < size; y++)
				retval[y][x] = input[x][y];

		return retval;
	}
}
