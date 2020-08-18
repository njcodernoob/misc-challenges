package com.challenges;

public class FibonacciNthNumber {

	static int fib(int n) {
		int matrix[][] = new int[][] { { 1, 1 }, { 1, 0 } };
		if (n == 0)
			return 0;
		power(matrix, n - 1);

		// f[0][0] contains nth term
		return matrix[0][0];
	}

	static void multiply(int matrix1[][], int matrix2[][]) {
		int a = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
		int b = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
		int c = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0];
		int d = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];

		matrix1[0][0] = a;
		matrix1[0][1] = b;
		matrix1[1][0] = c;
		matrix1[1][1] = d;
	}

	static void power(int matrix[][], int n) {
		if (n == 0 || n == 1)
			return;
		int initialMatrix[][] = new int[][] { { 1, 1 }, { 1, 0 } };

		power(matrix, n / 2);
		multiply(matrix, matrix);

		if (n % 2 != 0)
			multiply(matrix, initialMatrix);
	}

	public static void main(String args[]) {
		System.out.println(fib(20));
	}
}
