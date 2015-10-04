import java.util.Random;

public class WhiteNoise {

	public static void main(String[] args) {

		Random rand = new Random();
		
		StdDraw.setScale(0, 100);
		StdDraw.clear();
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			StdDraw.filledSquare(rand.nextInt(101), rand.nextInt(101), 0.5);
			StdDraw.show(0);
		}
	}

}
