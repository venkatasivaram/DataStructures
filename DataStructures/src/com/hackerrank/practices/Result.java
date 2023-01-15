package com.hackerrank.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result {

	public static List<Integer> reverseArray(List<Integer> a) {

		if (a == null)
			return null;

		return IntStream.range(0, a.size()).map(i -> (a.size() - 1 - i)) // IntStream
				.mapToObj(a::get) // Stream<T>
				.collect(Collectors.toCollection(ArrayList::new));

	}

	public int maxSubArray(int[] nums) {

		int maxsum_so_far = Integer.MIN_VALUE;
		int max_sum_ending = 0;

		for (int i = 0; i < nums.length; i++) {
			max_sum_ending = max_sum_ending + nums[i];

			if (maxsum_so_far < max_sum_ending)
				maxsum_so_far = max_sum_ending;

			if (max_sum_ending < 0)
				max_sum_ending = 0;

		}

		return maxsum_so_far;
	}

	public static int hourglassSum(List<List<Integer>> arr) {

		if (arr == null)
			return -1;

		int maxsum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(i).size(); j++) {

				if ((i + 2 < 6) && (j + 2 < 6)) {

					int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
							+ arr.get(i + 1).get(j + 1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1)
							+ arr.get(i + 2).get(j + 2);

					maxsum = Math.max(sum, maxsum);

				}

			}

		}
		return maxsum;

	}

	/*
	 * Complete the 'dynamicArray' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY queries
	 */

	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		List<Integer> rtList = new ArrayList<Integer>();

		int lastAnswer = 0;

		// initialize Dynamic Array
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < queries.size(); i++) {

			int queryType = queries.get(i).get(0);
			int x = queries.get(i).get(1);
			int y = queries.get(i).get(2);
			if (queryType == 1) {
				int rowIndex = (x ^ lastAnswer) % n;
				list.get(rowIndex).add(y);

			} else {
				int colIndex = 0;
				int rowIndex = (x ^ lastAnswer) % n;
				List<Integer> seq = list.get(rowIndex);
				colIndex = y % seq.size();
				lastAnswer = seq.get(colIndex);
				rtList.add(lastAnswer);

			}

		}

		return rtList;
	}

	/*
	 * Complete the 'rotateLeft' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER d 2. INTEGER_ARRAY arr
	 */
	public static List<Integer> rotateLeft(int d, List<Integer> arr) {

		List<Integer> arr_2 = new ArrayList<Integer>(arr.size());

		for (int i = d; i < arr.size(); i++) {
			arr_2.add(arr.get(i));
		}

		for (int i = 0; i < d; i++) {
			arr_2.add(arr.get(i));
		}

		return arr_2;
	}

	/*
	 * Complete the 'matchingStrings' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. STRING_ARRAY strings 2. STRING_ARRAY queries
	 */

	public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

		List<Integer> noOfOccurances = new ArrayList<Integer>();

		for (String query : queries) {
			int count = 0;
			if (strings.contains(query)) {
				for (String string : strings) {
					if (query.equals(string))
						count++;

				}
			}

			noOfOccurances.add(count);
		}
		return noOfOccurances;

	}

	/*
	 * Complete the 'arrayManipulation' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY queries
	 */

//	public static long arrayManipulation(int n, List<List<Integer>> queries) {
//		long Max = Integer.MIN_VALUE;
//		// Adding first element in array
//		List<Integer> firstelement = null;
//
//		for (int l = 0; l < n; l++) {
//			firstelement.add(0);
//		}
//
//		int m = queries.size();
//
//		for (int i = 0; i < m; i++) {
//
//			for (int l = 0; l < n; l++) {
//				firstelement.add(0);
//			}
//
//			// List<Integer> dynamicElement = new ArrayList<Integer>();
//			for (int j = 0; j < n; j++) {
//
//				int indexVal = j + 1;
//				for (int k = 0; k < m; k++) {
//					List<Integer> query = queries.get(k);
//					int element = firstelement.get(j);
//
//					if (indexVal >= query.get(0) && indexVal <= query.get(1)) {
//
//						Max = Math.max(Max, element + query.get(2));
//						firstelement.set(j, element + query.get(2));
//					}
//
//				}
//
//			}
//			firstelement.clear();
//			firstelement = null;
//			firstelement = new ArrayList<Integer>();
//		}
//
//		return Max;
//	}

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		long Max = Long.MIN_VALUE;

		Integer[] data = new Integer[n];
		Arrays.fill(data, 0);
		List<Integer> totals = Arrays.asList(data);
		int m = queries.size();
		for (int i = 0; i < m; i++) {
			List<Integer> query = queries.get(i);

			int a = query.get(0);
			int b = query.get(1);
			int k = query.get(2);

			int startindex = a - 1;
			int endindex = b - 1;

			totals.set(startindex, totals.get(startindex) + k);
			if (endindex + 1 < totals.size())
				totals.set(endindex + 1, totals.get(endindex + 1) - k);
		}

		long currSum = 0;

		for (long total : totals) {
			currSum += total;
			Max = Math.max(Max, currSum);
		}

		return Max;
	}

	public static void main(String args[]) {

		Integer[][] inputArr = { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } };
		List<List<Integer>> list = Arrays.stream(inputArr).map(Arrays::asList).collect(Collectors.toList());
		// to initilize empty array
		// int n = 2;

		// dynamicArray(2, list);

//		List<Integer> arr = new ArrayList<Integer>();
//		arr.add(1);
//		arr.add(2);
//		arr.add(3);
//		arr.add(4);
//		arr.add(5);

		// List<Integer> arr_1 = rotateLeft(4, arr);

		long maxValue = arrayManipulation(10, list);

		System.out.println(maxValue);

	}

}
