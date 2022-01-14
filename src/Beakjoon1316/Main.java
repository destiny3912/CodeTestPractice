package Beakjoon1316;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Integer[] aCount = new Integer[26];
		Arrays.fill(aCount, 0);
		int maxNumber = 0, index = 0, count = 0, check = 0;
		String targetWord;
		
		maxNumber = keyboard.nextInt();
		
		while(index < maxNumber)
		{
			targetWord = keyboard.next();
			targetWord = targetWord.substring(0, targetWord.length());
			
			for(int innerIndex = 0; innerIndex < targetWord.length(); innerIndex++)
			{
				if(aCount[targetWord.charAt(innerIndex) - 97] == 0)
				{
					aCount[targetWord.charAt(innerIndex) - 97] = 1;
					while(innerIndex < targetWord.length() - 1)
					{
						if(targetWord.charAt(innerIndex) != targetWord.charAt(innerIndex + 1))
						{
							break;
						}
						
						innerIndex++;
					}
				}
				else
				{
					check = 1;
				}
			}
			
			if(check == 0)
			{
				count++;
			}
			
			index++;
			check = 0;
			Arrays.fill(aCount, 0);
		}
		
		System.out.println(count);
		keyboard.close();
	}
}
