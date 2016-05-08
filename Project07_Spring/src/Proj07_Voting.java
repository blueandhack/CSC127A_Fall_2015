import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj07_Voting {

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
				voters[i] = new Voter(name, preferences, candidates);
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
		System.out.println("Beginning voting...");
		doSimpleElection(voters, candidates);
		System.out.println("STARTING AN ALTERNATIVE VOTE ELECTION:");
		doAlternativeVoteElection(voters, candidates);
	}

	public static int[] doVoting(Voter[] voters, String[] candidates) {
		int[] count = new int[candidates.length];
		Voter[] newVoters = new Voter[voters.length];
		for (int i = 0; i < newVoters.length; i++) {
			newVoters[i] = new Voter(voters[i].getName(), voters[i].getPreferences(), candidates);
		}
		for (int i = 0; i < newVoters.length; i++) {
			int voterNumer = newVoters[i].vote();
			if (voterNumer != -1) {
				count[voterNumer]++;
			}
		}
		return count;
	}

	public static void doSimpleElection(Voter[] voters, String[] candidates) {
		int[] count = doVoting(voters, candidates);
		int index = 0;
		int max = count[0];
		for (int i = 1; i < count.length; i++) {
			if (max < count[i]) {
				index = i;
				max = count[i];
			}
		}
		System.out.println("Voting has ended...");
		System.out.println(candidates[index] + " WON THE SIMPLE ELECTION.");
	}

	public static void doAlternativeVoteElection(Voter[] voters, String[] candidates) {
		String[] newCandidates = new String[candidates.length];
		for (int i = 0; i < newCandidates.length; i++) {
			newCandidates[i] = candidates[i];
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("Beginning voting...");
			int[] count = doVoting(voters, newCandidates);
			int maxIndex = 0;
			int minIndex = 0;
			int max = count[0];
			int min = count[0];
			for (int j = 1; j < count.length; j++) {
				if (max < count[j]) {
					maxIndex = j;
					max = count[j];
				}
				if (min > count[j]) {
					minIndex = j;
					min = count[j];
				}
			}
			System.out.println("Voting has ended...");
			if (count[maxIndex] >= 6) {
				System.out.println(newCandidates[maxIndex] + " WON THE ALTERNATIVE VOTE ELECTION.");
				return;
			} else if (i <= 3) {
				System.out.println("No winner yet.  Removing the candidate " + newCandidates[minIndex]);
			} else {
				System.out.println(newCandidates[0] + " WON THE ALTERNATIVE VOTE ELECTION.");
			}
			newCandidates = arrayDel(newCandidates, minIndex);
		}
	}

	public static String[] arrayDel(String[] strs, int index) {
		String[] newStrs = new String[strs.length - 1];
		int j = 0;
		for (int i = 0; i < strs.length; i++) {
			if (i != index) {
				newStrs[j] = strs[i];
				j++;
			}
		}
		return newStrs;
	}

}
