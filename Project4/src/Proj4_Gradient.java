/*  Section Letter: B
 *
 * CSc 127A Fall 15, Project 03
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 * The program will take a single argument: the blue component of the colors; 
 * it will then build a gradient over the green and red colors.
 * A gradient is a picture where the color changes slowly as we move from one side to the other.
 * Also, we should change the argument to change the gradient's color.
 */

public class Proj4_Gradient {

	public static void main(String[] args) {
		// The variable is blue values
		int blue = 0;

		// Judge the number of parameters
		if (args.length == 0 || args.length > 1) {
			System.out.println("ERROR: Exactly one argument must be given");
			return;
		} else {
			blue = Integer.parseInt(args[0]);
		}

		// Judge the parameter value is out of range
		if (blue > 255 || blue < 0) {
			System.out.println("ERROR: Exactly one arguments must be between 0 to 255");
			return;
		}

		// Generate canvas
		StdDraw.setScale(0, 255);
		StdDraw.clear();
		StdDraw.show(0);
		
		// createPicture function
		createPicture(blue);
		// Quickly generate picture
		StdDraw.show(0);

	}

	// The function create a gradient picture
	public static void createPicture(int blue) {
		
		for (int i = 0; i <= 255; i++) {
			for (int j = 0; j <= 255; j++) {
				
				// Set color using RGB
				StdDraw.setPenColor(i, j, blue);
				// Use small dots painted every color
				StdDraw.filledSquare(i + 1, j + 1, 1);
				
			}

		}

	}
}
