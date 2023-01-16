package test;

public class NonRepeatingCharinString {

	public static void main(String[] args) {

		String s = "dddccdbba";
		int index = -1;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (sb.indexOf(String.valueOf(ch)) != -1)
				continue;
			sb.append(ch);

			boolean unique = true;
			for (int j = i + 1; j < s.length(); j++) {
				if (ch == s.charAt(j)) {
					unique = false;
					break;
				}
			}

			if (unique) {
				index = i;
				break;
			}
		}

		System.out.println(index);
	}

}
