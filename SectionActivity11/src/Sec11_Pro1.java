import java.util.Scanner;

public class Sec11_Pro1 {

	public static void main(String[] args) {

		// int[] a = { 4, 5, 6, 7, 8 };
		// dumpArray(arrayAppend(a, 5));
		//
		// String[] b = { "abc", "cde", "efg", "hij" };
		// dumpArray(arrayAppend(b, "hello"));

		Scanner in = new Scanner(System.in);

		String[] a = {};
		while (in.hasNext()) {
			String b = in.next();
			a = arrayAppend(a, b);
			dumpArray(a);
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

	public static String[] arrayAppend(String[] array, String newElement) {

		String[] newArray = new String[array.length + 1];

		for (int i = 0; i < newArray.length - 1; i++) {
			newArray[i] = array[i];
		}

		newArray[array.length] = newElement;

		return newArray;
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

}
