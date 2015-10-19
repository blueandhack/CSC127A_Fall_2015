import java.util.Scanner;

public class Proj6_ReadLineTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String stringLine = in.nextLine();
			if (stringLine.indexOf(" ") == -1) {
				continue;
			}
			int spaceIndex = stringLine.indexOf(" ");
			System.out.println(stringLine.substring(0, spaceIndex));
			System.out.println(stringLine.substring(spaceIndex + 1));
		}

	}

}
