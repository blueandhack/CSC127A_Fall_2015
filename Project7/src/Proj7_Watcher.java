
/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 07
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 * The program we draw two simple eye. Each eye will look toward the mouse.
 * If you put your mouse between the eyes, the eyes will be cross-eyed.
 * If you put the mouse underneath one eye (the left one, in this case), 
 * each eye follows the mouse independently.
 * Finally, if the mouse moves inside either eye, then that eye should be right on the mouse, 
 * and the other should follow it at a distance.
 */

public class Proj7_Watcher {

	public static void main(String[] args) {

		// create canvas
		StdDraw.setScale(-100, 100);

		// mouse's coordinate
		double mouseX;
		double mouseY;

		// for left eye

		// distance to the eye on the left side
		double distanceLeft;

		// coordinate left of pupil
		double leftEyeX = 0;
		double leftEyeY = 0;

		// for right eye

		// distance to the eye on the right side
		double distanceRight;

		// coordinate right of pupil
		double rightEyeX = 0;
		double rightEyeY = 0;

		// for first run the program
		boolean move = true;

		// infinity loop
		while (true) {

			// get the coordinates of the mouse
			mouseX = StdDraw.mouseX();
			mouseY = StdDraw.mouseY();

			// if don't move mouse in the window, then keeping the pupil in the
			// center
			if (move) {
				drawEye(-40, 0, 5, -40, 0);
				drawEye(40, 0, 5, 40, 0);
				if (mouseX != 0 && mouseY != 0) {
					move = false;
				}
				continue;
			}

			// get distance for left of eye
			distanceLeft = calcDist(mouseX, mouseY, -40, 0);

			// get distance for right of eye
			distanceRight = calcDist(mouseX, mouseY, 40, 0);

			// draw left of eye
			leftEye(distanceLeft, mouseX, mouseY, leftEyeX, leftEyeY);

			// draw left of eye
			rightEye(distanceRight, mouseX, mouseY, rightEyeX, rightEyeY);
		}
	}

	// the function draws one of the eyes
	public static void drawEye(double outletX, double outletY, double r, double eyeX, double eyeY) {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledCircle(outletX, outletY, 30);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledCircle(outletX, outletY, 28);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledCircle(eyeX, eyeY, r);
		StdDraw.show(0);
	}

	// the function calculates the result of the Pythagorean theorem.
	// It returns the direct-line distance between coordinates of the mouse to .
	public static double calcDist(double mouseX, double mouseY, double originalX, double originalY) {
		double distance = Math.sqrt(Math.pow(mouseX - originalX, 2) + Math.pow(mouseY - originalY, 2));
		return distance;
	}

	// draw right of eye
	public static void rightEye(double distanceRight, double mouseX, double mouseY, double rightEyeX,
			double rightEyeY) {
		// for right
		// if the mouse is inside the orbit
		if (distanceRight < 23 && mouseX != 0 && mouseY != 0) {
			drawEye(40, 0, 5, mouseX, mouseY);
		} else {
			// when mouseX > 40, 0 < mouseX < 40, mouseX < 0, mouseX = 40 and
			// mouseY = 0
			if (mouseY == 0) {
				if (mouseX < 17) {
					drawEye(40, 0, 5, 17, 0);
				} else if (mouseX > 63) {
					drawEye(40, 0, 5, 63, 0);
				} else if (mouseX == 40) {
					drawEye(40, 0, 5, 40, 0);
				}
			} else if (mouseX > 40) {
				rightEyeX = (23 / distanceRight) * (Math.abs(mouseX) - 40) + 40;

				if (mouseY > 0) {
					rightEyeY = (23 / distanceRight) * (Math.abs(mouseY));
					drawEye(40, 0, 5, rightEyeX, rightEyeY);
				} else if (mouseY < 0) {
					rightEyeY = -(23 / distanceRight) * (Math.abs(mouseY));
					drawEye(40, 0, 5, rightEyeX, rightEyeY);
				}
			} else if (mouseX < 40) {
				if (mouseX > 0) {
					rightEyeX = 40 - (23 / distanceRight) * (40 - Math.abs(mouseX));
					if (mouseY > 0) {
						rightEyeY = (23 / distanceRight) * (Math.abs(mouseY));
						drawEye(40, 0, 5, rightEyeX, rightEyeY);
					} else if (mouseY < 0) {
						rightEyeY = -(23 / distanceRight) * (Math.abs(mouseY));
						drawEye(40, 0, 5, rightEyeX, rightEyeY);
					}
				} else if (mouseX <= 0) {
					rightEyeX = 40 - (23 / distanceRight) * (Math.abs(mouseX) + 40);
					if (mouseY > 0) {
						rightEyeY = (23 / distanceRight) * (Math.abs(mouseY));
						drawEye(40, 0, 5, rightEyeX, rightEyeY);
					} else if (mouseY < 0) {
						rightEyeY = -(23 / distanceRight) * (Math.abs(mouseY));
						drawEye(40, 0, 5, rightEyeX, rightEyeY);
					}
				}
			} else if (mouseX == 40) {
				if (mouseY > 0) {
					drawEye(40, 0, 5, 40, 23);
				} else if (mouseY < 0) {
					drawEye(40, 0, 5, 40, -23);
				}
			}

		}
	}

	// draw left of eye
	public static void leftEye(double distanceLeft, double mouseX, double mouseY, double leftEyeX, double leftEyeY) {
		// for left
		// if the mouse is inside the orbit
		if (distanceLeft < 23 && mouseX != 0 && mouseY != 0) {
			drawEye(-40, 0, 5, mouseX, mouseY);
		} else {
			// when mouseX < -40, -40 < mouseX < 0, mouseX > 0, mouseX = 40 and
			// mouseY = 0
			if (mouseY == 0) {
				if (mouseX > -17) {
					drawEye(-40, 0, 5, -17, 0);
				} else if (mouseX < -63) {
					drawEye(-40, 0, 5, -63, 0);
				} else if (mouseX == -40) {
					drawEye(-40, 0, 5, -40, 0);
				}
			} else if (mouseX < -40) {
				leftEyeX = -(23 / distanceLeft) * (Math.abs(mouseX) - 40) - 40;

				if (mouseY > 0) {
					leftEyeY = (23 / distanceLeft) * (Math.abs(mouseY));
					drawEye(-40, 0, 5, leftEyeX, leftEyeY);
				} else if (mouseY < 0) {
					leftEyeY = -(23 / distanceLeft) * (Math.abs(mouseY));
					drawEye(-40, 0, 5, leftEyeX, leftEyeY);
				}
			} else if (mouseX > -40) {
				if (mouseX < 0) {
					leftEyeX = (23 / distanceLeft) * (40 - Math.abs(mouseX)) - 40;
					if (mouseY > 0) {
						leftEyeY = (23 / distanceLeft) * (Math.abs(mouseY));
						drawEye(-40, 0, 5, leftEyeX, leftEyeY);
					} else if (mouseY < 0) {
						leftEyeY = -(23 / distanceLeft) * (Math.abs(mouseY));
						drawEye(-40, 0, 5, leftEyeX, leftEyeY);
					}
				} else if (mouseX >= 0) {
					leftEyeX = (23 / distanceLeft) * (40 + Math.abs(mouseX)) - 40;
					if (mouseY > 0) {
						leftEyeY = (23 / distanceLeft) * (Math.abs(mouseY));
						drawEye(-40, 0, 5, leftEyeX, leftEyeY);
					} else if (mouseY < 0) {
						leftEyeY = -(23 / distanceLeft) * (Math.abs(mouseY));
						drawEye(-40, 0, 5, leftEyeX, leftEyeY);
					}
				}
			} else if (mouseX == -40) {
				if (mouseY > 0) {
					drawEye(-40, 0, 5, -40, 23);
				} else if (mouseY < 0) {
					drawEye(-40, 0, 5, -40, -23);
				}
			}
		}
	}

}
