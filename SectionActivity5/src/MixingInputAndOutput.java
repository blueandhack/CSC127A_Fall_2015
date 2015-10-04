import java.util.Scanner;

public class MixingInputAndOutput {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int flag = 0;

		String[] words = new String[3];
		System.out.print("enter the first word: ");

		while (in.hasNext()) {
			if (flag == 0) {
				words[0] = in.next();
			}
			if (flag == 1) {

				words[1] = in.next();
			}
			if (flag == 2) {

				words[2] = in.next();
			}

			flag++;

			if (flag == 1) {
				System.out.print("enter the second word: ");
			}

			if (flag == 2) {
				System.out.print("enter the third word: ");
			}

			if (flag > 2) {
				break;
			}

		}

		in.close();

		System.out.print("Your three words were:");

		for (int i = 0; i < words.length; i++) {
			System.out.print(" " + words[i]);
		}

		System.out.print("\n");

		System.out.print("Your three words (in reverse order) were:");
		for (int i = words.length - 1; i >= 0; i--) {
			System.out.print(" " + words[i]);
		}

		System.out.print("\n");

	}

}
