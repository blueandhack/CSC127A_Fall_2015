/* VectorDraw
 *
 * CSc 127A Fall 15 - Section Activity 4
 *
 * Author: Russell Lewis and TODO: your 2 names here
 *
 * This class is used to explore the use of the Vector class.  We will draw
 * "snakes" of vectors, where you have three vectors, head-to-tail.
 */
public class VectorDraw
{
	public static void drawVectorSnake(Vector first,
	                                   Vector second,
	                                   Vector third)
	{
/*
		TODO: draw the three vectors, chained together, head to
		      tail.  The start of 'first' should be at (0,0);
		      the start of 'second' should be at the end of 'first';
		      the start of 'third' should be at the end of 'second'.

		      The 'first' should be colored StdDraw.RED
		      The 'second' should be colored StdDraw.GREEN
		      The 'third' should be colored StdDraw.BLUE

		      --

		      Each Vector should be drawn as a single line
		      (StdDraw.line()) with a small circle at the end
		      (StdDraw.filledCircle()).

		      More advanced students may may replace the circle with
		      an arrowhead - but warned that getting the arrowhead
		      to line up with the right orientation, while definitely
		      possible, takes some non-trivial math.
 */
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(0, 0, first.x, first.y);
//		System.out.println(first.x);
		StdDraw.circle(first.x, first.y, 1);
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.line(first.x, first.y, second.x, second.y);
		StdDraw.circle(second.x, second.y, 1);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.line(second.x, second.y, third.x, third.y);
		StdDraw.circle(third.x, third.y, 1);
		
		
	}


	public static void main(String[] args)
	{
		/* ---- BASE CODE ----
		 *
		 * You are welcome to modify this code if you are feeling
		 * ambitious, but it should not be necessary.
		 */

		// we use a range of -100 to 100 in both axes.  We clear
		// the screen with white.
		StdDraw.setScale(-100,100);
		StdDraw.clear();

		// this creates three new Vector objects.
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		Vector v3 = new Vector();

		// this sets the x and y fields of all three objects.
		v1.x = 10;
		v1.y = 10;
		v2.x = 30;
		v2.y = 0;
		v3.x = 0;
		v3.y = -10;

		// this draws the same three vectors in two different orders.
		// if the Snake() method is implemented correctly, then the
		// two snakes should start and end at the same points, but
		// follow different paths to get there.
		drawVectorSnake(v1,v2,v3);
		drawVectorSnake(v3,v2,v1);


		/* ---- SPACE FOR MODIFICATION ----
		 *
		 * I create three more Vector objects here.  You will be
		 * expected to set the x and y values of all three - and then
		 * to call the Snake() method at least once.
		 */

		// I creaate the objects for you
		Vector v4 = new Vector();
		Vector v5 = new Vector();
		Vector v6 = new Vector();

		// you should give them values here
		v4.x = 30;
		v4.y = 30;
		v5.x = 50;
		v5.y = 0;
		v6.x = 0;
		v6.y = -80;
		
		
		// you should call the Snake() method here
		drawVectorSnake(v4, v5, v6);
		drawVectorSnake(v6, v5, v4);
		
	}
}

