package Beakjoon10870;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[21];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        int N = Integer.parseInt(stdin.readLine());
        for(int index = 2; index < N + 1; index++)
        {
            dp[index] = dp[index - 1] + dp[index - 2];
        }

        System.out.println(dp[N]);
    }
}
