import java.util.Scanner;

public class Proj6_InteractiveDraw {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StdDraw.setScale(-200, 200);
		StdDraw.clear();
		while (in.hasNext()) {
			String stringLine = in.nextLine();
			if (stringLine.indexOf(" ") == -1) {
				continue;
			}
			int spaceIndex = stringLine.indexOf(" ");
			System.out.println(stringLine.substring(0, spaceIndex));
			System.out.println(stringLine.substring(spaceIndex + 1));

			String color = stringLine.substring(0, spaceIndex);
			String shap = stringLine.substring(spaceIndex + 1);

			

			if (color.equals("red")) {
				StdDraw.setPenColor(StdDraw.RED);
				drawShap(shap);
			} else if (color.equals("green")) {
				StdDraw.setPenColor(StdDraw.GREEN);
				drawShap(shap);
			} else if (color.equals("blue")) {
				StdDraw.setPenColor(StdDraw.BLUE);
				drawShap(shap);
			} else if (color.equals("white")) {
				StdDraw.setPenColor(StdDraw.WHITE);
				drawShap(shap);
			} else if (color.equals("black")) {
				StdDraw.setPenColor(StdDraw.BLACK);
				drawShap(shap);
			}

		}
	}

	public static void drawShap(String shap) {
		if (shap.equals("circle")) {
			StdDraw.circle(0, 0, 50);
			StdDraw.show();
		} else if (shap.equals("square")) {
			StdDraw.square(0, 0, 80);
			StdDraw.show();
		} else if (shap.equals("rectangle")) {
			StdDraw.rectangle(0, 0, 90, 90);
			StdDraw.show();
		}
	}

}
