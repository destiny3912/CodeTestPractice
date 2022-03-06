package Beakjoon2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
         public static class mazeCells
        {
            private int row, col, cellNumber;
    
            public void setCell(int n1, int n2, int CN)
            {
                row = n1;
                col = n2;
                cellNumber = CN;
            }
    
            public int getRow()
            {
                return row;
            }
    
            public int getCol()
            {
                return col;
            }
    
            public int getCellNumber()
            {
                return cellNumber;
            }
        }
    public static void main(String args[]) throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        char[] reader;
        String[] rev;
        rev = stdin.readLine().split(" ");
        N = Integer.parseInt(rev[0]);
        M = Integer.parseInt(rev[1]);
        int[][] maze = new int[N][M];
        
        for(int index = 0; index < N; index++)
        {
            reader = stdin.readLine().toCharArray();

            for(int innerIndex = 0; innerIndex < M; innerIndex++)
            {
                maze[index][innerIndex] = Integer.parseInt(Character.toString(reader[innerIndex]));
            }
        }
        findWay(maze, N - 1, M - 1);
    }

    public static void findWay(int[][] maze, int N, int M)
    {
        //BFS 사용
        /* 
        1. 큐에서 뺀다 cellNumber++
        2. 주변 4개를 보고 안막힌 cell을 큐에 넣는다 
        3. 막혔다 -> 이미 방문했거나 0인 cell
        4. loop 끝
        5, 다시 큐에서 뺀다 만약 다시 뺀 cell이 마지막 cell이라면 cellNumber++ 하고 return
        */
        Queue<mazeCells> queue = new LinkedList();
        mazeCells firstCell = new mazeCells();
        boolean[][] vistedList = new boolean[N+1][M+1];
        for(int index = 0; index < N + 1; index++)  Arrays.fill(vistedList[index], false);
        vistedList[0][0] = true;
        mazeCells currentCell = null;
        firstCell.setCell(0, 0, 0);
        queue.offer(firstCell);
        int col = 0, row = 0;
        
        if(N == 0 && M == 0) 
        {
            System.out.println(1);
            return;
        }
        while(true)
        {
            if(queue.isEmpty())
            {
                System.out.println(currentCell.getCellNumber() + 1);
                return;
            }
            currentCell = queue.poll();
            row = currentCell.getRow();
            col = currentCell.getCol();
            vistedList[row][col] = true;
           if(col == M && row == N)
           {
                System.out.println(currentCell.getCellNumber() + 1);
                return;
           }
           else
           {
               boolean up, down, left, right;
               if(col != 0)
               {
                    left = vistedList[row][col - 1] == false && maze[row][col - 1] == 1;
               }
               else
               {
                    left = false;
               }
               if(row != 0) 
               {
                    up = vistedList[row - 1][col] == false && maze[row - 1][col] == 1;
               }
               else
               {
                    up = false;
               }
               if(row != N)
               {
                    down = vistedList[row + 1][col] == false && maze[row + 1][col] == 1;
               }
               else
               {
                   down = false;
               }
               if(col != M)
               {
                    right = vistedList[row][col + 1] == false && maze[row][col + 1] == 1;
               }
               else
               {
                   right = false;
               }
               
               
                if(down)
                {
                    mazeCells nextCell = new mazeCells();
                    int cellNum = currentCell.getCellNumber();
                    cellNum++;
                    nextCell.setCell(row + 1, col, cellNum);
                    vistedList[row+1][col] = true;
                    queue.offer(nextCell);
                }
                if(up)
                {
                    mazeCells nextCell = new mazeCells();
                    int cellNum = currentCell.getCellNumber();
                    cellNum++;
                    nextCell.setCell(row - 1, col, cellNum);
                    vistedList[row-1][col] = true;
                    queue.offer(nextCell);
                }
                if(right)
                {
                    mazeCells nextCell = new mazeCells();
                    int cellNum = currentCell.getCellNumber();
                    cellNum++;
                    nextCell.setCell(row, col + 1, cellNum);
                    vistedList[row][col + 1] = true;
                    queue.offer(nextCell);
                }
                if(left)
                {
                    mazeCells nextCell = new mazeCells();
                    int cellNum = currentCell.getCellNumber();
                    cellNum++;
                    nextCell.setCell(row, col - 1, cellNum);
                    vistedList[row][col-1] = true;
                    queue.offer(nextCell);
                }
           }
        }
    }
}