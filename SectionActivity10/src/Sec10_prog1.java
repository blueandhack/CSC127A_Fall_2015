import java.awt.Color;

/* Sec10_Prog1
 *
 * CSc 127A Fall 15, Section Activity 10
 *
 * Author:  Russell Lewis
 * SL Name: n/a
 *
 * ---
 *
 * This program draws 4 bar graphs, by taking thecode from Section 3, and
 * generalizes it into a method.
 */

public class Sec10_prog1 {
	public static void main(String[] args) {
		// these are the 4 arrays that we will plot out
		double[] array1 = { 10, 20, 30, 40, 50, 60 };
		double[] array2 = { 10, 5, 30, 5, 50, 5 };
		double[] array3 = { 90, 70, 50, 30, 10, 5 };
		double[] array4 = { 10, 10, 10, 40, 40, 40 };

		// initialize StdDraw. The version of barGraph() that we use
		// in this section always draws a graph which takes up 100x100,
		// so we allocate a 200x200 graph, large enough for four of
		// them.
		StdDraw.setScale(-100, 100);
		StdDraw.clear();

		// each call to this method should draw a single bar graph
		barGraph(array1, -100, 0);
		barGraph(array2, 0, 0);
		barGraph(array3, -100, -100);
		barGraph(array4, 0, -100);
	}

	// TODO: declare the barGraph() method here

	public static void barGraph(double[] array, int x, int y) {
		Color[] color = { Color.red, Color.green, Color.blue, Color.black, Color.pink };
		for (int i = 0; i < color.length; i++) {
			StdDraw.setPenColor(color[i]);
			StdDraw.filledRectangle(x, y + array[i] / 2, 5, array[i] / 2);
			x = x + 18;
		}
	}

}
