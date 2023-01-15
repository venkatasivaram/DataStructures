package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NoOfOccrancesOfWord {

	public static void main(String[] args) {
		String s = "Today is Monday and Today is sunny day";

		String[] splitArr = s.split(" ");

//		Arrays.stream(splitArr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//				.forEach((k, v) -> System.out.println(k + " " + v));

		for (int i = 0; i < splitArr.length; i++) {

			String str = splitArr[i];

			int count = 1;

			if (str.trim().equals(""))
				continue;

			for (int j = i + 1; j < splitArr.length; j++) {

				if (str.equals(splitArr[j])) {
					count++;
					splitArr[j] = " ";
				}

			}
			System.out.println(str + " Occurances " + count);
			splitArr[i] = " ";
		}

	}

}
