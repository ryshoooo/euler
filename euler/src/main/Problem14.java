package main;

public class Problem14 {

	private static Long nextCollatzTerm(Long n) {
		if (n % 2 == 0) {
			return n / 2;
		} else {
			return 3 * n + 1;
		}
	}

	private static Long getLength(Long from) {

		Long res = 1L;
		Long start = from;

		while (start != 1) {
			start = nextCollatzTerm(start);
			res += 1;
		}

		return res;
	}

	public static void main(String[] args) {

		Long collatzTo = 1000000L;
		Long res = 1L;
		Long solution = 1L;

		for (Long i = 1L; i <= collatzTo; i++) {
			// System.out.println(i);
			Long newRes = getLength(i);
			// System.out.prLongln(newRes);
			if (newRes > res) {
				solution = i;
				res = newRes;
			}
		}
		System.out.println(solution);
	}

}
