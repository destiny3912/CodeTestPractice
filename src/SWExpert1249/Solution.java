package SWExpert1249;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 0;
		
		T = Integer.parseInt(stdin.readLine());
		
		while(T > 0)
		{
			int mapSize;
			mapSize = Integer.parseInt(stdin.readLine());
			int[][] map = new int[mapSize][mapSize];
			
			for(int out = 0; out < mapSize; out++)
			{
				String mapString;
				mapString = stdin.readLine();
				
				char[] numbers = new char[100];
				numbers = mapString.toCharArray();
				
				for(int in = 0; in < mapSize; in++)
				{
					map[out][in] = numbers[in] - 48;
				}
			}
			
			
			T--;
		}
		
		
	}

}
