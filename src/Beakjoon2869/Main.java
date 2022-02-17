package Beakjoon2869;

import java.util.StringTokenizer;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String Line = br.readLine();
		StringTokenizer slice = new StringTokenizer(Line, " ");
		double A, B, V;
		
		A = Double.parseDouble(slice.nextToken());
		B = Double.parseDouble(slice.nextToken());
		V = Double.parseDouble(slice.nextToken());
		
		int day = 0;
		
		day = (int)(Math.ceil((V - A) / (A -B)) + 1);
		
		bw.write(day + " ");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
