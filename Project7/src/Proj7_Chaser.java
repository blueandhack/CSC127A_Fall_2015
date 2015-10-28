
/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 07
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 * The program draws a little circle, which will chase your mouse all over the screen.
 * And the circle random changing color. When press mouse then clean the screen.
 */

import java.util.Random;

public class Proj7_Chaser {

	public static void main(String[] args) {

		// create canvas
		StdDraw.setScale(-200, 200);

		// set the center coordinates
		double circleX = 0, circleY = 0;

		// set the mouse coordinates
		double mouseX = 0, mouseY = 0;

		// create random object
		Random rand = new Random();

		// infinity loop
		while (true) {
			// when press mouse clean the screen
			if (StdDraw.mousePressed()) {
				StdDraw.clear();
				// circleX = 0;
				// circleY = 0;
			}

			// get the mouse
			mouseX = StdDraw.mouseX();
			mouseY = StdDraw.mouseY();

			// red, green, blue
			int r = rand.nextInt(256);
			int g = rand.nextInt(256);
			int b = rand.nextInt(256);

			// set pen color
			StdDraw.setPenColor(r, g, b);

			// movement within limits
			if ((mouseX < 200 && mouseX > -200) && (mouseY < 200 && mouseY > -200)) {

				// judge the direction of movement
				if (mouseX > circleX) {
					circleX++;
				} else if (mouseX < circleX) {
					circleX--;
				}

				// judge the direction of movement
				if (mouseY > circleY) {
					circleY++;
				} else if (mouseY < circleY) {
					circleY--;
				}
			}

			// draw a circle
			StdDraw.filledCircle(circleX, circleY, 20);
			// delayed display
			StdDraw.show(1);

		}

	}

}
