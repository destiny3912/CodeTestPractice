package Beakjoon1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String args[]) throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(stdin.readLine());

        while(T > 0)
        {
            String[] rcv = stdin.readLine().split(" ");
            
            int M = Integer.parseInt(rcv[0]);
            int N = Integer.parseInt(rcv[1]);
            int K = Integer.parseInt(rcv[2]);
            
            //bruteForce(M, N, K, stdin);

            
            T--;
        }
    }

    private static void bruteForce(int M, int N, int K, BufferedReader stdin) throws Exception
    {
        int areaNumber = 0;
            boolean[][] map = new boolean[M][N];
            boolean[][] visitedList = new boolean[M][N];

            for(int index = 0; index < M; index++) 
                Arrays.fill(map[index], false);

            for(int innerIndex = 0; innerIndex < M; innerIndex++) 
                Arrays.fill(visitedList[innerIndex], false);

            for(int index = 0; index < K; index++)
            {
                String[] rcv2 = stdin.readLine().split(" ");
                int n1 = Integer.parseInt(rcv2[0]), n2 =Integer.parseInt(rcv2[1]);

                map[n1][n2] = true;
            }

            for(int outerIndex = 0; outerIndex < M; outerIndex++)
            {
                for(int innerIndex = 0; innerIndex < N; innerIndex++)
                {
                    if(map[outerIndex][innerIndex] && !visitedList[outerIndex][innerIndex])
                    {
                        areaNumber++;
                        getBugNumber(map, visitedList, outerIndex, innerIndex, M, N);
                    }
                }
            }
            System.out.println(areaNumber);
    }
    private static void getBugNumber(boolean[][] map, boolean[][] visitedList, int row, int col, int maxRow, int maxCol)
    {
        int[] dx = {1, 0, -1, -0};
        int[] dy = {0, 1, 0, -1};
        visitedList[row][col] = true;

        for(int index = 0; index < 4; index++)
        {
            if(row + dx[index] >= 0 && row + dx[index] < maxRow && col + dy[index] >= 0 && col + dy[index] < maxCol)
            {
                if(map[row + dx[index]][col + dy[index]] && !visitedList[row + dx[index]][col + dy[index]])
                {
                    getBugNumber(map, visitedList, row + dx[index], col + dy[index], maxRow, maxCol);
                }
            }
        }
    }


}