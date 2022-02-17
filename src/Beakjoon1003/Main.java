package Beakjoon1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static class dp
	{
		int flag = -1;
		int one = 0;
		int zero = 0;
	}
	
	static dp[] arr = new dp[41];
	
	private static dp fibo(int n)
	{
		if(n == 0)
		{
			if(arr[0].flag == -1)
			{
				arr[0].flag = 0;
				arr[0].zero = 1;
				arr[0].one = 0;
			}
			return arr[0];
		}
		else if(n == 1)
		{
			if(arr[1].flag == -1)
			{
				arr[1].flag = 1;
				arr[1].one = 1;
				arr[1].zero = 0;
			}
			return arr[1];
		}
		else
		{
			dp temp1, temp2;
			
			if(arr[n].flag == -1)
			{
				if(arr[n-1].flag == -1)
				{
					arr[n-1] = fibo(n-1);
				}
				temp1 = arr[n-1];
				
				if(arr[n-2].flag == -1)
				{
					arr[n-2] = fibo(n-2);
				}
				temp2 = arr[n-2];
					
				arr[n].flag = temp1.flag + temp2.flag;
				arr[n].zero = temp1.zero + temp2.zero;
				arr[n].one = temp1.one + temp2.one;
			}
			
			return arr[n];
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(stdin.readLine());
		
		for(int index = 0; index < arr.length; index++)
		{
			arr[index] = new dp();
		}
		
		for(int index = 0; index < T; index++)
		{
			int n = Integer.parseInt(stdin.readLine());
			
			dp temp = fibo(n);
			
			System.out.println(temp.zero + " " + temp.one);
		}
	}
}