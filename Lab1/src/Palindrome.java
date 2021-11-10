public class Palindrome {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String s = args[i];
		}
	}
	public static String reverseString (String s)
	{
		String newS = "";
		for (int i = s.length(); i >= 0; i--)
			newS += s.charAt(i);
		return newS;
	}
}
