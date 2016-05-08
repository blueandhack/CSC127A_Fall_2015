import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj06_Voting {

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 1) {
			return;
		}
		String filename = args[0];
		Scanner readFile = new Scanner(new File(filename));

		String[] candidates = new String[5];
		Voter[] voters = new Voter[12];

		String name = "";
		String preferences[] = new String[5];

		int flag = 0;
		int flagTwo = 0;
		int i = 0;
		while (readFile.hasNext()) {
			// System.out.println(readFile.next());
			if (flag < 5) {
				candidates[flag] = readFile.next();
				flag++;
			}
			if (flag > 4 && flagTwo == 0) {
				name = readFile.next();
				flag++;
				flagTwo++;
			}

			if (flag > 4 && flagTwo > 0) {
				// System.out.println(flagTwo);
				String a = readFile.next();
				// System.out.println(a);
				preferences[flagTwo - 1] = a;
				flag++;
				flagTwo++;
				if (flagTwo == 6) {
					flagTwo = 0;
				}
			}

			if (flag > 9 && flagTwo == 0) {
				voters[i] = new Voter(name, preferences);
				i++;
			}
		}

		readFile.close();

		System.out.println("THESE ARE THE VOTERS:");
		for (int j = 0; j < voters.length; j++) {
			voters[j].print();
		}
		System.out.println("THESE ARE THE CANDIDATES:");
		for (int j = 0; j < candidates.length; j++) {
			System.out.println(candidates[j]);
		}
		System.out.println("STARTING A DUMMY ELECTION:");
		for (int j = 0; j < voters.length; j++) {
			voters[j].vote();
		}
	}

}
