// ����� ��������� ������ ��� ������� ����� �� 2 �� 100
public class Primes {
	// ����� main ������������ ��� ����� ������������� � ������� ����� ������
	public static void main(String[] args) {
		for (int n = 2; n <= 100; n++) {
			if (isPrime(n) == true)
				System.out.println(n);
		}
	}

	// ����� isPrime ���������� ��� ���������� ��� ����������� �������� �����
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
