package SWExpert12368;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) 
		{
			int A, B;
			
			A = sc.nextInt();
			B = sc.nextInt();
			
			
			System.out.println("#" + test_case + " " + (A + B) % 24);
		}
		sc.close();
	}
}