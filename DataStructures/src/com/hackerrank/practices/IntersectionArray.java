package com.hackerrank.practices;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntersectionArray {

	public static void main(String args[]) {

		int[] array1 = { 1,2,2,1 };

		int[] array2 = { 2,2 };

		int m = array1.length;
		int n = array2.length;

		int o = (m < n) ? m : n;
		int[] array3 = new int[o];
		Arrays.sort(array1);
		Arrays.sort(array2);
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < m && j < n) {

			if (array1[i] == array2[j]) {
				array3[k] = array1[i];
				System.out.println(array3[k]);
				i = i + 1;
				j = j + 1;
				k = k + 1;

			}
			else if (array1[i] < array2[j]) {
				i = i + 1;
			} else if (array1[i] > array2[j]) {
				j = j + 1;
			}

		}
		
		int[] finarray=IntStream.of(array3).filter(s -> s!= 0).toArray();
		//System.out.println(finarray.length);
		
	}

}
