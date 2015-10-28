public class Sec10_prog2 {
	public static void main(String[] args) {
		// these are the 4 arrays that we will plot out
		double[] array1 = { 10, 20 };
		double[] array2 = { 10, 5, 30, 5, 50, 5 };
		double[] array3 = { 90, 80, 70, 60, 50, 40, 30, 20, 10, 5 };
		double[] array4 = { 10, 10, 10, 5, 5, 5, 40, 40, 40 };

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

	public static void barGraph(double[] array, int x, int y) {

		double halfWidth = 80 / array.length / 2;
		double xCenter = x + 20 / array.length + halfWidth;

		for (int i = 0; i < array.length; i++) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(xCenter, y + array[i] / 2, halfWidth, array[i] / 2);
			xCenter = xCenter + halfWidth * 2 + 20 / array.length;

		}
	}
}
