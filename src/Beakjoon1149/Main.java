package Beakjoon1149;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[])throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(stdin.readLine());
        int[] dp = new int[N + 2];
        dp[0] = 0;
        int prevColor = -1;

        for(int index = 1; index < N + 1; index++)
        {

        }
    }

    private int min3(int a, int b, int c)
    {
        
    }
    //N-1집의 색깔을 제외하고 나머지 2가지 색에서 최소를 가져오면 된다.
}
