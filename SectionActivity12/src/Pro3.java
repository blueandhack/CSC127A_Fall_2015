import java.util.Scanner;

public class Pro3 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		byte a = 1;
		short b = 1;
		int c = 1;
		long d = 1;
		while (in.hasNextLine()) {
			String e = in.nextLine();
			if (e.length() == 0) {
				a *= 3;
				b *= 3;
				c *= 3;
				d *= 3;
				System.out.printf("%d %d %s %s / %d\n", a, b, fuzzyNum(c), fuzzyNum(d), (long) a);
			}
		}

	}

	public static String fuzzyNum(long val) {
		if (val < 0)
			return "-" + fuzzyNum(-val);
		final long ONE_THOUSAND = 1000L;
		final long ONE_MILLION = 1000000L;
		final long ONE_BILLION = 1000000000L;
		final long ONE_TRILLION = 1000000000000L;
		final long ONE_QUADRILLION = 1000000000000000L;
		final long ONE_QUINTILLION = 1000000000000000000L;
		if (val < ONE_THOUSAND)
			return "" + val;
		if (val < ONE_MILLION)
			return val / ONE_THOUSAND + " thousand";
		if (val < ONE_BILLION)
			return val / ONE_MILLION + " million";
		if (val < ONE_TRILLION)
			return val / ONE_BILLION + " billion";
		if (val < ONE_QUADRILLION)
			return val / ONE_TRILLION + " trillion";
		if (val < ONE_QUINTILLION)
			return val / ONE_QUADRILLION + " quintillion";	
		return "gazillions";
	}
}
