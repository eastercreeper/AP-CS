package dayone;

public class ReverseInt {
	public static int reverse(int x) {
		int ff = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			ff*=10;
			ff+=pop;
		}
		return ff; //change this
	}

	public static void check(int in, int out) {
		System.out.print("Input " + in + "...");
		System.out.print("Output " + reverse(in) + "...");
		if (reverse(in) == out) {
				System.out.println("PASSED.");
		} else {
				System.out.println("FAILED. Expected: " + out);
		}
}

public static void main(String args[]) {
		check(1423, 3241);
		check(1001, 1001);
		check(1234567, 7654321);
		check(12300, 321);
		check(1, 1);
		check(0, 0);
		check(100,1);

	}
}
