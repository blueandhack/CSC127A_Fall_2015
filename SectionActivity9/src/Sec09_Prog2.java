
public class Sec09_Prog2 {

	public static void main(String[] args) {
		int[] arrayOfNumbers = { 1, 3, 5, 7, 5, 3, 1 };
		for (int x = 0; x < 7; x++) {
			printStars(arrayOfNumbers[x], true);
		}

		int[] arrayOfNumbersTwo = { 5, 4, 3, 2, 1, 0 };
		int x = 1;
		for (int y = 0; y < 6; y++) {
			for (int z = 0; z < arrayOfNumbersTwo[y]; z++) {
				System.out.print(" ");
			}
			printStars(x, true);
			x += 2;
		}
	}

	public static void printStars(int count, boolean addNewLine) {
		String asterisks = "";
		for (int i = 0; i < count; i++) {
			asterisks += "*";
		}

		System.out.print(asterisks);
		if (addNewLine == true) {
			System.out.print("\n");
		}
	}

}
