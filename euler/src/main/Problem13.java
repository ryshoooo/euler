package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problem13 {

	private static String[] readInputFile(String fPath) {
		try {
			File file = new File(fPath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			int ind = 0;
			String[] rawRows = new String[1000];

			while ((line = bufferedReader.readLine()) != null) {
				rawRows[ind] = line;
				ind++;
			}
			fileReader.close();

			String[] stringRes = new String[ind];

			for (int j = 0; j < ind; j++) {
				stringRes[j] = rawRows[j];
			}

			return stringRes;
		} catch (IOException e) {
			e.printStackTrace();
			return new String[0];
		}
	}

	public static String reverse(String input) {

		String res = "";

		for (int j = 0; j < input.length(); j++) {
			res += input.substring(input.length() - (j + 1), input.length() - j);
		}

		return res;
	}

	public static void main(String[] args) {

		String fpath = "/Users/richardnemeth/git/euler/euler/src/files/prob13.txt";

		String[] inputNumbers = readInputFile(fpath);
		// int[] test = new int[inputNumbers.length];

		int sum = 0;
		String res = "";
		for (int j = 0; j < inputNumbers[0].length(); j++) {
			for (int i = 0; i < inputNumbers.length; i++) {
				String fullNumber = inputNumbers[i];
				// System.out.println(fullNumber);
				int num = Integer
						.parseInt(fullNumber.substring(fullNumber.length() - (j + 1), fullNumber.length() - j));
				// System.out.println(test[i]);
				sum += num;
				// System.out.println(sum);
			}
			String sumString = Integer.toString(sum);
			res += sumString.substring(sumString.length() - 1, sumString.length());
			sum = Integer.parseInt(sumString.substring(0, sumString.length() - 1));
		}
		res += sum;
		System.out.println(reverse(res).substring(0, 10));
	}
}
