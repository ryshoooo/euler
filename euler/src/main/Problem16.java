package main;

public class Problem16 {

	private static int sumFromString(String num) {

		int numLength = num.length();
		int res = 0;

		for (int j = 0; j < numLength; j++) {
			res += Integer.parseInt(num.substring(numLength - (j + 1), numLength - j));
		}

		return res;
	}

	private static String timesTwo(String num) {

		int numLength = num.length();
		String res = "";
		int remain = 0;

		for (int j = 0; j < numLength; j++) {
			int part = Integer.parseInt(num.substring(numLength - (j + 1), numLength - j)) * 2 + remain;
			// System.out.println(part);
			int partLength = ("" + part).length();
			res += ("" + part).substring(partLength - 1, partLength);
			// System.out.println(res);
			String remainder = ("" + part).substring(0, partLength - 1);

			if (remainder.length() == 0) {
				remain = 0;
			} else {
				remain = Integer.parseInt(remainder);
			}
		}

		String finalRemain = "";

		if (remain != 0) {
			finalRemain = finalRemain + remain;
		}

		return main.Problem13.reverse(res + finalRemain);
	}

	public static void main(String[] args) {

		Long numTimes = 1000L;
		String start = "1";

		for (Long iterator = 0L; iterator < numTimes; iterator++) {
			// System.out.println(start);
			start = timesTwo(start);
		}

		// System.out.println(start);
		System.out.println(sumFromString(start));
	}

}
