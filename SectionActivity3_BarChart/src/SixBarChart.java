import java.awt.Color;


public class SixBarChart {

	public static void main(String[] args) {

		double[] A = new double[6];
		Color B[] = {StdDraw.BLACK, StdDraw.BLUE, StdDraw.GRAY, StdDraw.GREEN, StdDraw.YELLOW, StdDraw.RED};
		
		for (int i = 0; i < 6; i++) {
			A[i] = Double.parseDouble(args[i]);
			System.out.println(A[i] + " ");
		}

		StdDraw.setScale(0, 100);
		StdDraw.clear();

		double i = 5;

		StdDraw.line(0, 0, 0, 100);
		StdDraw.line(0, 0, 100, 0);
		
		for (int j = 0; j < 6; j++) {
			StdDraw.setPenColor(B[j]);
	        StdDraw.text(i,A[j]+10, ""+A[j]);
			StdDraw.setPenColor(B[j]);
			StdDraw.filledRectangle(i, A[j]/2, 4, A[j]/2);
			i = i+15;
		}

	}

}
