package com.hackerrank.practices;

import java.util.Arrays;

class Solution2 {
	public static int maxProfit(int[] prices) {

		int[] minElePrices = makeDuplicateArray(prices);

		Arrays.sort(minElePrices);

		int indLenght = prices.length - 1;
		int minElement = minElePrices[0];
		int minIndex = findIndex(prices, minElement);

		System.out.println(minIndex);

		int[] remainingElementArr = remainingArr(prices, minIndex);
		Arrays.sort(remainingElementArr);
		// System.out.println(Arrays.toString(remainingElementArr));
		int maxElement = remainingElementArr[remainingElementArr.length - 1];

		int maxIndex = findIndex(prices, maxElement);

		if (maxIndex <= minIndex) {
			return 0;
		}

		else {
			return prices[maxIndex] - prices[minIndex];
		}

	}

	public static int[] makeDuplicateArray(int[] prices) {
		int[] dupArray = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			dupArray[i] = prices[i];
		}
		return dupArray;
	}

	public static int[] remainingArr(int[] prices, int minElementIndex) {
		int len = prices.length;

		int[] remElementArr = new int[len - minElementIndex];

		int i = 0;

		while (minElementIndex < len) {
			remElementArr[i] = prices[minElementIndex];

			i = i + 1;
			minElementIndex = minElementIndex + 1;

		}

		return remElementArr;

	}

	public static int findIndex(int[] prices, int element) {

		if (prices == null) {
			return -1;
		}
		int len = prices.length;
		int i = 0;
		while (i < len) {
			if (prices[i] == element) {
				return i;
			} else {
				i = i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 2,4,1 };

		System.out.println(maxProfit(arr));

	}

}
