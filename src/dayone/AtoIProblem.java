package dayone;

import static java.lang.Character.isDigit;

public class AtoIProblem {

	public static int myAtoi(String s) {
		String ff =  "";
		char fff[] = {'1','2','3','4','5','6','7','8','9','0'};
		boolean started = false;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='-') {
				ff+="-";
				started = true;
			}
            for (char c : fff) {
                if (s.charAt(i) == c) {
                    ff += s.charAt(i);
					started = true;
                }
            }
			if(started && i+1<s.length()-1) {
				if(!isDigit(s.charAt(i+1))) {
					return Integer.parseInt(ff);
				}

			}
		}
		return Integer.parseInt(ff); // change this!
		}

public static void check(String in, int out) {
		System.out.print("Input " + in + "...");
		System.out.print("Output " + myAtoi(in) + "...");
		if (myAtoi(in) == out) {
				System.out.println("PASSED.");
		} else {
				System.out.println("FAILED. Expected: " + out);
		}
}

public static void main(String args[]) {
		check("12345", 12345);
		check("   123", 123);
		check("0", 0);
		check("-0", 0);
		check("-123", -123);
		check("    +401", 401);
		check("  234.12E", 234);
		check("  12 34 40", 12);

}
}