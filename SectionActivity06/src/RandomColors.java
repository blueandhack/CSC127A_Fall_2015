import java.util.Random;

public class RandomColors {

	public static void main(String[] args) {

		Random rand = new Random();

		StdDraw.setScale(0, 100);
		StdDraw.clear();
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				StdDraw.setPenColor(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
				StdDraw.filledSquare(i, j, 0.5);
				StdDraw.show(0);
			}
		}

	}

}
