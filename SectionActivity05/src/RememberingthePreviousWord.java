import java.util.Scanner;

public class RememberingthePreviousWord {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("TYPE MANY WORDS, ONE PER LINE:");
		
		String oneWord = in.next();
		String twoWord = in.next();
		System.out.println(oneWord + " " + twoWord);
		
		while(in.hasNext()){
			String threeWord = in.next();
			oneWord = twoWord;
			twoWord = threeWord;
			System.out.println(oneWord + " " + twoWord);
		}
		
		System.out.println("PROGRAM TERMINATED");
		
	}

}
