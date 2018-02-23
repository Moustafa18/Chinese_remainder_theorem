package discreteMath;

import java.math.BigInteger;
import java.util.Scanner;

public class AdditionMultiplication {

	private static ThirdProblemPart1 x = new ThirdProblemPart1();
	private static ThirdProblemPart2 y = new ThirdProblemPart2();
	private static String[] str;
	private static BigInteger n1;
	private static BigInteger n2;
	private static BigInteger[] arr;
	private static BigInteger n1Arr[];
	private static BigInteger n2Arr[];
	private static BigInteger additionResult[];
	private static BigInteger multiplyResult[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter x");
		n1 = sc.nextBigInteger();
		System.out.println("enter number y");
		n2 = sc.nextBigInteger();
		sc.nextLine();
		System.out.println("enter m1,m2,m3,...");
		str = sc.nextLine().split(",");
		arr = y.toBigIntegerArray(str);
		n1Arr = x.chineseReminderTheorem(n1, arr);
		n2Arr = x.chineseReminderTheorem(n2, arr);
		additionResult = new BigInteger[n1Arr.length];
		multiplyResult = new BigInteger[n1Arr.length];
		long t1 = System.currentTimeMillis();
		n1.add(n2);
		long t2 = System.currentTimeMillis();
		for (int i = 0; i < n1Arr.length; i++) {
			additionResult[i] = n1Arr[i].add(n2Arr[i]);
		}
		y.chineseReminderTheoremInverse(additionResult, arr);
		long t3 = System.currentTimeMillis();
		System.out.println("Multpily1 =" + n1.multiply(n2));
		long t4 = System.currentTimeMillis();
		for (int i = 0; i < n1Arr.length; i++) {
			multiplyResult[i] = n1Arr[i].multiply(n2Arr[i]);
		}
		y.chineseReminderTheoremInverse(multiplyResult, arr);
		long t5 = System.currentTimeMillis();
		System.out.println("Addition 1 time =" + (t2 - t1));
		System.out.println("Addition 2 time =" + (t3 - t2));
		System.out.println("multiply 1 time =" + (t4 - t3));
		System.out.println("multiply 2 time =" + (t5 - t4));

	}

}
