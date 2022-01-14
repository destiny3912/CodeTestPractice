package Beakjoon10757;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		String temp;
		
		temp = stdin.nextLine();
		String[] tokens = temp.split(" ");
		stdin.close();
		
		BigInteger A = new BigInteger(tokens[0]);
		BigInteger B = new BigInteger(tokens[1]);
		
		System.out.println(addBin(A, B).toString());
	}
	
	public static BigInteger addBin(BigInteger a, BigInteger b)
	{
		if(b == BigInteger.ZERO) return a;
		
		BigInteger sum = a.xor(b);
		BigInteger carry = a.and(b).shiftLeft(1);
		
		return addBin(sum, carry);
	}
}
