
/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 06
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 *
 * The program to read user's input, such as user input "red circle" 
 * after the program splits the string become two words.
 * So, we can see two words are "red" and "circle." 
 */

import java.util.Scanner;

public class Proj6_ReadLineTest {

	public static void main(String[] args) {
		// create a Scanner object
		Scanner in = new Scanner(System.in);

		// infinity loop
		while (in.hasNext()) {
			// store user's input
			String stringLine = in.nextLine();
			// output error when the string does not have a space
			if (stringLine.indexOf(" ") == -1) {
				System.out.println("ERROR! You must include a space.");
				continue;
			}
			// get space's index in string
			int spaceIndex = stringLine.indexOf(" ");
			// output first word and second word
			System.out.println(stringLine.substring(0, spaceIndex));
			System.out.println(stringLine.substring(spaceIndex + 1));
		}
		
		in.close();

	}

}
