package main;

public class Problem12 {

	private static int getNumberOfFactors(int num) {

		int res = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		int over = 500;
		int i = 0;
		int partialSum = 0;
		int res = 0;

		while (res < over) {
			i = i + 1;
			partialSum = partialSum + i;
			// System.out.println(partialSum);
			res = getNumberOfFactors(partialSum) + 1;
			// System.out.println(res);
		}

		System.out.println(partialSum);
		System.out.println(res);
	}
}
