import java.awt.Color;

/* VectorMath
 *
 * CSc 127A Fall 15 - Section Activity 4
 *
 * Author: Russell Lewis and TODO: your 2 names here
 *
 * This class has methods which do Vector arithmetic.
 */
public class VectorMath
{
	public static Vector vectorAdd(Vector a, Vector b)
	{
		// this creates a new Vector object.  Why do we have to
		// do this?  I'll explain it later in the semester.
		Vector retval = new Vector();

/*
		TODO: fill in the x and y values of retval.

		      To add two vectors, you simply add their respective
		      values: the two x's add up, and the two y's.
 */
		
		retval.x = a.x + b.x;
		retval.y = a.y + b.y;
		

		// this returns the Vector object that we created
		return retval;
	}

	public static Vector vectorMul(Vector vec, double factor)
	{
		Vector retval = new Vector();

/*
		TODO: fill in the x and y values of retval.

		      when you multiply a Vector by a simple number (known as
		      a 'scalar', you multiply both the x and y values by the
		      number.
 */
		retval.x = vec.x * factor;
		retval.y = vec.y * factor;

		return retval;
	}

	public static void drawVector(double xStart, double yStart,
	                              Vector vec,
	                              Color color)
	{
/*
		TODO: draw the vector (with its arrowhead).  Pass the color
		      to StdDraw.setPenColor().  Then draw the line and the
		      arrowhead, just like you did with the snake.  The
		      difference is that now, you are just drawing one
		      vector, not several.
 */
		StdDraw.setPenColor(color);
		StdDraw.line(xStart, yStart, vec.x, vec.y);
	}


	/* YOU DON"T HAVE TO CHANGE THIS METHOD */
	public static void drawVectorSnake(Vector first,
	                                   Vector second,
	                                   Vector third)
	{
		Vector firstTwo = vectorAdd(first, second);

		drawVector(0,0,                   first,  StdDraw.RED);
		drawVector(first   .x,first   .y, second, StdDraw.GREEN);
		drawVector(firstTwo.x,firstTwo.y, third,  StdDraw.BLUE);
	}


	public static void main(String[] args)
	{
		StdDraw.setScale(-100,100);
		StdDraw.clear();

		Vector v1 = new Vector();
		Vector v2 = new Vector();
		Vector v3 = new Vector();

		v1.x = 10;
		v1.y = 10;
		v2.x = 30;
		v2.y = 0;
		v3.x = 0;
		v3.y = -10;

		Vector v1_dbl = vectorMul(v1, -2);
		Vector v2_dbl = vectorMul(v2, -2);
		Vector v3_dbl = vectorMul(v3, -2);

		drawVectorSnake(v1,    v2,    v3);
		drawVectorSnake(v1_dbl,v2_dbl,v3_dbl);
	}
}

