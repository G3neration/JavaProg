// Класс позволяет узнать все простые числа от 2 до 100
public class Primes {
	// Метод main используется как точка инициализации и главный метод класса
	public static void main(String[] args) {
		for (int n = 2; n <= 100; n++) {
			if (isPrime(n) == true)
				System.out.println(n);
		}
	}

	// Метод isPrime производит все вычисления для определения простого числа
	public static boolean isPrime(int n) {
		boolean res = true;
		int ost = 0;
		for (int i = 2; i < n; i++) {
			ost = n % i;
			if (ost == 0) {
				res = false;
			}
		}
		return res;
	}
}
