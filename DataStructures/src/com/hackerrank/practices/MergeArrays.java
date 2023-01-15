package com.hackerrank.practices;

import java.util.LinkedList;
import java.util.Queue;

public class MergeArrays {

	public static void main(String args[]) {

		int[][] mat = { { 1, 2 }, { 3, 4 } };

		System.out.println(mat.length);
		System.out.println(mat[0].length);

		matrixReshape(mat, 1, 4);

	}

	public static int[][] matrixReshape(int[][] mat, int r, int c) {
		int[][] res = new int[r][c];
		if (mat.length == 0 || r * c != mat.length * mat[0].length)
			return mat;
		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				queue.add(mat[i][j]);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[i][j] = queue.remove();
			}
		}
		return res;
	}

}
