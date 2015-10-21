
/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 06
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 *
 * The program read user's input after the string splits two words. 
 * The first word is color, and the second word is a graph. 
 * Using two words to create a graph, such as, user input "red circle", 
 * the string as a command to control computer to draw a red of circle.
 */
import java.util.Scanner;

public class Proj6_InteractiveDraw {

	public static void main(String[] args) {
		// create a Scanner object
		Scanner in = new Scanner(System.in);
		// create a canvas
		StdDraw.setScale(-200, 200);
		// set background is yellow
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledSquare(0, 0, 300);

		// infinity loop
		while (in.hasNext()) {
			// store user's input
			String stringLine = in.nextLine();
			// output error when the string does not have a space
			if (stringLine.indexOf(" ") == -1) {
				System.out.println("ERROR! You must include a space.");
				continue;
			}
			// get space's index in string
			int spaceIndex = stringLine.indexOf(" ");
			// output first word and second word
			System.out.println(stringLine.substring(0, spaceIndex));
			System.out.println(stringLine.substring(spaceIndex + 1));

			// store first word and second word
			String color = stringLine.substring(0, spaceIndex);
			String shape = stringLine.substring(spaceIndex + 1);

			// judge color
			if (color.equals("red")) {
				StdDraw.setPenColor(StdDraw.RED);
				drawShap(shape);
			} else if (color.equals("green")) {
				StdDraw.setPenColor(StdDraw.GREEN);
				drawShap(shape);
			} else if (color.equals("blue")) {
				StdDraw.setPenColor(StdDraw.BLUE);
				drawShap(shape);
			} else if (color.equals("white")) {
				StdDraw.setPenColor(StdDraw.WHITE);
				drawShap(shape);
			} else if (color.equals("black")) {
				StdDraw.setPenColor(StdDraw.BLACK);
				drawShap(shape);
			} else {
				// print error when the color is not exist
				System.out.println("ERROR! We can not find the " + color);
			}

		}

		in.close();
	}

	// the function judge the shape
	public static void drawShap(String shape) {
		if (shape.equals("circle")) {
			StdDraw.circle(0, 0, 50);
		} else if (shape.equals("square")) {
			StdDraw.square(0, 0, 120);
		} else if (shape.equals("rectangle")) {
			StdDraw.rectangle(0, 0, 80, 60);
		} else {
			// print error when the shape is not exist
			System.out.println("ERROR! We can not draw the " + shape + " shap");
		}
	}

}
