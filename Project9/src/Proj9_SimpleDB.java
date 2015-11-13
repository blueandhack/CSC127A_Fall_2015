
/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 09
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 * The program should read a lots of data, then it select correct format line.
 * Correct format: [String] [String] [int] (correct line just has two spaces)
 * Then, the program read user typed command line to search data from database.
 * Finally, it prints out all of results.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj9_SimpleDB {

	// max of length
	final static int MAX = 1000;

	public static void main(String[] args) throws FileNotFoundException {

		// read argument from args[0]
		if (args.length == 0) {
			System.out.println("ERROR! Please give filename!");
			return;
		}

		// get filename
		String filename = args[0];

		// file's direction
		File openFile = new File(filename);

		// create Scanner object to read file
		Scanner scan = new Scanner(openFile);

		// create Scanner object to read user type
		Scanner in = new Scanner(System.in);

		String[] firstWord = new String[MAX];
		String[] secondWord = new String[MAX];
		int[] lastNumber = new int[MAX];

		int correctCount = 0;
		int realLineCount = 0;
		int formatCount = 0;
		int blankCount = 0;
		while (scan.hasNextLine()) {

			String eachLine = scan.nextLine();

			// count number of line
			realLineCount++;
			// System.out.println(realLineCount);

			// if the line is blank line
			if (eachLine.indexOf(" ") == -1 && eachLine.length() == 0) {
				blankCount++;
				continue;
			}

			// if this line is not empty but the line has some words no space
			if (eachLine.indexOf(" ") == -1 && eachLine.length() > 0) {
				System.out.println("ERROR: Format is wrong." + "(Line:" + realLineCount + ")");
				formatCount++;
				continue;
			}

			// get space count
			// no empty line
			int count = 0;
			for (int i = 0; i < eachLine.length(); i++) {
				if (eachLine.charAt(i) == ' ') {
					count++;
				}
			}

			// over two spaces that is wrong format
			if (count > 2) {
				System.out.println("ERROR: Format is wrong." + "(Line:" + realLineCount + ")");
				formatCount++;
				continue;
			}

			// the line just has a space
			if (count == 1) {
				System.out.println("ERROR: Format is wrong." + "(Line:" + realLineCount + ")");
				formatCount++;
				continue;
			}

			int[] spaceIndex = { 0, 0 };
			count = 0;
			// get space's index and store them
			for (int i = 0; i < eachLine.length(); i++) {
				if (eachLine.charAt(i) == ' ') {
					spaceIndex[count] = i;
					count++;
				}
			}

			// if first space at the line first
			if (spaceIndex[0] == 0) {
				System.out.println("ERROR: Format is wrong." + "(Line:" + realLineCount + ")");
				formatCount++;
				continue;
			}

			// if the line has two space together
			if (spaceIndex[0] + 1 == spaceIndex[1]) {
				System.out.println("ERROR: Format is wrong." + "(Line:" + realLineCount + ")");
				formatCount++;
				continue;
			}

			// if the array is full
			if (correctCount == MAX) {
				System.out.println("Stop!!! Over Array Length.");
				break;
			}

			// store correct data
			firstWord[correctCount] = eachLine.substring(0, spaceIndex[0]);
			secondWord[correctCount] = eachLine.substring(spaceIndex[0] + 1, spaceIndex[1]);
			lastNumber[correctCount] = Integer.parseInt(eachLine.substring(spaceIndex[1] + 1));

			correctCount++;
		}

		System.out.println("-------------------------------------------------");
		if (correctCount == MAX) {
			System.out.println("Number of Correct Line Over " + MAX + " Line, So I Can't Store More Line.");
		}

		// resize all of data
		String[] newFirstWord = resizeArray(firstWord, correctCount);
		String[] newSecondWord = resizeArray(secondWord, correctCount);
		int[] newLastNumber = resizeArray(lastNumber, correctCount);

		// print out result
		System.out.println("Number of Line: " + realLineCount);
		System.out.println("Number of Blank Line: " + blankCount);
		System.out.println("Number of Format Wrong Line: " + formatCount);
		System.out.println("Number of Correct Line: " + correctCount);
		System.out.println("-------------------------------------------------");
		System.out.println(
				"Note: If last line is blank line, hasNextLine will skip it, so Number of Line not equals real number of line.");
		System.out.println("-------------------------------------------------");

		// some tips
		System.out.println("PLEASE INPUT YOU WANT TO SEARCH KEYWORD AND METHOD NAME (SUCH AS: age 30):");

		// waiting user type something
		while (in.hasNextLine()) {

			String line = in.nextLine();

			if (line.substring(0).equals("listAll")) {
				listAll(newFirstWord, newSecondWord, newLastNumber);
				continue;
			}

			if (line.indexOf(" ") == -1 && line.length() == 0) {
				System.out.println("YOU TPYE WAS WRONG, PLEASE TYPE AGAIN.");
				continue;
			}

			int space = 0;

			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == ' ') {
					space++;
				}
			}

			if (space != 1) {
				System.out.println("YOU TPYE WAS WRONG, PLEASE TYPE AGAIN.");
				continue;
			}

			int spcaeIndex = line.indexOf(" ");
			String methodName = line.substring(0, spcaeIndex);
			String keyWords = line.substring(spcaeIndex + 1);
			if (methodName.equals("age")) {
				try {
					int age = Integer.parseInt(keyWords);
					findByAge(newFirstWord, newSecondWord, newLastNumber, age);
				} catch (Exception e) {
					System.out.println("YOU DIDN'T PUT INT NUMBER");
				}
				continue;
			}

			if (methodName.equals("lastName")) {
				if (keyWords.length() == 0) {
					System.out.println("YOU DIDN'T PUT LASTNAME");
					continue;
				}
				findByLastName(newFirstWord, newSecondWord, newLastNumber, keyWords);
				continue;
			}

			if (methodName.equals("firstName")) {
				if (keyWords.length() == 0) {
					System.out.println("YOU DIDN'T PUT FIRSTNAME");
					continue;
				}
				findByFirstName(newFirstWord, newSecondWord, newLastNumber, keyWords);
				continue;
			}

			System.out.println("YOU TPYE WAS WRONG, PLEASE TYPE AGAIN.");

		}

		scan.close();
		in.close();

	}

	// the function print out all of data
	public static void listAll(String[] firstWord, String[] secondWord, int[] lastNumber) {

		System.out.println("-------------------------------------------------");
		for (int i = 0; i < firstWord.length; i++) {
			System.out.println(firstWord[i] + " " + secondWord[i] + " " + lastNumber[i]);
		}
		System.out.println("-------------------------------------------------");
	}

	// the function can find some data by last name
	public static void findByLastName(String[] firstWord, String[] secondWord, int[] lastNumber, String lastName) {
		int[] index = new int[MAX];

		int count = 0;

		for (int i = 0; i < firstWord.length; i++) {
			if (firstWord[i].equals(lastName)) {
				index[count] = i;
				count++;
			}
		}

		if (count == 0) {
			System.out.println("NOT FOUND LASTNAME IS " + lastName);
		} else {
			System.out.println("-------------------------------------------------");
			for (int i = 0; i < count; i++) {
				System.out.println(firstWord[index[i]] + " " + secondWord[index[i]] + " " + lastNumber[index[i]]);
			}
			System.out.println(count + " RECORDS FOUND");

			System.out.println("-------------------------------------------------");
		}

	}

	// the function can find some data by first name
	public static void findByFirstName(String[] firstWord, String[] secondWord, int[] lastNumber, String firstName) {

		int[] index = new int[MAX];

		int count = 0;

		// find firstName
		for (int i = 0; i < firstWord.length; i++) {
			if (secondWord[i].equals(firstName)) {
				index[count] = i;
				count++;
			}
		}

		if (count == 0) {
			System.out.println("NOT FOUND FIRSTNAME IS " + firstName);
		} else {
			System.out.println("-------------------------------------------------");
			for (int i = 0; i < count; i++) {
				System.out.println(firstWord[index[i]] + " " + secondWord[index[i]] + " " + lastNumber[index[i]]);
			}
			System.out.println(count + " RECORDS FOUND");
			System.out.println("-------------------------------------------------");
		}
	}

	// the function can find some data by age
	public static void findByAge(String[] firstWord, String[] secondWord, int[] lastNumber, int age) {
		int[] index = new int[MAX];

		int count = 0;

		// find age
		for (int i = 0; i < firstWord.length; i++) {
			if (lastNumber[i] == age) {
				index[count] = i;
				count++;
			}
		}

		if (count == 0) {
			System.out.println("NOT FOUND AGE IS " + age);
		} else {
			System.out.println("-------------------------------------------------");
			for (int i = 0; i < count; i++) {
				System.out.println(firstWord[index[i]] + " " + secondWord[index[i]] + " " + lastNumber[index[i]]);
			}
			System.out.println(count + " RECORDS FOUND");
			System.out.println("-------------------------------------------------");
		}

	}

	// resize int array
	public static int[] resizeArray(int array[], int lastIndex) {

		int[] newArray = new int[lastIndex];
		for (int i = 0; i < lastIndex; i++) {
			newArray[i] = array[i];
		}

		return newArray;
	}

	// resize string array
	public static String[] resizeArray(String array[], int lastIndex) {

		String[] newArray = new String[lastIndex];
		for (int i = 0; i < lastIndex; i++) {
			newArray[i] = array[i];
		}

		return newArray;

	}

}
