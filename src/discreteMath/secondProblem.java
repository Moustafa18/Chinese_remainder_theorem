package discreteMath;

import java.math.BigInteger;
import java.util.Scanner;

public class secondProblem {
	BigInteger a;
	BigInteger n;

	/**
	 *calculate gcd
	 */
	public BigInteger gcd(BigInteger x, BigInteger y) {
		if (y.equals(new BigInteger("0"))) {
			return x;
		}
		return gcd(y, x.mod(y));

	}
	/**
	 *calculate multiplicative inverse
	 */
	public BigInteger solve(BigInteger a2, BigInteger n2) {
		this.a = a2;
		this.n = n2;
		BigInteger x = new BigInteger("0"), y = new BigInteger("1"), lastx = new BigInteger("1"),
				lasty = new BigInteger("0"), temp;
		while (!n2.equals(new BigInteger("0"))) {
			BigInteger q = a2.divide(n2);
			BigInteger r = a2.mod(n2);

			a2 = n2;
			n2 = r;

			temp = x;
			x = lastx.subtract(q.multiply(x));
			lastx = temp;

			temp = y;
			y = lasty.subtract(q.multiply(y));
			lasty = temp;
		}
		while (lastx.compareTo(new BigInteger("0")) == -1) {
			lastx = lastx.add(this.n);
		}
		return lastx;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		secondProblem ee = new secondProblem();
		while (true) {
			System.out.println("Enter a");
			BigInteger a = scan.nextBigInteger();
			System.out.println("Enter n");
			BigInteger n = scan.nextBigInteger();
			if (!ee.gcd(a, n).equals(new BigInteger("1"))) {
				System.out.println("can't find multiplicative inverse gcd(a,n)!=1");
			} else {
				BigInteger x = ee.solve(a, n);
				System.out.println("the multiplicative inverse of " + a + " mod " + n + " = " + x);
			}

		}
	}
}