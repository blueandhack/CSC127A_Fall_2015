import java.awt.Color;

public class VectorCaptain {

	public static void main(String[] args) {

		StdDraw.setScale(-5,5);
		StdDraw.clear();
		
	    Vector pos0 = new Vector();
	    Vector vel0 = new Vector();
	    Vector grav = new Vector();
	    
	    pos0.x = 0;
	    pos0.y = 0;
	    
	    vel0.x = 1;
	    vel0.y = 5;
	    
	    grav.x = 0;
	    grav.y = -1;
	    
	    
	    Vector pos1 = new Vector();
	    Vector pos2 = new Vector();
	    Vector vel1 = new Vector();
	    Vector vel2 = new Vector();
	    
		pos1 = vectorAdd(pos0, vel0);
		vel1 = vectorAdd(vel0, grav);
		
		pos2 = vectorAdd(pos1, vel1);
		vel2 = vectorAdd(vel1, grav);
		
		drawVector(pos0.x, pos0.y, vel0, StdDraw.BLACK);
		drawVector(pos1.x, pos1.y, vel1, StdDraw.RED);
		drawVector(pos2.x, pos2.y, vel2, StdDraw.BLUE);

	    
	    
	}

	public static Vector vectorAdd(Vector a, Vector b) {
		// this creates a new Vector object. Why do we have to
		// do this? I'll explain it later in the semester.
		Vector retval = new Vector();

		/*
		 * TODO: fill in the x and y values of retval.
		 * 
		 * To add two vectors, you simply add their respective values: the two
		 * x's add up, and the two y's.
		 */

		retval.x = a.x + b.x;
		retval.y = a.y + b.y;

		// this returns the Vector object that we created
		return retval;
	}

	public static void drawVector(double xStart, double yStart, Vector vec, Color color) {
		/*
		 * TODO: draw the vector (with its arrowhead). Pass the color to
		 * StdDraw.setPenColor(). Then draw the line and the arrowhead, just
		 * like you did with the snake. The difference is that now, you are just
		 * drawing one vector, not several.
		 */
		StdDraw.setPenColor(color);
		StdDraw.line(xStart, yStart, vec.x, vec.y);
	}

}
