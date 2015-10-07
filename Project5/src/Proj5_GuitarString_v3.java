import java.util.Random;

public class Proj5_GuitarString_v3 {

	public static void main(String[] args) {

		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(-80, 80);
		Random rand = new Random();

		double[] h = new double[101];
		double[] v = new double[101];
		double[] h1 = new double[101];
		int i = 0;
		for (i = 1; i < h.length - 1; i++) {
			h[i] = -50 + rand.nextDouble() * (50 - (-50));
		}

		// draw x line
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0, 0, 100, 0);

		// draw first graph
		for (i = 0; i < 100; i++) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(i, h[i], i + 1, h[i + 1]);
			System.out.println("h[" + i + "]=" + h[i]);
		}
		StdDraw.show(0);

		// run infinite loop
		drawString(h1, h, v);
	}

	public static void drawString(double h1[], double h[], double v[]) {

		// infinite loop
		while (true) {

			if (StdDraw.mousePressed()) {
				int mouseX = (int) (StdDraw.mouseX());
				h[mouseX] = StdDraw.mouseY();
			}

			for (int j = 0; j < h1.length; j++) {
				h1[j] = h[j];
			}

			// compute v & h
			for (int i = 1; i < 100; i++) {
				v[i] = v[i] + 0.01 * (h1[i - 1] + h[i + 1] - 2.0 * h[i]);
				h[i] = 0.999 * h[i] + v[i];
			}

			StdDraw.clear();

			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(0, 0, 100, 0);

			for (int i = 0; i < 100; i++) {
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.line(i, h[i], i + 1, h[i + 1]);
				System.out.println("h[" + i + "]=" + h[i] + " v[" + i + "]=" + v[i]);
			}

			StdDraw.show(0);

		}

	}

}
