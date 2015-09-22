import java.util.Scanner;

public class NumberGuesser {

	public static void main(String[] args) {

		int targetNumber = Integer.parseInt(args[0]);
		System.out.println("The target number is: " + targetNumber);

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			int guessNumber = Integer.parseInt(in.next());
			if (targetNumber > guessNumber) {
				System.out.println("YOU GUESS WAS TOO LOW");
				System.out.println("target=" + targetNumber + " guess=" + guessNumber);
			}
			if (targetNumber < guessNumber) {
				System.out.println("YOU GUESS WAS TOO HIGH");
				System.out.println("target=" + targetNumber + " guess=" + guessNumber);
			}
			if(targetNumber == guessNumber){
				System.out.println("GOOD JOB! YOU GOT IT RIGHT!");
			}
		}
		System.out.println("hasNext() RETURNED false, SO THE GAME HAS ENDED");

	}

}
