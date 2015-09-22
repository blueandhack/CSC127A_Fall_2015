/* CSC127A
 * Section Letter: B
 *
 * CSc 127A Fall 15, Project 03
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 *
 * Give zero, two, four, or six arguments, and according those arguments to repeat character string. 
 * Such as, you put "abc 5" in command line, then you can see "abc" that repeat five times.
 */

public class Proj3_Repeat {

	public static void main(String[] args) {

		//Judge the number of parameters
		if (args.length == 0) {
			System.out.println("No arguments were given.");
			return;
		} else if (args.length % 2 == 1) {
			System.out.println("Please give even arguments.");
			return;
		}

		//Using outputString function to print result
		outputString(args);

	}

	//Output function to print
	public static void outputString(String arguments[]) {

		for (int i = 0; i < arguments.length;) {
			String b = arguments[i];
			for (int j = 0; j < Integer.parseInt(arguments[i + 1]); j++) {
				System.out.println(b);
			}
			i = i + 2;
		}

	}

}
