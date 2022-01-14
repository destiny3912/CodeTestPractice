package SWExpert11856;

import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

class Solution
{
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		String dump = sc.nextLine();
		String str = null;
		int[] AList = new int[26];
		boolean result = false;
		Set<Character> ASet = new HashSet<>();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			str = null;
			result = false;
			str = sc.nextLine();
			Arrays.fill(AList, 0);
			ASet.clear();
			
			for(int index = 0; index < str.length(); index++)
			{
				ASet.add(str.charAt(index));
				int AIndex = str.charAt(index) - 65;
				AList[AIndex]++;
			}
			
			for(int index = 0; index < 26; index++)
			{
				if(ASet.size() != 2)
				{
					result = false;
					break;
				}
				
				if(AList[index] == 1 || AList[index] > 2)
				{
					result = false;
					break;
				}
				else if(AList[index] == 2)
				{
					result = true;
				}
			}
			
			if(result == true)
			{
				System.out.println("#" + test_case+ " YES");
			}
			else
			{
				System.out.println("#" + test_case+ " NO");
			}
		}
	}
}