public class RunningMan {
	public static void drawStickFigure(double xPos, double yPos) {
		// this little marker exists to show you where the man *ought*
		// to be. If you make this method work correctly, it should
		// be above, and a little to the left, of his head as he moves
		// around.
		//
		// If you want to remove this marker, you're allowed to, but
		// you can also keep it if you'd like; it's just there to help
		// you.
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(xPos, yPos + 40, 1);

		// this draw the stick figure itself. Note that this always
		// draws the figure at the same location - you have to change
		// these calls so that he moves around.
//		StdDraw.setPenColor(StdDraw.BLACK);
//		StdDraw.circle(10 + xPos, 30 + yPos, 4);
//		StdDraw.line(10 + xPos, 26 + yPos, 10 + xPos, 12 + yPos);
//		StdDraw.line(10 + xPos, 12 + yPos, 7 + xPos, 1 + yPos);
//		StdDraw.line(10 + xPos, 12 + yPos, 13 + xPos, 1 + yPos);
//		StdDraw.line(7 + xPos, 1 + yPos, 5 + xPos, 1 + yPos);
//		StdDraw.line(13 + xPos, 1 + yPos, 15 + xPos, 1 + yPos);
//		StdDraw.line(10 + xPos, 25 + yPos, 5 + xPos, 15 + yPos);
//		StdDraw.line(10 + xPos, 25 + yPos, 15 + xPos, 15 + yPos);
		
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle(xPos, 30 + yPos, 4);
		StdDraw.line(xPos, 26 + yPos, xPos, 12 + yPos);
		StdDraw.line(xPos, 12 + yPos, -3 + xPos, 1 + yPos);
		StdDraw.line(xPos, 12 + yPos, 3 + xPos, 1 + yPos);
		StdDraw.line(-3 + xPos, 1 + yPos, -5 + xPos, 1 + yPos);
		StdDraw.line(3 + xPos, 1 + yPos, 5 + xPos, 1 + yPos);
		StdDraw.line(xPos, 25 + yPos, -5 + xPos, 15 + yPos);
		StdDraw.line(xPos, 25 + yPos, 5 + xPos, 15 + yPos);
		
		
//        StdDraw.setPenColor(StdDraw.RED);
//        StdDraw.circle(10,30, 4);
//        StdDraw.line  (10,26, 10,12);
//        StdDraw.line  (10,12,  7,1);
//        StdDraw.line  (10,12, 13,1);
//        StdDraw.line  ( 7,1,   5,1);
//        StdDraw.line  (13,1,  15,1);
//        StdDraw.line  (10,25,  5,15);
//        StdDraw.line  (10,25, 15,15);
		
	}

	public static void main(String[] args) {
		StdDraw.setScale(0, 200);

		double xPos = 0;
		double yPos = 0;
		double xVel = 1;
		double yVel = 0;

		while (xPos < 185) {
			StdDraw.clear();

			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledSquare(50, 7, 7);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(100, 0, 200, 50);

			drawStickFigure(xPos, yPos);

			StdDraw.show(20);

			xPos += xVel;
			yPos += yVel;

			if (yPos > 0)
				yVel -= .5;

			if (yPos < 0) {
				yPos = 0;
				yVel = 0;
			}

			if (xPos >= 50 - 7 - (10 + 5) && xPos <= 50 + 7 + (10 - 5) && yPos < 14) {
				yPos = 14;
				yVel = 0;
			}

			if (xPos > 100 - (10 + 5) && yPos < (xPos - 100 + 10 + 5) * .5) {
				yPos = (xPos - 100 + 10 + 5) * .5;
				yVel = 0;
			}

			if (xPos > 20 && xPos < 25 && yVel == 0)
				yVel = 5;
		}
	}
}
