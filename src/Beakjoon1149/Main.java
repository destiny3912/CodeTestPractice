package Beakjoon1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(stdin.readLine());
        int[][] dp = new int[N + 1][3];

        for (int index = 1; index < N + 1; index++) {
            int[] house = new int[3];
            String temp = stdin.readLine();
            StringTokenizer tk = new StringTokenizer(temp, " ");
            house[0] = Integer.parseInt(tk.nextToken());
            house[1] = Integer.parseInt(tk.nextToken());
            house[2] = Integer.parseInt(tk.nextToken());
            
            if (index == 1) {
               dp[index][0] = house[0];
               dp[index][1] = house[1];
               dp[index][2] = house[2];
            }
            else{
                dp[index][0] = min(dp[index - 1][1], dp[index - 1][2]) + house[0];
                dp[index][1] = min(dp[index - 1][0], dp[index - 1][2]) + house[1];
                dp[index][2] = min(dp[index - 1][1], dp[index - 1][0]) + house[2];
            }
        }
        System.out.println(min3(dp[N][0], dp[N][1], dp[N][2]));
    }

    private static int min(int a,int b)
    {
        if(a > b)
            return b;
        else
            return a;
    }

    private static int min3(int a, int b, int c)
    {
        int min = a;

        if(min > b)
        {
            min = b;
        }

        if(min > c)
        {
            min = c;
        }

        return min;
    }
}
