package Beakjoon10250;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int T = keyboard.nextInt();
		int H, W, N, Answer;
		
		for(int index = 0; index < T; index++)
		{
			H = keyboard.nextInt();
			W = keyboard.nextInt();
			N = keyboard.nextInt();
			
			int front = N % H;
			int rear = (N - 1)/ H;
			rear++;
			
			if(front == 0)
				front = H;
			
			Answer = front * 100 + rear;
			
			System.out.println(Answer);
		}
		
		keyboard.close();
	}
}
