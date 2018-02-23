package discreteMath;

import java.math.BigInteger;
import java.util.Scanner;

public class ThirdProblemPart1 {

	/**
	 * @param number the number which will be transformed
	 * @param mod the m1,m2,m3
	 *@return the represintation array
	 */
	public BigInteger[] chineseReminderTheorem(BigInteger number, BigInteger[] mod) {
		BigInteger[] representation = new BigInteger[mod.length];
		BigInteger M = new BigInteger("1");
		for (int i = 0; i < mod.length; i++) {
			M = M.multiply(mod[i]);
		}
		if (number.compareTo(M) == 1) {
			throw new RuntimeException();
		}
		for (int i = 0; i < representation.length; i++) {
			representation[i] = number.mod(mod[i]);
		}
		return representation;
	}

	public static void main(String[] args) {

		ThirdProblemPart1 t1 = new ThirdProblemPart1();
		ThirdProblemPart2 t2 = new ThirdProblemPart2();
		Scanner sc = new Scanner(System.in);
		String mod[];
		BigInteger[] answer;
		BigInteger number;
		while (true) {
			try {
				System.out.println("please enter the number");
				number = sc.nextBigInteger();
				sc.nextLine();
				System.out.println("please enter a pair wise prime numbers that there multplication = M as 1,2,3");
				mod = sc.nextLine().split(",");
				answer = t1.chineseReminderTheorem(number, t2.toBigIntegerArray(mod));
				System.out.println("Answer is");
				for (int i = 0; i < answer.length; i++) {
					if (i < answer.length - 1) {
						System.out.print(answer[i] + ",");
					} else {
						System.out.println(answer[i]);
					}
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("can't calculate the number");
			}

		}

	}
}
