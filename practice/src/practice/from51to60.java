package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class from51to60 {
	static int bell(int n) {
		int[][] bellSubset = new int[n + 1][n + 1];
		bellSubset[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			bellSubset[i][0] = bellSubset[i - 1][i - 1];
			for (int j = 1; j <= i; j++) {
				bellSubset[i][j] = bellSubset[i - 1][j - 1] + bellSubset[i][j - 1];
			}
		}
		return bellSubset[n][0];
	}

	static String translateWord(String word) {
		if (word.equals("")) {
			return "";
		}
		String vowels = "aeyuioAEYUIO";
		if (vowels.contains(word.charAt(0) + "")) {
			word += "yay";
		} else {
			for (int i = 0; i < word.length(); i++) {
				if (vowels.contains(word.charAt(i) + "")) {
					word = word.substring(i) + word.substring(0, i) + "ay";
					break;
				}
			}
		}
		return word;
	}

	static String translateSentence(String sen) {
		char[] chars = sen.toCharArray();
		String word = "";
		String result = "";
		for (char c : chars) {
			if (Character.isAlphabetic(c))
				word += c;
			else {
				if (word.length() != 0) {
					if (Character.isUpperCase(word.charAt(0)))
						result += (translateWord(word).charAt(0) + "").toUpperCase()
								+ translateWord(word).substring(1).toLowerCase();
					else
						result += translateWord(word);
					word = "";
				}
				result += c;
			}
		}
		return result;
	}

	static boolean validColor(String str) {
		int i = str.indexOf("(");
		String[] split = str.substring(i + 1, str.length() - 1).split(",");
		if (str.substring(0, i).equals("rgb") && split.length == 3) {
			for (int j = 0; j < split.length; j++) {
				if (Integer.parseInt(split[j]) < 0 || Integer.parseInt(split[j]) > 255) {
					return false;
				}
			}
			return true;
		}
		if (str.substring(0, i).equals("rgba") && split.length == 4) {
			if (Double.parseDouble(split[split.length - 1]) < 0 || Double.parseDouble(split[split.length - 1]) > 1) {
				return false;
			}
			for (int j = 0; j < split.length - 1; j++) {
				if (Integer.parseInt(split[j]) < 0 || Integer.parseInt(split[j]) > 255) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	static String[] getHashTags(String header) {
		header = header.toLowerCase();
		String[] str;
		String inter = "";
		str = header.split(" ");
		for (int i = 0; i < str.length; i++) {
			if (str[i].matches("[a-z0-9]*[!,\\.?:;]+"))
				str[i] = str[i].substring(0, str[i].length() - 1);
		}
		for (int i = 0; i < str.length; i++)
			if (str[i].matches("[a-z0-9]+") == false)
				str[i] = "";
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < str.length - 1; i++) {
				if (str[i].length() < str[i + 1].length()) {
					isSorted = false;
					inter = str[i];
					str[i] = str[i + 1];
					str[i + 1] = inter;

				}
			}
		}
		String[] result;
		switch (str.length) {
		case 1:
			result = Arrays.copyOfRange(str, 0, 1);
			result[0] = "#" + result[0];
			return result;
		case 2:
			result = Arrays.copyOfRange(str, 0, 2);
			for (int i = 0; i < result.length; i++)
				result[i] = "#" + result[i];
			return result;
		default:
			result = Arrays.copyOfRange(str, 0, 3);
			for (int i = 0; i < result.length; i++)
				result[i] = "#" + result[i];
			return result;
		}

	}

	static String stripUrlParams(String url, String... paramsToStrip) {
		String str = "";
		if (!url.contains("?"))
			return url;
		else {
			str = url.substring(url.indexOf("?") + 1);
			url = url.substring(0, url.indexOf("?") + 1);
		}
		char[] params = str.toCharArray();
		StringBuilder print = new StringBuilder();
		for (char c : params) {
			if (Character.isLetter(c))
				if (!(print.toString().contains(String.valueOf(c)))) {
					if (paramsToStrip.length > 0) {
						for (String arg : paramsToStrip) {
							if (!(arg.contains(String.valueOf(c))))
								print.append(str, str.lastIndexOf(c), str.lastIndexOf(c) + 3).append("&");
						}
					} else
						print.append(str, str.lastIndexOf(c), str.lastIndexOf(c) + 3).append("&");
				}
		}
		return url + print.substring(0, print.length() - 1);
	}

	static int ulam(int n) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);

		for (int i = 3; arr.size() < n; i++) {
			int count = 0;
			m: for (int j = 0; j < arr.size() - 1; j++)
				for (int k = j + 1; k < arr.size(); k++) {
					if (arr.get(j) + arr.get(k) == i)
						count++;
					if (count > 1)
						break m;
				}
			if (count == 1)
				arr.add(i);

		}
		return arr.get(arr.size() - 1);
	}

	public static String longestNonRepeatingSubstring(String str) {
		int n = str.length();
		String result = "";

		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
				if (areDistinct(str, i, j))
					if (result.length() < str.substring(i, j + 1).length()) {
						result = str.substring(i, j + 1);
					}

		return result;
	}

	public static Boolean areDistinct(String str, int i, int j) {
		boolean[] visited = new boolean[26];

		for (int k = i; k <= j; k++) {
			if (visited[str.charAt(k) - 'a'])
				return false;

			visited[str.charAt(k) - 'a'] = true;
		}
		return true;
	}

	static String convertToRoman(int n) {
		String result = "";
		char[][] dict = { { 'X', 'V', 'I' }, { 'C', 'L', 'X' }, { 'M', 'D', 'C' }, { ' ', ' ', 'M' } };

		for (int digit = 3; digit >= 0; digit--) {
			int currentDigit = (n / (int) Math.pow(10, digit) == 0) ? 0
					: Integer.parseInt("" + new StringBuffer(n + "").reverse().charAt(digit));
			switch (currentDigit) {
			case 0:
			case 1:
			case 2:
			case 3:
				for (int i = 0; i < currentDigit; i++)
					result += dict[digit][2];
				break;
			case 4:
				result += dict[digit][2] + "" + dict[digit][1];
				break;
			case 5:
			case 6:
			case 7:
			case 8:
				result += dict[digit][1];
				for (int i = 5; i < currentDigit; i++)
					result += dict[digit][2];
				break;
			case 9:
				result += dict[digit][2] + "" + dict[digit][0];
				break;
			}
		}
		return result;
	}

	static boolean formula(String str) {
		String[] exprs = str.split(" ");
		int[] result = new int[str.split("=").length];
		int m = 0;
		if (!Character.isDigit(exprs[0].charAt(0)))
			return false;
		else
			result[m] = Integer.parseInt(exprs[0]);
		;
		for (int i = 0; i < exprs.length; i++) {
			switch (exprs[i]) {
			case "+":
				result[m] += Integer.parseInt(exprs[i + 1]);
				break;
			case "-":
				result[m] -= Integer.parseInt(exprs[i + 1]);
				break;
			case "*":
				result[m] *= Integer.parseInt(exprs[i + 1]);
				break;
			case "/":
				result[m] /= Integer.parseInt(exprs[i + 1]);
				break;
			case "=":
				m++;
				result[m] = Integer.parseInt(exprs[i + 1]);
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			if (result[i] != result[i + 1]) {
				return false;
			}
		}
		return true;
	}

	static boolean palindromeDescendant(int n) {
		String number = "" + n;
		while (number.length() >= 2) {
			boolean isPalindrome = true;
			for (int i = 0; i < number.length() / 2; i++)
				if (number.charAt(i) != number.charAt(number.length() - 1 - i))
					isPalindrome = false;
			if (isPalindrome)
				return true;
			String children = "";
			for (int i = 0; i < number.length(); i += 2)
				children += ""
						+ (Integer.parseInt(number.charAt(i) + "") + Integer.parseInt(number.charAt(i + 1) + ""));
			number = children;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(bell(3));
		System.out.println(translateWord("button"));
		System.out.println(translateSentence("I like to eat honey waffles."));
		System.out.println(validColor("rgba(124,15,256,0.123456789)"));
		System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", "b"));
		System.out.println(Arrays.toString(getHashTags("How the Avocado Became the Fruit of the Global Trade")));
		System.out.println(ulam(9));
		System.out.println(longestNonRepeatingSubstring("abcabcbb"));
		System.out.println(convertToRoman(1459));
		System.out.println(formula("16 * 10 = 160 = 14 + 120"));
		System.out.println(palindromeDescendant(23336014));
	}
}