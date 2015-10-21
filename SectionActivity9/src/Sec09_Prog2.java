
public class Sec09_Prog2 {

	public static void main(String[] args) {

		int[] arrayOfNumbers = { 1, 3, 5, 7, 5, 3, 1 };
		for (int i = 0; i < 7; i++) {
			printStars(arrayOfNumbers[i], true);
		}

		
		for (int i = 0; i < 6; i++) {
			for (int j = 4 - i; j >= 0; j--) {
				System.out.print(" ");
			}

			printStars(i + 2, true);
		}

	}

	public static void printStars(int count, boolean addNewline) {

		for (int i = 0; i < count; i++) {
			System.out.print("*");
		}
		if (addNewline) {
			System.out.print("\n");
		}

	}
}
