package Beakjoon2941;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String word;
		int index = 0, count = 0;
		
		word = keyboard.nextLine();
		keyboard.close();
		
		while(index < word.length())
		{
			if(word.length() - 1 > index && word.substring(index, index + 2).equals("c="))
			{
				index = index + 2;
				count++;
			}
			else if(word.length() - 1 > index && word.substring(index, index + 2).equals("c-"))
			{
				index = index + 2;
				count++;
			}
			else if(word.length() - 1 > index && word.substring(index, index + 2).equals("d-"))
			{
				index = index + 2;
				count++;
			}
			else if(word.length() - 1 > index && word.substring(index, index + 2).equals("lj"))
			{
				index = index + 2;
				count++;
			}
			else if(word.length() - 1 > index && word.substring(index, index + 2).equals("nj"))
			{
				index = index + 2;
				count++;
			}
			else if(word.length() - 1 > index && word.substring(index, index + 2).equals("s="))
			{
				index = index + 2;
				count++;
			}
			else if(word.length() - 1 > index && word.substring(index, index + 2).equals("z="))
			{
				index = index + 2;
				count++;
			}
			else if(word.length() - 2 > index && word.substring(index, index + 3).equals("dz="))
			{
				index = index + 3;
				count++;
			}
			else
			{
				index++;
				count++;
			}
		}
		
		System.out.println(count);
	}
}