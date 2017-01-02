package com;

/*
 * For a value 0 in matrix. Covert all the other values in that row or column to 0.
*/

public class ZeroMatrix {

	public static void main(String args[]) {
		int inputMatrix[][] = new int[4][4];

		inputMatrix[0][0] = 1;
		inputMatrix[0][1] = 2;
		inputMatrix[0][2] = 3;
		inputMatrix[0][3] = 4;

		inputMatrix[1][0] = 5;
		inputMatrix[1][1] = 6;
		inputMatrix[1][2] = 7;
		inputMatrix[1][3] = 8;

		inputMatrix[2][0] = 9;
		inputMatrix[2][1] = 10;
		inputMatrix[2][2] = 0;
		inputMatrix[2][3] = 12;

		inputMatrix[3][0] = 13;
		inputMatrix[3][1] = 14;
		inputMatrix[3][2] = 15;
		inputMatrix[3][3] = 16;

		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix.length; j++) {
				System.out.print(inputMatrix[i][j] + " ");
			}
			System.out.println(" ");

		}

		System.out.println(" ");

		int result[][] = zeroMatrix(inputMatrix);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println(" ");
		}
	}


	// time complexity O(MN)
	public static int[][] zeroMatrix(int[][] matrix) {

		int x = -1, y = -1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					x = i;
					y = j;
				}
			}
		}

		if (x >= 0 && y >= 0) {
			for (int a = 0; a < matrix.length; a++) {
				matrix[a][x] = 0;
			}

			for (int b = 0; b < matrix.length; b++) {
				matrix[y][b] = 0;
			}

		}
		return matrix;
	}
}
