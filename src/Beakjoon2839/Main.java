package Beakjoon2839;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//non-fractional napsack �������� DP�� Ȱ��
		
		int N;
		int result = -1;
		
		Scanner keyboard = new Scanner(System.in);
		
		N = keyboard.nextInt();
		
		keyboard.close();
		
		for(int index = 0; index <= N / 3; index++)
		{
			int leftWeight = N - 3 * index;
			int sackNum = index;
			int check = 0;
			
			if(leftWeight % 5 != 0 || leftWeight == 0)
			{
				if(leftWeight % 5 != 0)
					continue;
				else
				{
					if(result == -1 || result > sackNum)
					{
						result = sackNum;
						check = 1;
					}	
				}
			}
			
			if(check == 0)
				sackNum = sackNum + leftWeight / 5;
				
			if(result == -1 || result > sackNum)
			{
				result = sackNum;
			}
		}
		
		System.out.println(result);
	}
}
