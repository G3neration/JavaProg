package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class from41to50 {

	public static int[] encrypt(String message) {
		int[] codedMessage = new int[message.length()];
		codedMessage[0] = message.codePointAt(0);
		for (int i = 1; i < message.length(); i++)
			codedMessage[i] = message.codePointAt(i) - message.codePointAt(i - 1);
		return codedMessage;
	}

	public static String decrypt(int[] wInArray) {
		String message = "" + (char) wInArray[0];
		for (int i = 1; i < wInArray.length; i++)
			message += (char) (message.codePointAt(i - 1) + wInArray[i]);
		return message;
	}

	public static boolean canMove(String figure, String fromS, String toS) {
		char[] from = fromS.toLowerCase().toCharArray();
		char[] to = toS.toLowerCase().toCharArray();
		if (from[0] < 'a' || from[0] > 'h' || from[1] < '1' || from[1] > '8')
			return false;
		if (to[0] < 'a' || to[0] > 'h' || to[1] < '1' || to[1] > '8' || from[0] == to[0] && from[1] == to[1])
			return false;
		int distance = (int) (Math.pow(from[0] - to[0], 2) + Math.pow(from[1] - to[1], 2));
		switch (figure) {
		case "Pawn": // Пешка
			if (from[0] == to[0] && to[1] - from[1] == 1)
				return true;
		case "Rook": // Ладья
			if (from[0] == to[0] || from[1] == to[1])
				return true;
		case "Knight": // Конь
			if (distance == 5)
				return true;
		case "Bishop": // Слон
			if (Math.abs(from[0] - to[0]) == Math.abs(from[1] - to[1]))
				return true;
		case "Queen": // Королева
			if (from[0] == to[0] || from[1] == to[1] || Math.abs(from[0] - to[0]) == Math.abs(from[1] - to[1]))
				return true;
		case "King": // Король
			if (distance < 3)
				return true;
		}
		return false;
	}

	public static boolean canComplete(String sInput, String sWord) {
		char[] input = sInput.toCharArray();
		char[] word = sWord.toCharArray();
		int i = 0;
		for (char c : word)
			if (c == input[i]) {
				i++;
			}
		return i == input.length;
	}

	public static int sumDigProd(String str) {
		int inter = 0;
		String[] strNumbers = str.split(", ");
		int[] numbers = new int[strNumbers.length];
		for (int i = 0; i < strNumbers.length; i++)
			numbers[i] = Integer.parseInt(strNumbers[i]);
		for (int i = 0; i < numbers.length; i++)
			inter += numbers[i];
		while (inter > 9) {
			int iter = 1;
			while (inter > 0) {
				iter *= inter % 10;
				inter /= 10;
			}
			inter = iter;
		}
		return inter;
	}

	public static String[] sameVowelGroup(String... strings) {
		String vowels = "";
		ArrayList<String> result = new ArrayList<String>();
		for (char c : strings[0].toCharArray())
			if (c == 'a' || c == 'e' || c == 'u' || c == 'i' || c == 'o' || c == 'y')
				vowels += c;
		m: for (String s : strings) {
			for (char c : vowels.toCharArray())
				if (!s.contains(c + ""))
					continue m;
			result.add(s);
		}
		return result.toArray(new String[0]);
	}

	static boolean validateCard(String n) {
		int check = Integer.parseInt(n.charAt(n.length() - 1) + "");
		String num = n.substring(0, n.length() - 1);
		int[] reversed = new int[num.length()];
		for (int i = 0; i < num.length(); i++)
			reversed[num.length() - i - 1] = Integer.parseInt(num.charAt(i) + "");
		for (int i = 0; i < reversed.length; i += 2) {
			reversed[i] *= 2;
			if (reversed[i] > 9)
				reversed[i] -= 9;
		}
		return (10 - Arrays.stream(reversed).sum() % 10) == check;
	}

	static String numToEng(int n) {
		String[] firstDigit = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] secondDigit1 = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
		String[] secondDigit = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		if (n == 0)
			return "zero";
		else if (n < 10)
			return firstDigit[n];
		else if (n < 20)
			return secondDigit1[n % 10];
		else if (n < 100)
			return secondDigit[n / 10] + " " + firstDigit[n % 10];
		else
			return firstDigit[n / 100] + " hundred " + secondDigit[(n / 10) % 10] + " " + firstDigit[n % 10];
	}

	static String getSha256Hash(String s) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] encodedHash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
			StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
			for (int i = 0; i < encodedHash.length; i++) {
				String hex = Integer.toHexString(0xff & encodedHash[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	static String correctTitle(String title) {
		char[] chars = title.toCharArray();
		String result = "";
		String wordBuffer = "";
		for (int i = 0; i < chars.length; i++) {
			if (Character.isAlphabetic(chars[i]))
				wordBuffer += chars[i];
			else {
				if (!wordBuffer.equals("")) {
					result += (wordBuffer.equalsIgnoreCase("and") || wordBuffer.equalsIgnoreCase("the")
							|| wordBuffer.equalsIgnoreCase("of") || wordBuffer.equalsIgnoreCase("in"))
									? wordBuffer.toLowerCase()
									: wordBuffer.substring(0, 1).toUpperCase() + wordBuffer.substring(1).toLowerCase();
					wordBuffer = "";
				}
				result += chars[i];
			}
		}
		return result;
	}

	static String hexLattice(int n) {
		int valid = 1;
		int size = 2;
		String result = "";
		while (valid < n)
			valid += 6 * (size++ - 1);
		if (valid != n)
			return "Invalid";
		size--;
		for (int i = 0; i < size; i++) {
			result += ("%" + (size - i) + "s").formatted("");
			for (int j = 0; j < size + i; j++)
				result += "o ";
			result += ("%" + (size - i) + "s").formatted("") + "\n";
		}
		for (int i = size - 2; i >= 0; i--) {
			result += ("%" + (size - i) + "s").formatted("");
			for (int j = 0; j < size + i; j++)
				result += "o ";
			result += ("%" + (size - i) + "s").formatted("") + "\n";
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(encrypt("Hello")));
		int[] arrForEx41 = { 72, 33, -73, 84, -12, -3, 13, -13, -68 };
		System.out.println(decrypt(arrForEx41));
		System.out.println(canMove("Bishop", "A7", "G1"));
		System.out.println(canComplete("tulb", "beautiful"));
		System.out.println(sumDigProd("1, 2, 3, 4, 5, 6"));
		System.out.println(Arrays.toString(sameVowelGroup("many", "carriage", "emit", "apricot", "animal")));
		System.out.println(validateCard("1234567890123452"));
		System.out.println(numToEng(157));
		System.out.println(getSha256Hash("Fluffy@home"));
		System.out.println(correctTitle("sansa stark, lady of winterfell."));
		System.out.println(hexLattice(19));
	}
}
