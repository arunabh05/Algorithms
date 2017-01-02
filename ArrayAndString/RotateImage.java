package com;


// For a given matrix. Rotate the matrix by 90 degree.

public class RotateImage {

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
		inputMatrix[2][2] = 11;
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

		int result[][] = rotateMatrix2(inputMatrix);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	// rotateMatrix solution
	// time complexity O(n^2)
	// space complexity  --> O(n^2) 
	public static int[][] rotateMatrix2(int matrix[][]) {

		int resultMatrix[][] = new int[matrix.length][matrix[0].length];
		int k = matrix[0].length - 1;

		System.out.println(matrix[0].length - 1);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				resultMatrix[j][k] = matrix[i][j];
			}
			k--;
		}
		return resultMatrix;
	}

	// inital solution
	// doesn't work for all size
	public static int[][] rotateMatrix(int matrix[][]) {
		int resultMatrix[][] = new int[matrix.length][matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				resultMatrix[i][j] = matrix[j][i];
			}
		}

		int temp[] = new int[resultMatrix.length];
		for (int j = 0; j < resultMatrix.length; j++) {
			temp[j] = resultMatrix[0][j];
			resultMatrix[0][j] = resultMatrix[resultMatrix.length - 1][j];
			resultMatrix[resultMatrix.length - 1][j] = temp[j];
		}

		return resultMatrix;
	}
}
