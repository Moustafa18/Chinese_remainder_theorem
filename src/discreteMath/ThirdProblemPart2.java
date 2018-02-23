package discreteMath;

import java.math.BigInteger;
import java.util.Scanner;

public class ThirdProblemPart2 {
	
	secondProblem s = new secondProblem();

	BigInteger solution = new BigInteger("0");
	/**
	 * function to calculate the number in first domain
	 * @param representation the number representation which will be transformed
	 * @param mod the m1,m2,m3
	 *@return the number corresponding to representation
	 */
	public BigInteger chineseReminderTheoremInverse(BigInteger[] representation, BigInteger[] mod) {
		for (int i = 0; i < mod.length; i++) {
			for (int j = i + 1; j < mod.length; j++) {
				if (!s.gcd(mod[i], mod[j]).equals(new BigInteger("1"))) {
					throw new RuntimeException();
				}
			}
		}
		BigInteger M = new BigInteger("1");
		BigInteger mi[] = new BigInteger[mod.length];
		BigInteger yi[] = new BigInteger[mod.length];
		for (int i = 0; i < mod.length; i++) {
			M = M.multiply(mod[i]);
		}
		for (int i = 0; i < mod.length; i++) {
			mi[i] = M.divide(mod[i]);
			yi[i] = s.solve(mi[i], mod[i]);
		}
		for (int i = 0; i < mod.length; i++) {
			solution = solution.add((representation[i].multiply(mi[i])).multiply(yi[i]));
		}
		return solution;
	}
	/**
	 * string array to big integer array
	 *
	 */

	public BigInteger[] toBigIntegerArray(String arr[]) {
		BigInteger array[] = new BigInteger[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i] = new BigInteger(arr[i]);
		}
		return array;

	}

	public static void main(String[] args) {
		ThirdProblemPart2 t = new ThirdProblemPart2();
		Scanner sc = new Scanner(System.in);
		String representation[];
		String mod[];
		BigInteger M = new BigInteger("1");
		BigInteger answer;
		while (true) {
			try {
				System.out.println("please enter representation as 1,2,3");
				representation = sc.nextLine().split(",");
				System.out.println("please enter a pair wise prime numbers that there multplication = M as 1,2,3");
				mod = sc.nextLine().split(",");
				for (int i = 0; i < mod.length; i++) {
					M = M.multiply((new BigInteger(mod[i])));
				}
				long t1 = System.currentTimeMillis();
				answer = t.chineseReminderTheoremInverse(t.toBigIntegerArray(representation), t.toBigIntegerArray(mod));
				long t2 = System.currentTimeMillis();
				System.out.println("t2-t1 ="+(t2-t1));
				System.out.println("the equvilant number is " + answer.mod(M) + " mod " + M);
			} catch (Exception e) {
				System.out.println("can't calculate the number");
			}

		}

	}
}
