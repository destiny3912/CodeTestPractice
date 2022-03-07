package Beakjoon2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main 
{

    public static void main(String args[]) throws Exception 
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        int N = Integer.parseInt(stdin.readLine());
        int max = 0;
        int[][] map = new int[N][N];

        for (int index = 0; index < N; index++) {
            str = stdin.readLine().split(" ");
            for (int innerIndex = 0; innerIndex < N; innerIndex++) {
                map[index][innerIndex] = Integer.parseInt(str[innerIndex]);
                if (max < map[index][innerIndex] || max == 0)
                    max = map[index][innerIndex];
            }
        }

        int maxResult = 0;
        for (int index = 0; index <= max; index++) {
            int result = getSafeRegionNum(map, index, N);
            if (maxResult == 0) {
                maxResult = result;
                continue;
            }
            if (maxResult < result)
                maxResult = result;
        }

        System.out.println(maxResult);
    }

    private static int getSafeRegionNum(int[][] map, int floodLevel, int N) 
    {
        boolean[][] safeArea = new boolean[N][N];
        boolean[][] countedList = new boolean[N][N];
        int areaCount = 0;
        for (int index = 0; index < N; index++) 
        {
            Arrays.fill(safeArea[index], false);
            Arrays.fill(countedList[index], false);
        }

        for (int outerIndex = 0; outerIndex < N; outerIndex++) 
        {
            for (int innerIndex = 0; innerIndex < N; innerIndex++) {
                if (map[outerIndex][innerIndex] > floodLevel) {
                    safeArea[outerIndex][innerIndex] = true;
                }
            }
        }

        for (int outerIndex = 0; outerIndex < N; outerIndex++)
        {
            for (int innerIndex = 0; innerIndex < N; innerIndex++) 
            {
                if(safeArea[outerIndex][innerIndex] && !countedList[outerIndex][innerIndex])
                {
                    areaCount++;
                    areaChcker(safeArea, countedList, N, outerIndex, innerIndex);
                }
            }
        }
        return areaCount;
    }


    public static void areaChcker(boolean[][] safeArea, boolean[][] countedList, int N, int row, int col)
    {
        countedList[row][col] = true;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int i=0;i<4;i++)
        {
            if(row + dx[i] >= 0 && row + dx[i] < N && col+dy[i] >= 0 && col+dy[i] < N)
            {
                if(safeArea[row + dx[i]][col+dy[i]] && !countedList[row+dx[i]][col+dy[i]])
                {
                    areaChcker(safeArea, countedList, N, row + dx[i], col + dy[i]);
                }
            }
        
        }
    }
}