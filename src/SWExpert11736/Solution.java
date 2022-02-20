package SWExpert11736;

import java.util.Scanner;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] numberList = new int[20];
			int maxNumber, basicNumberCount = 0;
			Arrays.fill(numberList, 0);
			
			maxNumber = sc.nextInt();
			
			for(int index = 0; index < maxNumber; index++)
			{
				numberList[index] = sc.nextInt();
			}
			
			for(int index = 2; index < maxNumber; index++)
			{
				boolean condition1 = (numberList[index - 1] < numberList[index] && numberList[index - 1] > numberList[index - 2]);
				boolean condition2 = (numberList[index - 1] > numberList[index] && numberList[index - 1] < numberList[index - 2]);
				
				if(condition1 || condition2)
				{
					basicNumberCount++;
				}
			}
			
			System.out.println("#" + test_case + " " + basicNumberCount);
		}

		sc.close();
	}
}