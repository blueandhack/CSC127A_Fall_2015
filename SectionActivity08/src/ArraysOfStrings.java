import java.util.Scanner;

public class ArraysOfStrings {

	public static void main(String[] args) {
		String[] a = new String[4];
		int i = 0;

		Scanner in = new Scanner(System.in);

		int count = 0;
		while (in.hasNext()) {
			if (count > 3) {
				break;
			}

			String b = in.next();

			if (b.equals("END")) {
				a[count] = b;
				break;
			}
			a[count] = b;
			count++;
		}

		for (i = 0; i < count; i++) {

			System.out.println(a[i]);
		}
	}

}
