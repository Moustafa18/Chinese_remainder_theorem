package discreteMath;

import java.math.BigInteger;
import java.util.Scanner;

public class firstProblem {

	
	/**
	 *fast exponentiation binary method
	 */
	public static BigInteger Method3(BigInteger a, BigInteger b, BigInteger c) {
		BigInteger zero = new BigInteger("0");
		BigInteger x = new BigInteger("1");
		BigInteger y = a;
		while (b.compareTo(zero) == 1) {
			if (b.mod(new BigInteger("2")).equals(new BigInteger("1"))) {
				x = (x.multiply(y)).mod(c);
			}
			y = (y.multiply(y)).mod(c); // squaring the base
			b = b.divide(new BigInteger("2"));
		}
		return x.mod(c);
	}
	/**
	 *another implementation of binary method
	 */
	
	public static BigInteger Method3AnotherImplementation(BigInteger a, BigInteger b, BigInteger n) {
		String str = b.toString(2);
		BigInteger res = a;
		res = a.mod(n);
		int exp = 1;

		for (long i = 2; i <= str.length(); i++) {
			if (Long.valueOf(str.substring(0, (int) i), 2) == exp * 2) {

				System.out.println(Long.valueOf(str.substring(0, (int) i), 2));
				exp = exp * 2;
				res = (res.multiply(res).mod(n));

			} else {
				exp = exp * 2 + 1;
				res = (res.multiply(res).multiply(a)).mod(n);
			}

		}
		return res;
	}
	/**
	 *first method
	 */
	public static BigInteger Method1(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger mul = new BigInteger("1");
		for (BigInteger i = new BigInteger("0"); i.compareTo(b) == -1; i = i.add(new BigInteger("1"))) {
			mul = mul.multiply(a);
		}
		mul = mul.mod(n);
		return mul;
	}
	/**
	 *second method
	 */

	public static BigInteger Method2(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger mul = new BigInteger("1");
		for (BigInteger i = new BigInteger("0"); i.compareTo(b) == -1; i = i.add(new BigInteger("1"))) {
			mul = mul.multiply(a);
			mul = mul.mod(n);
		}
		return mul;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("please enter a");
			BigInteger a = new BigInteger(sc.nextLine());
			System.out.println("please enter b");
			BigInteger b = new BigInteger(sc.nextLine());
			System.out.println("please enter n");
			BigInteger n = new BigInteger(sc.nextLine());
			long x = System.currentTimeMillis();
			System.out.println("Method3   " + Method3(a, b, n));
			long y = System.currentTimeMillis();
			System.out.println("Method 3 time " + (y - x) + " ms");
			System.out.println("Method2   " + Method2(a, b, n));
			long z = System.currentTimeMillis();
			System.out.println("Method 2 time " + (z - y) + " ms");
			System.out.println("Method1   " + Method1(a, b, n));
			long end = System.currentTimeMillis();
			System.out.println("Method 1 time " + (end - z) + " ms");

		}
	}
}
