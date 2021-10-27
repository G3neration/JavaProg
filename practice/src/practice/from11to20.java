package practice;

public class from11to20 {
	public static String repeat (String word, int num) {
		String repeatingSymbols = ""; 
		for (int i = 0; i < word.length(); i++)
			for (int m = 0; m < num; m++)
				repeatingSymbols+=word.charAt(i);
		return repeatingSymbols;
	}
	public static int differenceMaxMin (int[] arrayForEx12) {
	int[] MinMax = {arrayForEx12[0], arrayForEx12[0]};
	for (int i = 0; i < arrayForEx12.length; i++)
	{ 	
		if (arrayForEx12[i] < MinMax[0])
				MinMax[0] = arrayForEx12[i];
		else if (arrayForEx12[i] > MinMax[1])
				MinMax[1] = arrayForEx12[i];
	}
	int dif = MinMax[1] - MinMax[0];
	return dif;
}
	public static boolean isAvgWhole (int[] arrayForEx13) {
	double sum = 0;
	for (int i = 0; i < arrayForEx13.length; i++) {
		sum += arrayForEx13[i];
}

	double rez = sum % arrayForEx13.length;
	return rez == 0;
}
	//public static int[] cumulativeSum (int[] arrayForEx14, int [] resultForEx14) {
	//for (int i = 1; i < arrayForEx14.length; i++)
	//resultForEx14[i] += resultForEx14[i-1];
	//return resultForEx14;
	//}
	public static void main(String[] args) {
		System.out.println(repeat("mice", 5));
		int[] arrayForEx12 = {10, 4, 1, 4, -10, -50, 32, 21};
		System.out.println(differenceMaxMin(arrayForEx12));
		int[] arrayForEx13 = {1, 2, 3, 4};
		System.out.println(isAvgWhole(arrayForEx13));
		int [] arrayForEx14 = {3, 3, -2, 408, 3, 3};
		int [] resultForEx14 = new int [6];
		System.out.println(cumulativeSum(arrayForEx14, resultForEx14));
	}
}