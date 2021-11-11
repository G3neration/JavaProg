// Класс позволяет узнать, является ли слово полиндромом
public class Palindrome {
	// Метод main используется как точка инициализации и главный метод класса

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String s = args[i];
			System.out.println(isPalindrome(s));
		}
	}

	// Метод reverseString используется для создание строки, обратной той, что
	// введена в аргумент
	public static String reverseString(String s) {
		String newS = "";
		for (int i = s.length() - 1; i >= 0; i--)
			newS += s.charAt(i);
		return newS;
	}

	// Метод reverseString используется для сравнения нового слова с вводным
	public static boolean isPalindrome(String s) {
		return s.equals(reverseString(s));
	}
}