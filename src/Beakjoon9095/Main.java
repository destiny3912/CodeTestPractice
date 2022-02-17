package Beakjoon9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        int T = Integer.parseInt(stdin.readLine());
        while(T > 0)
        {
            int N = Integer.parseInt(stdin.readLine());

            for(int index = 1; index < N + 1; index++)
            {
                if(dp[index] != -1)
                {
                    continue;
                }
                else if(index >= 4)
                {
                    dp[index] = dp[index - 1] + dp[index - 2] +  dp[index - 3];
                }
                else
                {
                    if(index == 1)
                    {
                        dp[index] = 1;
                    }
                    else
                    {
                        dp[index] = dp[index - 1] * 2;
                    }
                }
            }
            System.out.println(dp[N]);
            T--;
        }
    }
}