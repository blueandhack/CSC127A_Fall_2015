
import java.util.Random;

public class Proj11Board {

	private int array[][];

	public int[][] getArray() {
		return array;
	}

	public void setArray(int[][] array) {
		this.array = array;
	}

	public Proj11Board() {
		super();
		this.array = new int[4][4];
	}

	public void draw() {
		StdDraw.clear();
		StdDraw.setScale(0, 4);
		StdDraw.show(0);
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
		int x = rand.nextInt(4);
		int y = rand.nextInt(4);
		int a = rand.nextInt(100);

		if (sumZero == 0) {
			return;
		}

		if (sumZero == 1) {
			if (a < 20) {
				array[oneX][oneY] = 4;
			} else {
				array[oneX][oneY] = 2;
			}
			return;
		}

		// System.out.println("" + x + y);
		while (true) {
			// System.out.println("" + x + y);
			if (array[x][y] == 0) {
				if (a < 20) {
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

		// for (int i = 0; i < 4; i++) {
		// for (int j = 0; j < 4; j++) {
		// System.out.print(array[i][j]);
		// }
		// System.out.println();
		// }

	}

	// ^
	// |
	public boolean shiftUp() {
		int[] countElement = { 0, 0, 0, 0 };
		int[] lastIndex = { 4, 4, 4, 4 };
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (array[i][j] != 0) {
					countElement[i]++;
					lastIndex[i] = j;
				}
			}
			countElement[i] = 4 - countElement[i];
		}

		if (countElement[0] == lastIndex[0] && countElement[1] == lastIndex[1] && countElement[2] == lastIndex[2]
				&& countElement[3] == lastIndex[3]) {
			return false;
		}

		int[] index = { 3, 3, 3, 3 };
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (array[i][j] != 0) {
					array[i][index[i]] = array[i][j];
					index[i]--;
				}
			}
		}

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
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j] != 0) {
					countElement[i]++;
					lastIndex[i] = j;
				}
			}
			countElement[i] = -1 + countElement[i];
		}

		if (countElement[0] == lastIndex[0] && countElement[1] == lastIndex[1] && countElement[2] == lastIndex[2]
				&& countElement[3] == lastIndex[3]) {
			return false;
		}

		int[] index = { 0, 0, 0, 0 };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j] != 0) {
					array[i][index[i]] = array[i][j];
					index[i]++;
				}
			}
		}

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
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[j][i] != 0) {
					countElement[i]++;
					lastIndex[i] = j;
				}
			}
			countElement[i] = -1 + countElement[i];
		}

		if (countElement[0] == lastIndex[0] && countElement[1] == lastIndex[1] && countElement[2] == lastIndex[2]
				&& countElement[3] == lastIndex[3]) {
			return false;
		}

		int[] index = { 0, 0, 0, 0 };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[j][i] != 0) {
					array[index[i]][i] = array[j][i];
					index[i]++;
				}
			}
		}

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
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (array[j][i] != 0) {
					countElement[i]++;
					lastIndex[i] = j;
				}
			}
			countElement[i] = 4 - countElement[i];
		}

		if (countElement[0] == lastIndex[0] && countElement[1] == lastIndex[1] && countElement[2] == lastIndex[2]
				&& countElement[3] == lastIndex[3]) {
			return false;
		}

		int[] index = { 3, 3, 3, 3 };
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (array[j][i] != 0) {
					array[index[i]][i] = array[j][i];
					index[i]--;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = index[i]; j >= 0; j--) {
				array[j][i] = 0;
			}
		}

		return true;
	}

	// ^
	// |
	public boolean collapseUp() {

		boolean[] isCollapse = new boolean[4];
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 1; j--) {
				if ((array[i][j] != 0 && array[i][j - 1] != 0) && array[i][j] == array[i][j - 1]) {
					isCollapse[i] = true;
					continue;
				}
			}
		}

		if (false == isCollapse[0] && false == isCollapse[1] && false == isCollapse[2] && false == isCollapse[3]) {
			return false;
		}

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
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if ((array[i][j] != 0 && array[i][j + 1] != 0) && array[i][j] == array[i][j + 1]) {
					isCollapse[i] = true;
					continue;
				}
			}
		}

		if (false == isCollapse[0] && false == isCollapse[1] && false == isCollapse[2] && false == isCollapse[3]) {
			return false;
		}

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
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if ((array[j][i] != 0 && array[j + 1][i] != 0) && array[j][i] == array[j + 1][i]) {
					isCollapse[i] = true;
					continue;
				}
			}
		}

		if (false == isCollapse[0] && false == isCollapse[1] && false == isCollapse[2] && false == isCollapse[3]) {
			return false;
		}

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
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 1; j--) {
				if ((array[j][i] != 0 && array[j - 1][i] != 0) && array[j][i] == array[j - 1][i]) {
					isCollapse[i] = true;
					continue;
				}
			}
		}

		if (false == isCollapse[0] && false == isCollapse[1] && false == isCollapse[2] && false == isCollapse[3]) {
			return false;
		}

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
