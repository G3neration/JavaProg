package practice;

public class from31to40 {
	static String textProcessor(int n, int k, String str) {
		String[] words = str.split(" ");
		String result = "";
		int spaceCount = 0;
		for (int i = 0; i < words.length; ++i)
			if (words[i].length() >= 15 || words[i].length() > k || words.length > 100 || words.length < 1
					|| n > words.length)
				return "Check conditions";
		for (int i = 0; i < words.length; ++i) {
			if (i == 0)
				result = words[i];
			if (words[i].length() + result.length() - spaceCount <= k && i != 0) {
				result += " " + words[i];
				spaceCount++;
			} else if (i != 0) {
				System.out.println(result);
				result = words[i];
				spaceCount = 0;
			}
		}
		return result;
	}

	static String split(String str) {
		int balance = 0;
		int prev = 0;
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '(':
				balance++;
				break;
			case ')':
				balance--;
				break;
			default:
				return "Wrong input";
			}
			if (balance == 0) {
				result += str.substring(prev, i + 1) + ", ";
				prev = i + 1;
			}
		}
		return result.substring(0, result.length() - 2);
	}

	static String toCamelCase(String str) {
		String[] words = str.split("_");
		String result = words[0];
		for (int i = 1; i < words.length; i++) {
			char firstLetter = words[i].charAt(0);
			result += Character.toUpperCase(firstLetter) + words[i].substring(1);
		}
		return result;
	}

	static String toSnakeCase(String str) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(chars[i])) {
				chars[i - 1] = '_';
				chars[i] = Character.toLowerCase(chars[i]);
			}
		}
		return new String(chars);
	}

	static String overTime(double startTime, double endTime, double forHour, double overwork) {
		if ((startTime < 9) || (endTime < 9) || (endTime > 24))
			return "Wrong time";
		if (endTime > 17)
			return String.format("%.2f$", forHour * ((17 - startTime) + (endTime - 17) * overwork));
		else
			return String.format("%.2f$", (endTime - startTime) * forHour);
	}

	static String BMI(String weight, String height) {
		double weightInKilos = Double.parseDouble(weight.split(" ")[0]);
		double heightInMeters = Double.parseDouble(height.split(" ")[0]);
		if (weight.split(" ")[1].contains("pound"))
			weightInKilos *= 0.453592;
		if (height.split(" ")[1].contains("inch"))
			heightInMeters *= 0.0254;
		double bmi = weightInKilos / (heightInMeters * heightInMeters);
		if (bmi < 18.5)
			return String.format("%.1f Underweight", bmi);
		else if (bmi < 24.9)
			return String.format("%.1f Normal weight", bmi);
		return String.format("%.1f Overweight", bmi);
	}

	static int bugger(int num) {
		int count = 0;
		while (Integer.toString(num).length() > 1) {
			int inter = num;
			num = 1;
			while (inter > 0) {
				num *= inter % 10;
				inter = inter / 10;
			}
			count++;
		}
		return count;
	}

	static String toStarShorthand(String str) {
		int count = 1;
		String stars = "";
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1))
				count++;
			if (str.charAt(i) != str.charAt(i - 1)) {
				stars += str.charAt(i - 1) + (count == 1 ? "" : "*" + count);
				count = 1;
			}
			if (i == str.length() - 1) {
				stars += str.charAt(i) + (count == 1 ? "" : "*" + count);
			}
		}
		return stars;
	}

	static boolean doesRhyme(String str1, String str2) {
		String lastWord1 = str1.split(" ")[str1.split(" ").length - 1].toLowerCase();
		String lastWord2 = str2.split(" ")[str2.split(" ").length - 1].toLowerCase();
		int vowelCount1 = 0;
		int vowelCount2 = 0;
		for (char c : lastWord1.toCharArray())
			if (c == 'e' || c == 'y' || c == 'u' || c == 'i' || c == 'o' || c == 'a')
				vowelCount1++;
		for (char c : lastWord2.toCharArray())
			if (c == 'e' || c == 'y' || c == 'u' || c == 'i' || c == 'o' || c == 'a')
				vowelCount2++;
		if (vowelCount1 != vowelCount2)
			return false;
		for (char c1 : lastWord1.toCharArray())
			if (c1 == 'e' || c1 == 'y' || c1 == 'u' || c1 == 'i' || c1 == 'o' || c1 == 'a') {
				boolean existsInSecond = false;
				for (char c2 : lastWord2.toCharArray())
					if (c2 == c1) {
						existsInSecond = true;
						break;
					}
				if (!existsInSecond)
					return false;
			}
		return true;
	}

	static boolean trouble(String str1, String str2) {
		char[] num1 = str1.toCharArray();
		char[] num2 = str2.toCharArray();
		for (int i = 0; i < num1.length - 3; i++)
			if (num1[i] == num1[i + 1] && num1[i + 1] == num1[i + 2])
				for (int j = 0; j < num2.length - 2; j++)
					if (num1[i] == num2[j] && num2[j] == num2[j + 1])
						return true;
		return false;
	}

	static int countUniqueBooks(String stringSequence, char bookEnd) {
		char[] chars = stringSequence.toCharArray();
		char[] blackList = new char[stringSequence.length()];
		int unique = 0;
		for (int i = 0; i < chars.length; i++)
			if (chars[i] == bookEnd)
				for (int j = i + 1; j < chars.length; j++) {
					if (j == i + 1 && chars[j] == bookEnd) {
						i = j;
						break;
					}
					if (chars[j + 1] == bookEnd) {
						i = j + 1;
						break;
					}
					for (int k = 0; k < blackList.length; k++) {
						if (blackList[k] == chars[j]) {
							break;
						}
						if (k == chars.length - 1) {
							blackList[unique] = chars[j];
							unique++;
						}
					}
				}
		return unique;
	}
		
		public static void main(String[] args) {
			System.out.println(textProcessor(10, 7, "hello my name is Bessie and this is my essay"));
			System.out.println(split("((()))(())()()(()())"));
			System.out.println(toCamelCase("hello_edabit"));
			System.out.println(toSnakeCase("helloEdabit"));
			System.out.println(overTime(14, 18, 30, 1.8));
			System.out.println(BMI("154 pounds", "2 meters"));
			System.out.println(bugger(39));
			System.out.println(toStarShorthand("abcbbab"));
			System.out.println(doesRhyme("and frequently do?", "you gotta move."));
			System.out.println(trouble("666789", "12345667"));
			System.out.println(countUniqueBooks("RAABBCATWTTA", 'A'));
		}
	}