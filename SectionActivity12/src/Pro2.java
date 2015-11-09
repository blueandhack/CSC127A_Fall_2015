import java.util.Scanner;

public class Pro2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int a = 1;
		int b = 1;
		int c = 1;
		int d = 1;
		while (in.hasNextLine()) {
			String e = in.nextLine();
			if (e.length() == 0) {
				a *= 3;
				b *= 3;
				c *= 3;
				d *= 3;
				System.out.printf("%d %d %d %d / %d\n", (byte) a, (short) b, (int) c, (long) d, (long) (byte) d);
			}
		}

	}

}
