import java.util.Random;

public class Ant {

	public static void main(String[] args) {
		// create canvas
		StdDraw.setScale(0, 50);

		// mouse's coordinate
		double mouseX = 0;
		double mouseY = 0;
		int antX = 25;
		int antY = 25;

		int[][] array = new int[50][50];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = 0;
			}
		}

		int tempX = 0;

		int tempY = 0;

		while (true) {
			mouseX = StdDraw.mouseX();
			mouseY = StdDraw.mouseY();

			tempX = antX;
			tempY = antY;

			antX = moveAnt(array[antX][antY], antX, (int) mouseX);
			antY = moveAnt(array[tempX][antY], antY, (int) mouseY);
			changeGridState(array, tempX, tempY);

			if (StdDraw.mousePressed()) {
				if ((mouseX < 50 && mouseX >= 0) && (mouseY < 50 && mouseY >= 0)) {
					array[(int) StdDraw.mouseX()][(int) StdDraw.mouseY()] = 3;
				}
			}

			drawAnt(antX, antY);
			drawBoard(array);

			if (antX == 49) {
				antX = 2;
			}
			if (antX == 0) {
				antX = 48;
			}
			if (antY == 49) {
				antY = 2;
			}
			if (antY == 0) {
				antY = 48;
			}
		}

	}

	public static int moveAnt(int gridState, int antCoord, int mouseCoord) {
		Random rand = new Random();
		if (gridState == 0) {
			if (antCoord < mouseCoord) {
				antCoord++;
				return antCoord;
			} else if (antCoord > mouseCoord) {
				antCoord--;
				return antCoord;
			} else {
				return antCoord;

			}
		}
		if (gridState == 1) { // is blue
			if (antCoord < mouseCoord) {
				antCoord--;
				return antCoord;
			} else if (antCoord > mouseCoord) {
				antCoord++;
				return antCoord;
			} else {
				return antCoord;
			}

		}
		if (gridState == 2) { // is green
			int check = rand.nextInt(2);
			if (check == 0) {
				antCoord--;
			} else {
				antCoord++;
			}
			return antCoord;
		}
		if (gridState == 3) {
			return antCoord;
		}
		return antCoord;
	}

	public static void changeGridState(int[][] grid, int x, int y) {
		if (grid[x][y] == 0) {
			grid[x][y] = 1;
		} else if (grid[x][y] == 1) {
			grid[x][y] = 2;
		} else if (grid[x][y] == 2) {
			grid[x][y] = 0;
		} else if (grid[x][y] == 3) {
			grid[x][y] = 0;
		}
	}

	public static void drawBoard(int[][] grid) {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				if (grid[i][j] == 0) {
					StdDraw.setPenColor(StdDraw.WHITE);
				} else if (grid[i][j] == 1) {
					StdDraw.setPenColor(StdDraw.BLUE);
				} else if (grid[i][j] == 2) {
					StdDraw.setPenColor(StdDraw.GREEN);
				} else if (grid[i][j] == 3) {
					StdDraw.setPenColor(StdDraw.RED);
				}
				StdDraw.filledSquare(i, j, 0.5);

			}
			StdDraw.show(0);
		}
		StdDraw.show(0);

	}

	public static void drawAnt(int x, int y) {
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledSquare(x, y, 0.5);
	}

}
