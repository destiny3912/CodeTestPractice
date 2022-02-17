package Beakjoon2869;

import java.util.StringTokenizer;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String Line = br.readLine();
		StringTokenizer slice = new StringTokenizer(Line, " ");
		int A, B, V;
		
		A = Integer.parseInt(slice.nextToken());
		B = Integer.parseInt(slice.nextToken());
		V = Integer.parseInt(slice.nextToken());
		
		int day = 0;
		
		if(V == A) day = 1;
		else if((A - B) == 1)
		{
			day = V - A + 1;
		}
		else
		{
			if((V-A)%(A - B) == 0) day = (V-A)/(A-B) + 1;
			else day = (V-A)/(A-B) + 2;
		}
		
		System.out.println(day);
	}
}