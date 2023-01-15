package com.hackerrank.practices;

public class NumberPalendrome {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();

		int n = 426;
		System.out.println(Integer.toString(424));

		System.out.println(n / 10);
		System.out.println(n % 10);

		while (n != 0) {
			sb.append(n % 10);
			n = n / 10;
		}

		System.out.println(sb.toString());
	}

}
