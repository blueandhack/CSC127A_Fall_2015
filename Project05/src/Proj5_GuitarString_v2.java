
/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 05
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 *
 * The program draw a lot of pictures about some random lines,
 * but these images become a continuous animation.
 * Those lines like guitar string. Waves will bounce up and down, 
 * and gradually settle down to zero.
 */

import java.util.Random;

public class Proj5_GuitarString_v2 {

	public static void main(String[] args) {

		// create canvas
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(-80, 80);

		Random rand = new Random();

		// set height and velocity of arrays
		double[] h = new double[101];
		double[] v = new double[101];

		// fill an array
		for (int i = 1; i < h.length - 1; i++) {
			h[i] = rand.nextInt(101) - 50;
			// h[i] = -50 + rand.nextDouble() * (50 - (-50));
		}

		// draw x line
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0, 0, 100, 0);

		// using drawString to draw pictures
		drawString(h, v);

	}

	public static void drawString(double h[], double v[]) {

		// infinite loop
		while (true) {

			StdDraw.clear();
			// draw border
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(0, -80, 0, 80);
			StdDraw.line(100, -80, 100, 80);
			StdDraw.line(0, -80, 100, -80);
			StdDraw.line(0, 80, 100, 80);

			// draw x-axis
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(0, 0, 100, 0);

			// draw lines
			for (int i = 0; i < 100; i++) {
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.line(i, h[i], i + 1, h[i + 1]);
			}

			StdDraw.show(0);

			// compute v & h
			for (int i = 1; i < 100; i++) {
				v[i] = v[i] + 0.01 * (h[i - 1] + h[i + 1] - 2.0 * h[i]);
			}
			for (int i = 1; i < 100; i++) {
				h[i] = 0.999 * h[i] + v[i];
			}

		}

	}

}
