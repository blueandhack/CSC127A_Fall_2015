
/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 11
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 * The program is a game that name is 2048.
 * 2048 is a game that is played on a 4x4 grid of tiles. 
 * Each tile may be empty, or it may have a number; 
 * the numbers are always powers of 2, starting at 2 and going up.
 */
import java.util.Random;

public class Proj11Board {

	// named one attribute
	private int array[][];

	// get method for array
	public int[][] getArray() {
		return array;
	}

	// set method for array
	public void setArray(int[][] array) {
		this.array = array;
	}

	// constructor method generates object
	public Proj11Board() {
		super();
		this.array = new int[4][4];
	}

	// create a canvas, and put array to the board
	public void draw() {
		StdDraw.clear();
		StdDraw.setScale(0, 4);
		StdDraw.show(0);
		// get array and put array to the board
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				StdDraw.rectangle(i + 0.5, j + 0.5, 0.5, 0.5);
				if (array[i][j] != 0) {
					StdDraw.text(i + 0.5, j + 0.5, array[i][j] + "");
				}
			}
		}
		StdDraw.show(0);

	}

	// add one number at the board
	public void addOne() {

		int sumZero = 0;
		int oneX = 0, oneY = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j] == 0) {
					sumZero++;
					oneX = i;
					oneY = j;
				}
			}
		}

		Random rand = new Random();
		// random of x and y indexes
		int x = rand.nextInt(4);
		int y = rand.nextInt(4);
		// the number for probability
		int number = rand.nextInt(100);

		// if the board doesn't have any empty space, it cannot create number
		if (sumZero == 0) {
			return;
		}

		// if the board has only one empty space, fill it out
		if (sumZero == 1) {
			if (number < 20) {
				// 20% probability to fill out 4
				array[oneX][oneY] = 4;
			} else {
				array[oneX][oneY] = 2;
			}
			return;
		}

		// create one number when the space is empty
		while (true) {
			if (array[x][y] == 0) {
				if (number < 20) {
					array[x][y] = 4;
					break;
				} else {
					array[x][y] = 2;
					break;
				}
			}
			x = rand.nextInt(4);
			y = rand.nextInt(4);
		}

	}

	// shift up, down, left and right
	// ==============================

	// ^
	// |
	public boolean shiftUp() {
		int[] countElement = { 0, 0, 0, 0 };
		int[] lastIndex = { 4, 4, 4, 4 };

		// count every column has how many elements
		// got last index for every column
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (array[i][j] != 0) {
					countElement[i]++;
					lastIndex[i] = j;
				}
			}
			countElement[i] = 4 - countElement[i];
		}

		// if last index does not matching all of counter, it can not shift up
		if (countElement[0] == lastIndex[0] && countElement[1] == lastIndex[1] && countElement[2] == lastIndex[2]
				&& countElement[3] == lastIndex[3]) {
			return false;
		}

		// if it can shift, then move all of elements to top
		int[] index = { 3, 3, 3, 3 };
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (array[i][j] != 0) {
					array[i][index[i]] = array[i][j];
					index[i]--;
				}
			}
		}

		// fill all zero after last index
		for (int i = 0; i < 4; i++) {
			for (int j = index[i]; j >= 0; j--) {
				array[i][j] = 0;
			}
		}

		return true;
	}

	// |
	// v
	public boolean shiftDown() {
		int[] countElement = { 0, 0, 0, 0 };
		int[] lastIndex = { -1, -1, -1, -1 };

		// count every column has how many elements
		// got last index for every column
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j] != 0) {
					countElement[i]++;
					lastIndex[i] = j;
				}
			}
			countElement[i] = -1 + countElement[i];
		}

		// if last index does not matching all of counter, it can not shift down
		if (countElement[0] == lastIndex[0] && countElement[1] == lastIndex[1] && countElement[2] == lastIndex[2]
				&& countElement[3] == lastIndex[3]) {
			return false;
		}

		// if it can shift, then move all of elements to bottom
		int[] index = { 0, 0, 0, 0 };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j] != 0) {
					array[i][index[i]] = array[i][j];
					index[i]++;
				}
			}
		}

		// fill all zero after last index
		for (int i = 0; i < 4; i++) {
			for (int j = index[i]; j < 4; j++) {
				array[i][j] = 0;
			}
		}

		return true;
	}

	// <--
	public boolean shiftLeft() {
		int[] countElement = { 0, 0, 0, 0 };
		int[] lastIndex = { -1, -1, -1, -1 };

		// count every column has how many elements
		// got last index for every column
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[j][i] != 0) {
					countElement[i]++;
					lastIndex[i] = j;
				}
			}
			countElement[i] = -1 + countElement[i];
		}

		// if last index does not matching all of counter, it can not shift left
		if (countElement[0] == lastIndex[0] && countElement[1] == lastIndex[1] && countElement[2] == lastIndex[2]
				&& countElement[3] == lastIndex[3]) {
			return false;
		}

		// if it can shift, then move all of elements to left
		int[] index = { 0, 0, 0, 0 };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[j][i] != 0) {
					array[index[i]][i] = array[j][i];
					index[i]++;
				}
			}
		}

		// fill all zero after last index
		for (int i = 0; i < 4; i++) {
			for (int j = index[i]; j < 4; j++) {
				array[j][i] = 0;
			}
		}

		return true;
	}

	// -->
	public boolean shiftRight() {
		int[] countElement = { 0, 0, 0, 0 };
		int[] lastIndex = { 4, 4, 4, 4 };

		// count every column has how many elements
		// got last index for every column
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (array[j][i] != 0) {
					countElement[i]++;
					lastIndex[i] = j;
				}
			}
			countElement[i] = 4 - countElement[i];
		}

		// if last index does not matching all of counter, it can't shift right
		if (countElement[0] == lastIndex[0] && countElement[1] == lastIndex[1] && countElement[2] == lastIndex[2]
				&& countElement[3] == lastIndex[3]) {
			return false;
		}

		// if it can shift, then move all of elements to right
		int[] index = { 3, 3, 3, 3 };
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (array[j][i] != 0) {
					array[index[i]][i] = array[j][i];
					index[i]--;
				}
			}
		}

		// fill all zero after last index
		for (int i = 0; i < 4; i++) {
			for (int j = index[i]; j >= 0; j--) {
				array[j][i] = 0;
			}
		}

		return true;
	}

	// collapse up, down, left and right
	// =================================

	// ^
	// |
	public boolean collapseUp() {

		boolean[] isCollapse = new boolean[4];

		// get every column has same elements
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 1; j--) {
				if ((array[i][j] != 0 && array[i][j - 1] != 0) && array[i][j] == array[i][j - 1]) {
					isCollapse[i] = true;
					break;
				}
			}
		}

		// if every column has not same elements, don't do anything
		if (false == isCollapse[0] && false == isCollapse[1] && false == isCollapse[2] && false == isCollapse[3]) {
			return false;
		}

		// if some columns have same elements, merge them to top
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 1; j--) {
				if ((array[i][j] != 0 && array[i][j - 1] != 0) && array[i][j] == array[i][j - 1]) {
					array[i][j] = array[i][j] + array[i][j - 1];
					array[i][j - 1] = 0;
					for (int k = j - 1; k >= 1; k--) {
						array[i][k] = array[i][k - 1];
					}
					array[i][0] = 0;
				}
			}
		}

		return true;
	}

	// |
	// v
	public boolean collapseDown() {

		boolean[] isCollapse = new boolean[4];

		// get every column has same elements
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if ((array[i][j] != 0 && array[i][j + 1] != 0) && array[i][j] == array[i][j + 1]) {
					isCollapse[i] = true;
					break;
				}
			}
		}

		// if every column has not same elements, don't do anything
		if (false == isCollapse[0] && false == isCollapse[1] && false == isCollapse[2] && false == isCollapse[3]) {
			return false;
		}

		// if some columns have same elements, merge them to bottom
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if ((array[i][j] != 0 && array[i][j + 1] != 0) && array[i][j] == array[i][j + 1]) {
					array[i][j] = array[i][j] + array[i][j + 1];
					array[i][j + 1] = 0;
					for (int k = j + 1; k < 3; k++) {
						array[i][k] = array[i][k + 1];
					}
					array[i][3] = 0;
				}
			}
		}

		return true;
	}

	// <--
	public boolean collapseLeft() {

		boolean[] isCollapse = new boolean[4];

		// get every column has same elements
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if ((array[j][i] != 0 && array[j + 1][i] != 0) && array[j][i] == array[j + 1][i]) {
					isCollapse[i] = true;
					break;
				}
			}
		}

		// if every column has not same elements, don't do anything
		if (false == isCollapse[0] && false == isCollapse[1] && false == isCollapse[2] && false == isCollapse[3]) {
			return false;
		}

		// if some columns have same elements, merge them to left
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if ((array[j][i] != 0 && array[j + 1][i] != 0) && array[j][i] == array[j + 1][i]) {
					array[j][i] = array[j][i] + array[j + 1][i];
					array[j + 1][i] = 0;
					for (int k = j + 1; k < 3; k++) {
						array[k][i] = array[k + 1][i];
					}
					array[3][i] = 0;
				}
			}
		}

		return true;
	}

	// -->
	public boolean collapseRight() {

		boolean[] isCollapse = new boolean[4];

		// get every column has same elements
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 1; j--) {
				if ((array[j][i] != 0 && array[j - 1][i] != 0) && array[j][i] == array[j - 1][i]) {
					isCollapse[i] = true;
					break;
				}
			}
		}

		// if every column has not same elements, don't do anything
		if (false == isCollapse[0] && false == isCollapse[1] && false == isCollapse[2] && false == isCollapse[3]) {
			return false;
		}

		// if some columns have same elements, merge them to right
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 1; j--) {
				if ((array[j][i] != 0 && array[j - 1][i] != 0) && array[j][i] == array[j - 1][i]) {
					array[j][i] = array[j][i] + array[j - 1][i];
					array[j - 1][i] = 0;
					for (int k = j - 1; k >= 1; k--) {
						array[k][i] = array[k - 1][i];
					}
					array[0][i] = 0;
				}
			}
		}

		return true;
	}

}
