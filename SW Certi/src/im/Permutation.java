package im;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permutation(6, 2));
		System.out.println(permutation(5, 2));
		System.out.println(combination(6, 1));
		System.out.println(combination(6, 2));
		System.out.println(factorial(15));
		System.out.println(factorial2(15));
	}

	public static long permutation(int n, int r) {
		if (r == 1) {
			return n;
		}
		return n * permutation(n - 1, r - 1);
	}

	public static long combination(int n, int r) {
		return permutation(n, r) / factorial(r);
	}

	public static long factorial(int n) {
		if (n == 1) {
			return 1;
		}

		return n * factorial(n - 1);
	}

	public static long factorial2(long n) {
		long fact = 1;
		for (long i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
}
