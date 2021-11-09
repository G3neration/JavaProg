package practice;

public class from1to10 {
	public static int convert(int num) {
		return num * 60;
	}

	public static int points(int p2, int p3) {
		return p2 * 2 + p3 * 3;
	}

	public static int footballPoints(int win, int draw, int lose) {
		return win * 3 + draw * 1 + lose * 0;
	}

	public static boolean divisibleByFive(int dig) {
		return dig % 5 == 0;
	}

	public static boolean and(boolean a, boolean b) {
		return a && b;
	}

	public static int howManyWalls(int n, int w, int h) {
		return n / (w * h);
	}

	public static int squared(int nb) {
		return nb * nb;
	}

	public static boolean profitableGamble(double prob, int prize, int pay) {
		return prob * prize > pay;
	}

	public static int frames(int freq, int min) {
		return freq * min * 60;
	}

	public static int mod(int x, int y) {
		return x - x / y * y;
	}

	public static void main(String[] args) {
		System.out.println(convert(5));
		System.out.println(points(10, 13));
		System.out.println(footballPoints(4, 3, 1));
		System.out.println(divisibleByFive(7));
		System.out.println(and(true, true));
		System.out.println(howManyWalls(14, 2, 2));
		System.out.println(squared(4));
		System.out.println(profitableGamble(0.2, 50, 9));
		System.out.println(frames(10, 25));
		System.out.println(mod(6, 4));
	}
}