package Beakjoon1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(stdin.readLine());

        System.out.println(make1(X));
    }

    private static int make1(int X)
    {
        int index = 2;
        int[] dp = new int[X + 1];
        dp[0] = -1;
        dp[1] = 0;

        while(index <= X)
        {
            if(index % 6 == 0)
            {
                dp[index] = min3(dp[index/2], dp[index/3], dp[index - 1]) + 1;
            }
            else if(index % 3 == 0)
            {
                dp[index] = min(dp[index/3], dp[index - 1]) + 1;
            }
            else if(index % 2 == 0)
            {
                dp[index] = min(dp[index/2], dp[index - 1]) + 1;
            }
            else
            {
                dp[index] = dp[index - 1] + 1;
            }

            index++;
        }

        return dp[X];
    }

    private static int min(int a, int b)
    {
       return (a <= b) ? a : b;
    }
    private static int min3(int a, int b, int c)
    {
       return (a <= b && a <= c) ? a : (b <= c) ? b : c;
    }
}