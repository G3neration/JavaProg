package practice;

public class from21to30 {
	public static int solutions(double a, double b, double c) {
		double d = Math.pow(b, 2) - 4 * a * c;
		int sol;
		if (d == 0)
			sol = 1;
		else if (d > 0)
			sol = 2;
		else
			sol = 0;
		return sol;
	}

	public static int findZip(String strForEx22) {
		if (strForEx22.indexOf("zip") == strForEx22.lastIndexOf("zip"))
			return -1;
		return strForEx22.indexOf("zip", strForEx22.indexOf("zip") + 1);
	}

	public static boolean checkPerfect(int number) {
		int check = 0;
		for (int i = 1; i < number; i++)
			if (number % i == 0)
				check += i;
		return check == number;
	}

	public static String flipEndChars(String strForEx24) {
		if (strForEx24.length() < 2)
			return "Incompatible.";
		else if (strForEx24.charAt(0) == strForEx24.charAt(strForEx24.length() - 1))
			return "Two's a pair.";
		else
			return strForEx24.charAt(strForEx24.length() - 1) + strForEx24.substring(1, strForEx24.length() - 2)
					+ strForEx24.charAt(0);
	}

	public static boolean isValidHexCode(String strForEx25) {
		int count = 0;
		if ((strForEx25.charAt(0) != '#') || (strForEx25.length() != 7))
			return false;
		else {
			for (int i = 0; i < strForEx25.length(); i++) {
				if ((Character.isDigit(strForEx25.charAt(i)) == true)
						|| ((Character.toUpperCase(strForEx25.charAt(i)) >= 'A'
								&& Character.toUpperCase(strForEx25.charAt(i)) <= 'F')))
					count += 1;
			}
			return count == 6;
		}
	}

	public static boolean same(int[] arr1, int[] arr2) {
		int repeatOfArr1 = 0;
		int repeatOfArr2 = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i + 1; j < arr1.length; j++) {
				if (arr1[j] == arr1[i]) {
					repeatOfArr1++;
					break;
				}
			}
		}
		int uniqueOfArr1 = arr1.length - repeatOfArr1;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = i + 1; j < arr2.length; j++) {
				if (arr2[j] == arr2[i]) {
					repeatOfArr2++;
					break;
				}
			}
		}
		int uniqueOfArr2 = arr2.length - repeatOfArr2;
		return uniqueOfArr1 == uniqueOfArr2;
	}

	public static boolean isKaprekar(int numForEx27) {
		int inter = numForEx27 * numForEx27;
		String sInter = Integer.toString(inter);
		String subInter1;
		String subInter2;
		if (sInter.length() == 1) {
			subInter1 = "0";
			subInter2 = sInter.substring(0);
		} else {
			subInter1 = sInter.substring(0, sInter.length() / 2);
			subInter2 = sInter.substring(sInter.length() / 2, sInter.length());
		}
		return Integer.parseInt(subInter1) + Integer.parseInt(subInter2) == numForEx27;
	}

	public static String longestZero(String sequence) {
		int longestLength = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if ((sequence.charAt(i) == '1') || (sequence.charAt(i) == '0')) {
				for (int j = 0; j < sequence.length(); j++)
					if (sequence.charAt(j) == '0') {
						int t = 0;
						while (j < sequence.length() && sequence.charAt(j) == '0') {
							t++;
							j++;
						}
						if (t > longestLength)
							longestLength = t;
					}
			} else
				return "Check your input";
		}
		String result = "";
		for (int j = 0; j < longestLength; j++)
			result += "0";
		return result;
	}

	static public int nextPrime(int numForEx28) {
		int ost = 1;
		if (numForEx28 <= 2)
			return 2;
		else
			for (int j = numForEx28; j < Integer.MAX_VALUE; j++) {
				boolean res = true;
				for (int k = 2; k < j; k++) {
					ost = j % k;
					if (ost == 0) {
						res = false;
					}
				}
				if (res == true)
					return j;
			}
		return 312; // Leet version of Err
	}

	public static boolean rightTriangle(int aSide, int bSide, int cSide) {
		return (aSide * aSide + bSide * bSide == cSide * cSide || bSide * bSide + cSide * cSide == aSide * aSide
				|| aSide * aSide + cSide * cSide == bSide * bSide);
	}

	public static void main(String[] args) {
		System.out.println(solutions(1, 0, 0));
		System.out.println(findZip("all zip files are zipped"));
		System.out.println(checkPerfect(496));
		System.out.println(flipEndChars("Cat, dog, and mouse."));
		System.out.println(isValidHexCode("#4166aF"));
		int[] arr1 = { 3, 3, -2, 408, 3, -3 };
		int[] arr2 = { 1, 2, 3, 4 };
		System.out.println(same(arr1, arr2));
		System.out.println(isKaprekar(297));
		System.out.println(longestZero("00111000011"));
		System.out.println(nextPrime(88));
		System.out.println(rightTriangle(145, 105, 100));
	}
}