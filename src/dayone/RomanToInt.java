package dayone;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

public static int romanToInt(String s) {
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	map.put('I', 1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D', 500);
	map.put('M', 1000);
	s = s.replace("IV","IIII");
	s = s.replace("IX","VIIII");
	s = s.replace("XL","XXXX");
	s = s.replace("XC","LXXXX");
	s = s.replace("CD","CCCC");
	s = s.replace("CM","DCCCC");
	int ff = 0;
	for(int i = 0; i < s.length(); i++) {
		ff = ff + map.get(s.charAt(i));
	}
	return ff;
}
public static void check(String in, int out) {
		System.out.print("Input " + in + "...");
		System.out.print("Output " + romanToInt(in) + "...");
		if (romanToInt(in) == out) {
				System.out.println("PASSED.");
		} else {
				System.out.println("FAILED. Expected: " + out);
		}
}

public static void main(String args[]) {
		check("XVIII", 18);
		check("MMLXVII", 2067);
		check("XXIV", 24);
		check("LXIV", 64);
		check("CCCXLIV", 344);
		check("CCXXX", 230);
	}
}
