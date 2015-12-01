import java.util.Scanner;

public class SlicingAndDicing {

	public static void main(String[] args) {
		String a = "";
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			a = in.next();
			System.out.println(a);
			System.out.println(a.length());
			System.out.println(a.charAt(1));
			System.out.println(a.substring(3,6));
		}
	}

}
