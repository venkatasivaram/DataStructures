package com.hackerrank.practices;

public class Sudoku {

	public static void main(String[] args) {

		int[][] board = { { 8, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
		
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

		System.out.println(searchMatrix(matrix,3));

	}

	public static boolean isValidSudoku(int[][] board) {

		// System.out.println(isValidrow(board));
		// System.out.println(isValidMatrices(board));

		if (isValidrow(board) && isValidMatrices(board))
			return true;
		else
			return false;

	}

	public static boolean isValidMatrices(int[][] board) {
		boolean isValid = true;
		int i = 0;
		int matRow = 0;

		int rowPos = 0;
		int colPos = 0;
		int rlength = 3;
		int clength = 3;
		int r;
		int c;

		int colLength = 9;

		int colLen = 3;
		int rowLen = 3;
		StringBuffer stringBuffer = null;
		while (matRow < 3) {
			stringBuffer = new StringBuffer();
			while (i < rowLen) {
				for (c = colPos; c < colLen; c++) {

					// System.out.println(board[i][c]);
					if (stringBuffer.indexOf(Integer.toString(board[i][c])) == -1 || board[i][c] == 0) {
						stringBuffer.append(board[i][c]);
					} else
						return false;
				}

				i++;
				// System.out.println();
			}

			if (colLen < colLength) {
				colLen = colLen + 3;
				colPos = colPos + 3;
				i = i - 3;
			} else {

				colPos = 0;
				colLen = 0;
				colLen = colLen + 3;
				rowLen = rowLen + 3;
				matRow++;
			}

		}

		return isValid;
	}

	public static boolean isValidrow(int[][] board) {

		for (int i = 0; i < 9; i++) {

			StringBuffer sbRow = new StringBuffer();

			StringBuffer sbColumn = new StringBuffer();
			for (int j = 0; j < 9; j++) {
				if (sbRow.indexOf(Integer.toString(board[i][j])) == -1 || board[i][j] == 0) {
					sbRow.append(board[i][j]);
				} else
					return false;

				if (sbColumn.indexOf(Integer.toString(board[j][i])) == -1 || board[j][i] == 0) {
					sbColumn.append(board[j][i]);
				} else
					return false;
			}
		}

		return true;
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		
		int m=matrix.length;
		int n=matrix[0].length;
	       for (int i = 0; i < m; i++) {

				for (int j = 0; j < n; j++) {
					if ( matrix[i][j] == target) {
						return true;
					} 
				}
			} 
	        return false;
	    }
	
	
}
