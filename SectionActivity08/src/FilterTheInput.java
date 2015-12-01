import java.util.Scanner;

public class FilterTheInput {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("ERROR");
			return;
		}
		Scanner in = new Scanner(System.in);
		String a = args[0];
		String[] b = new String[100];
		int i = 0;
		while (in.hasNext()) {
			String c = in.next();
			if (a.compareTo(c) > 0) {
				b[i] = c;
				i++;
			}
		}
		
		for (int j = 0; j < i; j++) {
			System.out.println(b[j]);
		}
	}

}
