package practice;

import java.util.Arrays;

public class from11to20 {
	public static String repeat(String word, int num) {
		String repeatingSymbols = "";
		for (int i = 0; i < word.length(); i++)
			for (int m = 0; m < num; m++)
				repeatingSymbols += word.charAt(i);
		return repeatingSymbols;
	}

	public static int differenceMaxMin(int[] arrayForEx12) {
		int[] MinMax = { arrayForEx12[0], arrayForEx12[0] };
		for (int i = 0; i < arrayForEx12.length; i++) {
			if (arrayForEx12[i] < MinMax[0])
				MinMax[0] = arrayForEx12[i];
			else if (arrayForEx12[i] > MinMax[1])
				MinMax[1] = arrayForEx12[i];
		}
		int dif = MinMax[1] - MinMax[0];
		return dif;
	}

	public static boolean isAvgWhole(int[] arrayForEx13) {
		double sum = 0;
		for (int i = 0; i < arrayForEx13.length; i++) {
			sum += arrayForEx13[i];
		}

		double rez = sum % arrayForEx13.length;
		return rez == 0;
	}

	public static int[] cumulativeSum(int[] arrayForEx14) {
		int[] resultForEx14 = new int[6];
		for (int i = 0; i < arrayForEx14.length; i++) {
			if (i == 0)
				resultForEx14[i] = arrayForEx14[i];
			else
				resultForEx14[i] = resultForEx14[i - 1] + arrayForEx14[i];
		}
		return resultForEx14;
	}

	public static int getDecimalPlaces(String theNumber) {
		if (theNumber.split("\\.").length == 1)
			return 0;
		return theNumber.split("\\.")[1].length();
	}

	public static int Fibonacci(int Fibo) {
		int fZero = 0;
		int fFirst = 1;
		int fNext = 0;
		for (int i = 2; i <= Fibo + 1; i++) {
			fNext = fZero + fFirst;
			fZero = fFirst;
			fFirst = fNext;
		}
		return fNext;
	}

	public static boolean isValid(String index) {
		if (index.length() == 5 && !index.contains(" "))
			return index.matches("\\d+");
		return false;
	}

	static boolean isStrangePair(String first, String second) {
		if (second.length() == 0 || first.length() == 0) {
			return true;
		} else
			return first.charAt(0) == second.charAt(second.length() - 1)
					&& first.charAt(first.length() - 1) == second.charAt(0);
	}

	static boolean isPrefix(String word, String prefix) {
		return word.startsWith(word.substring(0, prefix.length() - 1));
	}

	static boolean isSuffix(String word, String suffix) {
		return word.endsWith(suffix.substring(1, suffix.length()));
	}

	static int boxSeq(int step) {
		int howMany = 0;
		if (step == 0) {
			return howMany;
		} else
			for (int i = 1; i <= step; i++) {
				if (i % 2 == 1)
					howMany += 3;
				else
					howMany -= 1;
			}
		return howMany;
	}

	public static void main(String[] args) {
		System.out.println(repeat("mice", 5));
		int[] arrayForEx12 = { 10, 4, 1, 4, -10, -50, 32, 21 };
		System.out.println(differenceMaxMin(arrayForEx12));
		int[] arrayForEx13 = { 1, 2, 3, 4 };
		System.out.println(isAvgWhole(arrayForEx13));
		int[] arrayForEx14 = { 3, 3, -2, 408, 3, 3 };
		System.out.println(Arrays.toString(cumulativeSum(arrayForEx14)));
		System.out.println(getDecimalPlaces("43"));
		System.out.println(Fibonacci(12));
		System.out.println(isValid("55520"));
		System.out.println(isStrangePair("sparkling", ""));
		System.out.println(isPrefix("automation", "auto-"));
		System.out.println(isSuffix("vocation", "-logy"));
		System.out.println(boxSeq(3));
	}
}