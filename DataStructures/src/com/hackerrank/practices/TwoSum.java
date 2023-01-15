package com.hackerrank.practices;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 3, 2, 4 };
		int target = 6;
		int[] indicesArr = new int[2];

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					indicesArr[0] = i;
					indicesArr[1] = j;
					break;
				}

			}
		}

		System.out.println(indicesArr[0] + " " + indicesArr[1]);
	}

}
