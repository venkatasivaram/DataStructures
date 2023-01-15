package test;

import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoofOccurances {

	public static void main(String[] args) {
		String s = "JAVA J2EE JSP";

//		s.codePoints().filter(c -> c != ' ').mapToObj(c -> Character.toString((char) c))
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//				.forEach((k, v) -> System.out.println(k + " " + v));

		int[] arr = new int[256];

		int len = s.length();

		for (int i = 0; i < len; i++) {
			
			arr[s.charAt(i)]++;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0 && arr[i]!=32) {
				System.out.println(String.format("%c", i) + "  " + arr[i]);
			}
		}

	}

}
