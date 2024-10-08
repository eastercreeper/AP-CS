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

	public static boolean checkQU(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(isVowel(s.charAt(i)) && s.toLowerCase().charAt(i) == 'u' && s.toLowerCase().charAt(i - 1) == 'q') {
				return true;
			}
		}
		return false;
	}

	public static boolean checkY(String s) {
		return false;
	}

	public static boolean checkCaptial(String s) {
        return Character.isUpperCase(s.charAt(0));
	}

	public static String pigLatin_v1(String s) {
		String finish = "";
		if (firstVowelIndex(s) != -1) {
			if(checkCaptial(s)) {
				if (isVowel(s.toLowerCase().charAt(0))) {
					char orig = s.charAt(0);
					char upper = Character.toUpperCase(orig);
					return upper + s.substring(1) + "way";
				}
				if(checkQU(s)) {
					char orig = s.charAt(firstVowelIndex(s)+1);
					char upper = Character.toUpperCase(orig);
					finish = upper + s.substring(firstVowelIndex(s) + 2) + s.substring(0, firstVowelIndex(s)+1).toLowerCase() + "ay";
				} else {
					char orig = s.charAt(firstVowelIndex(s));
					char upper = Character.toUpperCase(orig);
					System.out.println("no qu");
					finish = upper + s.substring(firstVowelIndex(s) + 1) + s.substring(0, firstVowelIndex(s)).toLowerCase() + "ay";
				}
			} else {
				if(checkQU(s)) {
					return s.substring(firstVowelIndex(s)+1) + s.substring(0, firstVowelIndex(s)+1) + "ay";
				} else {
					return s.substring(firstVowelIndex(s)) + s.substring(0, firstVowelIndex(s)) + "ay";
				}
			}
			return finish;
		}
		return "INVALID";
	}

	public static void main(String[] args) {
		//System.out.println(pigLatin_v1("hello"));
		System.out.println(pigLatin_v1("Oogway"));
		System.out.println(pigLatin_v1("pdfs"));
		System.out.println(pigLatin_v1("Throw"));
		System.out.println(pigLatin_v1("Question"));
		System.out.println(pigLatin_v1("question"));
		System.out.println(pigLatin_v1("squeeze"));
	}
}