package Beakjoon2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(stdin.readLine());
        int[][] map = new int[N][N];

        for (int index = 0; index < N; index++) {
            char[] rcv = stdin.readLine().toCharArray();
            for (int innerIndex = 0; innerIndex < N; innerIndex++) {
                map[index][innerIndex] = Integer.parseInt(Character.toString(rcv[innerIndex]));
            }
        }

        countApt(map, N);
    }

    private static void countApt(int[][] map, int N) {
        ArrayList<Integer> GroupsAptNum = new ArrayList<Integer>();
        boolean[][] countedList = new boolean[N][N];
        int groupNum = 0, aptNum;

        for(int index = 0; index < N; index++)
            Arrays.fill(countedList[index], false);

        for (int outerIndex = 0; outerIndex < N; outerIndex++) {
            for (int innerIndex = 0; innerIndex < N; innerIndex++) {
                if (map[outerIndex][innerIndex] == 1 && !countedList[outerIndex][innerIndex]) {
                    groupNum++;
                    aptNum = getAptNum(map, countedList, N, outerIndex, innerIndex, 1);
                    GroupsAptNum.add(aptNum);
                }

            }
        }

        System.out.println(groupNum);
        Object[] arr = GroupsAptNum.toArray();
        Arrays.sort(arr);
        for (int index = 0; index < groupNum; index++) {
            System.out.println(arr[index]);
        }
    }

    private static int getAptNum(int[][] map, boolean[][] countedList, int N, int row, int col, int prevNum) {
        countedList[row][col] = true;
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        for (int index = 0; index < 4; index++) {
            if (row + dx[index] >= 0 && row + dx[index] < N && col + dy[index] >= 0 && col + dy[index] < N) {
                if (map[row + dx[index]][col + dy[index]] == 1 && !countedList[row + dx[index]][col + dy[index]]) {
                    prevNum++;
                    prevNum = getAptNum(map, countedList, N, row + dx[index], col + dy[index], prevNum);
                    
                }
            }
        }
        return prevNum;
    }
}
