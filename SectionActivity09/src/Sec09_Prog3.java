
public class Sec09_Prog3 {

	public static void main(String[] args) {
		printArrow();
		printTree();
	}

	public static void printRepeated(int count, boolean addNewLine, char t) {
		String asterisks = "";
		for (int i = 0; i < count; i++) {
			asterisks += t;
		}

		System.out.print(asterisks);
		if (addNewLine == true) {
			System.out.print("\n");
		}
	}

	public static void printArrow() {
		int[] arrayOfNumbers = { 1, 3, 5, 7, 5, 3, 1 };
		for (int x = 0; x < 7; x++) {
			printRepeated(arrayOfNumbers[x], true, 'A');
		}
	}

	public static void printTree() {
		int[] arrayOfNumbersTwo = { 5, 4, 3, 2, 1, 0 };
		int x = 1;
		for (int y = 0; y < 6; y++) {
			
			printRepeated(arrayOfNumbersTwo[y], false, ' ');
			printRepeated(x, true, '1');
			x += 2;
			
		}
	}

}
