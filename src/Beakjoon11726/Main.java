package Beakjoon11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(stdin.readLine());
        int[] dp = new int[N + 1]; 
        int[] tile = new int[N + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int index = 1; index < N + 1; index++)
        {
            if(index == 1)
            {
                dp[index] = 1;
                tile[index] = 1;
            }
            else if(index == 2)
            {
                dp[index] = 2;
                tile[index] = 2;
            }
            else
            {
                tile[index] = tile[index - 1]%10007 + tile[index - 2]%10007;
                dp[index] = tile[index]%10007;
            }
        }

        System.out.println(dp[N]);
    }
}