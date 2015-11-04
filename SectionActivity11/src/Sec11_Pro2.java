import java.util.Scanner;

public class Sec11_Pro2 {

	public static void main(String[] args) {

		// int[] a = { 4, 5, 6, 7, 8 };
		// dumpArray(arrayAppend(a, 5));
		//
		// String[] b = { "abc", "cde", "efg", "hij" };
		// dumpArray(arrayAppend(b, "hello"));

		Scanner in = new Scanner(System.in);

		int[] a = {};
		int[] c = {};
		while (in.hasNext()) {
			int b = in.nextInt();
			a = arrayAppend(a, b);
			dumpArray(a);
			c = arrayExtend(a);
			dumpArray(c);
			if (a.length > 3) {

				dumpArray(c, 5);

			}
		}

		in.close();

	}

	public static int[] arrayAppend(int[] array, int newElement) {

		int[] newArray = new int[array.length + 1];

		for (int i = 0; i < newArray.length - 1; i++) {
			newArray[i] = array[i];
		}

		newArray[array.length] = newElement;

		return newArray;
	}

	public static void dumpArray(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(" " + array[i] + ",");
			} else {
				System.out.print(" " + array[i]);
			}

		}
		System.out.print("}\n");
	}

	public static void dumpArray(int[] array, int x) {
		System.out.print("{");
		for (int i = 0; i < x; i++) {
			if (i != x - 1) {
				System.out.print(" " + array[i] + ",");
			} else {
				System.out.print(" " + array[i]);
			}

		}
		System.out.print("}\n");
	}

	public static String[] arrayAppend(String[] array, String newElement) {

		String[] newArray = new String[array.length + 1];

		for (int i = 0; i < newArray.length - 1; i++) {
			newArray[i] = array[i];
		}

		newArray[array.length] = newElement;

		return newArray;
	}

	public static void dumpArray(String[] array, int numberOfElements) {
		System.out.print("{");
		for (int i = 0; i < numberOfElements; i++) {
			if (i != numberOfElements - 1) {
				System.out.print(" " + array[i] + ",");
			} else {
				System.out.print(" " + array[i]);
			}

		}
		System.out.print("}\n");
	}

	public static void dumpArray(String[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(" " + array[i] + ",");
			} else {
				System.out.print(" " + array[i]);
			}

		}
		System.out.print("}\n");
	}

	public static int[] arrayExtend(int[] array) {
		int[] doubleArray = new int[array.length * 2];
		for (int i = 0; i < doubleArray.length / 2; i++) {
			doubleArray[i] = array[i];
			// doubleArray[doubleArray.length/2+i] = array[i];
		}
		return doubleArray;
	}

}
