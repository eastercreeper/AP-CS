package pigLatin;

public class pigLatin1 {

	public static boolean charIsInString(char c, String s) {
		return s.contains(c + "");
	}

	public static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	public static boolean isConsonant(char c) {
		return !isVowel(c) && ((c > 65 && c < 91) || (c > 97 && c < 123));
	}

	public static int firstVowelIndex(String s) {
		for (int v = 0; v < s.length(); v++) {
			if (isVowel(s.charAt(v))) return v;
		}
		return -1;
	}

	public static boolean checkCaptial(String s) {
        return Character.isUpperCase(s.charAt(0));
	}

	public static String pigLatin_v1(String s) {
		String finish = "";
		if (firstVowelIndex(s) != -1) {
			if (isVowel(s.charAt(0))) return s + "way";
			if(checkCaptial(s)) {
				System.out.println(" upper");

				char orig = s.charAt(firstVowelIndex(s));
				char upper = Character.toUpperCase(orig);
				finish =   upper + s.substring(firstVowelIndex(s)+1) + s.substring(0, firstVowelIndex(s)).toLowerCase() + "ay";
			} else {
				return s.substring(firstVowelIndex(s)) + s.substring(0, firstVowelIndex(s)) + "ay";
			}
			return finish;
		}
		return "INVALID";
	}

	public static void main(String[] args) {
		//System.out.println(pigLatin_v1("hello"));
		System.out.println(pigLatin_v1("oogway"));
		System.out.println(pigLatin_v1("pdfs"));
		System.out.println(pigLatin_v1("Throw"));
	}
}