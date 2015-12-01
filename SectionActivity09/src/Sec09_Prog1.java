
public class Sec09_Prog1 {

	public static void main(String[] args) {
		int a = add(999999, 1);
		int b = add(100, 1);
		int c = add(9999, 1);
		int e = add(10, 1);

		int f = mul(-999999, 1);
		int g = mul(1000, 1);
		int h = mul(9999, 1);
		int i = mul(10, 1);

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int mul(int a, int b) {
		return a * b;
	}

}
