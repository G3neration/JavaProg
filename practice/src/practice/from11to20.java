package practice;

public class from11to20 {
	public static string convert(string word, int num) {
		return num*60;
	}
	public static st points(int p2, int p3) {
		return p2*2+p3*3;
	}
	public static int footballPoints(int win, int draw, int lose) {
		return win*3+draw*1+lose*0;
	}
	public static boolean divisibleByFive(int dig) {
		return dig%5==0;
	}
	public static boolean and(boolean a, boolean b) {
		return a&&b;
	}
	public static int howManyWalls(int n, int w, int h) {
		return n/(w*h);
	}
	public static int squared (int nb) {
		return nb*nb;
	}
	public static boolean profitableGamble(double prob, int prize, int pay) {
		return prob*prize>pay;
	}
	public static int frames(int freq, int min) {
		return freq*min*60;
	}
	public static int mod(int x, int y) {
		return x-x/y*y;
	}
	
	public static void main(String[] args) {
		System.out.println(repeat("mice", 5));
		System.out.println(differenceMaxMin([10, 4, 1, 4, -10, -50, 32, 21]));
		System.out.println(isAvgWhole([1, 2, 3, 4]));
		System.out.println(cumulativeSum([3, 3, -2, 408, 3, 3]));
		System.out.println(getDecimalPlaces("400"));
		System.out.println(Fibonacci(12));
		System.out.println(isValid("853a7"));
		System.out.println(isStrangePair("sparkling", "groups"));
		System.out.println(isSuffix("arachnophobia", "-phobia"));
		System.out.println(boxSeq(2));
	}
}