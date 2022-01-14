package Beakjoon2775;

import java.util.Scanner;

public class Main {
	
	public int Number(int k, int n)
	{
		int result = 0;
		
		if(k == 0)
		{
			return n;
		}
		else
		{
			for(int i = 0; i < n; i++)
			{
				result = result + Number(k - 1, i + 1);
			}
			
			return result;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		int T, k, n;
		Scanner keyboard = new Scanner(System.in);
		Main main = new Main();
		
		T = keyboard.nextInt();
		
		for(int index = 0; index < T; index++)
		{
			k = keyboard.nextInt();
			n = keyboard.nextInt();
			
			System.out.println(main.Number(k,n));
		}
		
		keyboard.close();
	}

}
