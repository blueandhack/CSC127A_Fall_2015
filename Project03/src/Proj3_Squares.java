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
 * This program will take exactly two arguments: they are a starting and ending value for a range of integers.
 * The program print out a series of squares, starting with the square of the first argument, 
 * and ending with the square of the second argument.
 */

public class Proj3_Squares {

	public static void main(String[] args) {

		//Judge the number of parameters
		if(args.length == 0 || args.length == 1){
			System.out.println("ERROR: Exactly two arguments must be given: <start> <end>");
			return;
		}else if(args.length >= 3){
			System.out.println("ERROR: Please give just two arguments.");
			return;
		}
		
		//Read arguments from args[]
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		//Judge A is greater than B 
		if(a > b){
			System.out.println("ERROR: The start value must be <= the end!");
			return;
		}
		
		//Using outputString function to print result
		outputString(a, b);
	}
	
	//Output function to print square
	public static void outputString(int a,int b)
	{
		
		for (int i = a; i <= b; i++) {
			System.out.println("The square of "+ i +" is "+ i*i +".");
		}
		
	}
	

}
