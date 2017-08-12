public class Gcd {	
	// recursion
	public static int gcd(int a, int b) {
		if (a < b) {
			int c = a;
			a = b;
			b = c;
		}
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
	
	// iteration
	public static int gcd2(int a, int b) {
		if (a < b) {
			int c = a;
			a = b;
			b = c;
		}
		int rem = 0;
		while ((rem = a % b) != 0) {
			a = b;
			b = rem;
		}
		return b;
	}
	
	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	// unit test
	public static void main (String[] args) {
		System.out.println(gcd2(7, 21));
	}
}
