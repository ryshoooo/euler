package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem11 {

	private static int[][] readMatrixFromFile(String fPath) {
		try {
			File file = new File(fPath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			int ind = 0;
			String[] rawRows = new String[100];

			while ((line = bufferedReader.readLine()) != null) {
				rawRows[ind] = line;
				ind++;
			}
			fileReader.close();

			String[] stringRes = new String[ind];

			for (int j = 0; j < ind; j++) {
				stringRes[j] = rawRows[j];
			}

			int[][] res = new int[stringRes.length][stringRes[0].split(" ").length];

			for (int i = 0; i < stringRes.length; i++) {
				String[] row = stringRes[i].split(" ");
				for (int j = 0; j < row.length; j++) {
					res[i][j] = Integer.parseInt(row[j]);
				}
			}

			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return new int[0][0];
		}
	}

	private static int getMaxFromRows(int[][] matrix) {
		int res = 0;

		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[i];
			for (int j = 0; j < row.length - 3; j++) {
				int newRes = row[j] * row[j + 1] * row[j + 2] * row[j + 3];
				if (newRes > res) {
					res = newRes;
				}
			}
		}
		return res;
	}

	private static int[][] transpose(int[][] matrix) {
		int[][] transposedMatrix = new int[20][20];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				transposedMatrix[j][i] = matrix[i][j];
			}
		}

		return transposedMatrix;
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}

	private static int getMaxFromDiag(int[][] matrix) {
		int res = 0;
		int newRes;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				try {
					newRes = matrix[i][j] * matrix[i + 1][j + 1] * matrix[i + 2][j + 2] * matrix[i + 3][j + 3];
					if (newRes > res) {
						res = newRes;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}

		return res;
	}

	private static int getMaxFromCoDiag(int[][] matrix) {
		int res = 0;
		int newRes;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				try {
					newRes = matrix[i][j] * matrix[i + 1][j - 1] * matrix[i + 2][j - 2] * matrix[i + 3][j - 3];
					if (newRes > res) {
						res = newRes;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}

		return res;
	}

	private static int max(int[] arr) {
		int res = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > res) {
				res = arr[i];
			}
		}

		return res;
	}

	public static void main(String[] args) {

		String fPath = "/Users/richardnemeth/workspace/euler/src/files/prob11.txt";
		int[][] intMatrix = readMatrixFromFile(fPath);
		int maxR = getMaxFromRows(intMatrix);
		int maxC = getMaxFromRows(transpose(intMatrix));
		int maxD = getMaxFromDiag(intMatrix);
		int maxCD = getMaxFromCoDiag(intMatrix);

		int[] maxima = { maxR, maxC, maxD, maxCD };

		System.out.println(max(maxima));
	}
}
