package SWExpert13038;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		int T, n;
		int[] a = new int[7];
		int[] classExistIndex = new int[7];
		
		T = Integer.parseInt(stdin.readLine());
		
		for(int index = 0; index < T; index++)
		{
			n = Integer.parseInt(stdin.readLine());
			String s = stdin.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int result = 0, weekClass = 0;
			
			for(int innerIndex = 0; innerIndex < 7; innerIndex++)
			{
				a[innerIndex] = Integer.parseInt(st.nextToken());
				
				if(a[innerIndex] == 1)
				{
					classExistIndex[weekClass] = innerIndex;
					weekClass++;
				}
			}
			
			for(int classIndex = 0; classIndex < weekClass; classIndex++)
			{
				int startIndex = classExistIndex[classIndex];
				int tempResult = 0;
				int tempN = n;
				//���� ù�� �ϼ�
				for(int innerIndex = startIndex; innerIndex < 7; innerIndex++)
				{
					if(a[innerIndex] == 1)
					{
						tempN--;
						tempResult++;
					}
					else
					{
						tempResult++;
					}
					
					if(tempN == 0)break;
				}
				
				startIndex = 0;
				
				if(tempN > 0)
				{
					if(tempN <= weekClass)
					{
						if(tempN != 0)
						{
							int innerIndex = startIndex;
							
							while(!(tempN <= 0))
							{	
								tempResult++;
								if(a[innerIndex] == 1)tempN--;
								
								if(tempN <= 0) break;
								innerIndex++;
							}
						}
					}
					else
					{
						tempResult = tempResult + (7 * ((tempN / weekClass) - 1));
						tempN = tempN - (weekClass *  (tempN / weekClass - 1));
						int leftResult = 0;
						
						if(tempN != 0)
						{
							int innerIndex = 0;
							
							while(!(tempN <= 0))
							{	
								if(a[innerIndex] == 1)tempN--;
								leftResult++;
								
								if(tempN <= 0)break;
								innerIndex++;
								if(innerIndex == 7)innerIndex = 0;
							}
							tempResult = tempResult + leftResult;
						}
					}
				}
				
				if(result > tempResult || result == 0)
				{
					result = tempResult;
				}
			}
			System.out.println("#" + (index + 1) + " " + result);
		}
	}
}