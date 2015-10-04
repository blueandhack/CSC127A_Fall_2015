import java.util.Random;

public class RandomWalk {

	public static void main(String[] args) {

		Random rand = new Random();

		StdDraw.setScale(-100, 100);
		// int i = 1;
		// int j = 1;
		int step = 0;

		int x = 0;
		int y = 0;
		// int x1 = 0;
		// int y1 = 0;

		while (true) {

			step++;
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(-80, 90, 30, 15);
			StdDraw.show(0);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(-80, 90, "Steps: " + step);

			StdDraw.show(0);
			StdDraw.filledSquare(x, y, 0.5);

			x = x + rand.nextInt(3) - 1;
			y = y + rand.nextInt(3) - 1;

			// i++;
			// j += 2;
			// x1 = x;
			// y1 = y;

			// while (true) {

			// x = rand.nextInt(j) - i;
			// y = rand.nextInt(j) - i;
			// if (x == x1) {
			// if ((y - 1) == y1 || (y + 1) == y1) {
			// if (Math.abs(x) > Math.abs(y)) {
			// if (Math.abs(x) > 100) {
			// i = 100;
			// j = 1 + i * 2;
			// }
			// i = Math.abs(x);
			// j = 1 + i * 2;
			// } else {
			// if (Math.abs(x) > 100) {
			// i = 100;
			// j = 1 + i * 2;
			// }
			// i = Math.abs(y);
			// j = 1 + i * 2;
			// }
			// break;
			// }
			// } else if (y == y1) {
			// if ((x - 1) == x1 || (x + 1) == x1) {
			// if (Math.abs(x) > Math.abs(y)) {
			// if (Math.abs(x) > 100) {
			// i = 100;
			// j = 1 + i * 2;
			// }
			// i = Math.abs(x);
			// j = 1 + i * 2;
			// } else {
			// if (Math.abs(x) > 100) {
			// i = 100;
			// j = 1 + i * 2;
			// }
			// i = Math.abs(y);
			// j = 1 + i * 2;
			// }
			// break;
			// }
			// } else if ((x + 1) == x1) {
			// if ((y + 1) == y1 || (y - 1) == y1) {
			// if (Math.abs(x) > Math.abs(y)) {
			// if (Math.abs(x) > 100) {
			// i = 100;
			// j = 1 + i * 2;
			// }
			// i = Math.abs(x);
			// j = 1 + i * 2;
			// } else {
			// if (Math.abs(x) > 100) {
			// i = 100;
			// j = 1 + i * 2;
			// }
			// i = Math.abs(y);
			// j = 1 + i * 2;
			// }
			// break;
			// }
			// } else if ((x - 1) == x1) {
			// if ((y + 1) == y1 || (y - 1) == y1) {
			// if (Math.abs(x) > Math.abs(y)) {
			// if (Math.abs(x) > 100) {
			// i = 100;
			// j = 1 + i * 2;
			// }
			// i = Math.abs(x);
			// j = 1 + i * 2;
			// } else {
			// if (Math.abs(x) > 100) {
			// i = 100;
			// j = 1 + i * 2;
			// }
			// i = Math.abs(y);
			// j = 1 + i * 2;
			// }
			// break;
			// }
			// }
			// }

		}

	}

}
