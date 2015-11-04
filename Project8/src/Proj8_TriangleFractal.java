public class Proj8_TriangleFractal {
	public static void main(String[] args) {
		StdDraw.setScale(-100, 100);
		StdDraw.clear();

		while (true) {
			for (int i = 1; i < 8; i++) {
				StdDraw.clear();
				StdDraw.show();
				drawTriangleFractal(i, -75, 0, 75, 0);
				StdDraw.show(1000);
			}

			for (int i = 1; i < 8; i++) {
				StdDraw.clear();
				StdDraw.show();
				drawTriangleFractal(i, -50, -25, 0, 50);
				drawTriangleFractal(i, 0, 50, 50, -25);
				drawTriangleFractal(i, 50, -25, -50, -25);
				StdDraw.show(1000);
			}

			for (int i = 1; i < 9; i++) {
				StdDraw.clear();
				StdDraw.show();

				drawTriangleFractal(i, -25, -12.5, 25, -12.5);
				drawTriangleFractal(i, 25, -12.5, 0, 25);
				drawTriangleFractal(i, 0, 25, -25, -12.5);

				drawTriangleFractal(i, -50, -25, 0, 50);
				drawTriangleFractal(i, 0, 50, 50, -25);
				drawTriangleFractal(i, 50, -25, -50, -25);
				StdDraw.show(1000);
			}
		}
	}

	public static void drawTriangleFractal(int levels, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);

		if (levels <= 1) {
			return;
		}

		double x3 = x1 + (x2 - x1) / 3;
		double y3 = y1 + (y2 - y1) / 3;

		double x4 = x1 + 2 * (x2 - x1) / 3;
		double y4 = y1 + 2 * (y2 - y1) / 3;

		double x5 = x1 + (x2 - x1) / 2 - (y2 - y1) / 4;
		double y5 = y1 + (y2 - y1) / 2 + (x2 - x1) / 4;

		drawTriangleFractal(levels - 1, x1, y1, x3, y3);
		drawTriangleFractal(levels - 1, x3, y3, x5, y5);
		drawTriangleFractal(levels - 1, x5, y5, x4, y4);
		drawTriangleFractal(levels - 1, x4, y4, x2, y2);
	}
}