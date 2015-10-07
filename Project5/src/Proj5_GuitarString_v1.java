import java.util.Random;

public class Proj5_GuitarString_v1 {

	public static void main(String[] args) {

		double[] h = new double[101];
		Random rand = new Random();
		int i = 0;
		for (i = 1; i < h.length - 1; i++) {
			h[i] = -50 + rand.nextDouble() * (50 - (-50));
		}

		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(-80, 80);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0, -80, 0, 80);
		StdDraw.line(100, -80, 100, 80);
		StdDraw.line(0, -80, 100, -80);
		StdDraw.line(0, 80, 100, 80);

		drawString(h);

	}

	public static void drawString(double[] h) {

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0, 0, 100, 0);

		int i = 0;
		for (i = 0; i < 100; i++) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(i, h[i], i + 1, h[i + 1]);
			System.out.println("h[" + i + "]=" + h[i]);
		}
		StdDraw.show(0);

	}

}
