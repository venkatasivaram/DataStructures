package test;

public class Ranson {

	public static void main(String[] args) {

		String ransomNote = "aa";
		String magazine = "aab";
		System.out.println(canConstruct(ransomNote, magazine));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {

		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char search = ransomNote.charAt(i);
			long ransomCount = ransomNote.codePoints().filter(ch -> ch == search).count();
			long magCount = magazine.codePoints().filter(ch -> ch == search).count();

			boolean chk = (magCount >= ransomCount) ? true : false;
			if (!chk)
				return false;
		}

		return true;
	}

	public static long getNoOfOccurances(String str, char search) {
		return str.codePoints().filter(ch -> ch == search).count();
	}
}
