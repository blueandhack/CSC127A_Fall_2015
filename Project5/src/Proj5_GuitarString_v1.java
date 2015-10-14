
/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 05
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 *
 * The program draw a picture about some random lines, but those lines are continuous.
 * Those lines like irregular fold line.
 */

import java.util.Random;

public class Proj5_GuitarString_v1 {

	public static void main(String[] args) {

		// set height of arrays
		double[] h = new double[101];
		Random rand = new Random();

		// fill an array
		for (int i = 1; i < h.length - 1; i++) {
			h[i] = rand.nextInt(101) - 50;
			// h[i] = -50 + rand.nextDouble() * (50 - (-50));
		}

		// create canvas
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(-80, 80);

		// draw border
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0, -80, 0, 80);
		StdDraw.line(100, -80, 100, 80);
		StdDraw.line(0, -80, 100, -80);
		StdDraw.line(0, 80, 100, 80);

		// using drawString to draw pictures
		drawString(h);

	}

	public static void drawString(double[] h) {
		// draw x-axis
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0, 0, 100, 0);

		// draw lines
		for (int i = 0; i < 100; i++) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(i, h[i], i + 1, h[i + 1]);
		}
		StdDraw.show(0);

	}

}