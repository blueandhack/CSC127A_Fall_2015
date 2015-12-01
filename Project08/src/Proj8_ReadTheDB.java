
/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 08
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 * The program should read a lots of data, then it select correct format line.
 * Correct format: [String] [String] [int] (correct line just has two spaces)
 * Finally, the program will print out all data that it stored data.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj8_ReadTheDB {

	public static void main(String[] args) throws FileNotFoundException {

		// max of length
		final int MAX = 1000;

		// read argument from args[0]
		if (args.length == 0) {
			System.out.println("ERROR! Please give filename!");
			return;
		}

		// get filename
		String filename = args[0];

		// file's direction
		// I use eclipse, so I need add "src/"
		File openFile = new File("src/" + filename);

		// create Scanner object to read file
		Scanner scan = new Scanner(openFile);

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

		scan.close();

		System.out.println("-------------------------------------------------");

		for (int i = 0; i < correctCount; i++) {
			System.out.println(firstWord[i] + " " + secondWord[i] + " " + lastNumber[i]);
		}

		System.out.println("-------------------------------------------------");
		if (correctCount == MAX) {
			System.out.println("Number of Correct Line Over " + MAX + " Line, So I Can't Store More Line.");
		}
		System.out.println("Number of Line: " + realLineCount);
		System.out.println("Number of Blank Line: " + blankCount);
		System.out.println("Number of Format Wrong Line: " + formatCount);
		System.out.println("Number of Correct Line: " + correctCount);
		System.out.println("-------------------------------------------------");
		System.out.println(
				"Note: If last line is blank line, hasNextLine will skip it, so Number of Line not equals real number of line.");

	}

}
