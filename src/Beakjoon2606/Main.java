package Beakjoon2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws Exception
    {
        //인접행렬 사용할거임
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int comNum = Integer.parseInt(stdin.readLine());
        int pairNum = Integer.parseInt(stdin.readLine());
        boolean[][] nearMatrix = new boolean[comNum + 1][comNum + 1];
        boolean[] vistedCom = new boolean[comNum + 1];
        
        for(int index = 0; index < comNum + 1; index++) Arrays.fill(nearMatrix[index], false);

        for(int index = 0; index < pairNum; index++)
        {
            int n1, n2;
            String[] rcv = stdin.readLine().split(" ");

            n1 = Integer.parseInt(rcv[0]);
            n2 = Integer.parseInt(rcv[1]);

            nearMatrix[n1][n2] = true;
            nearMatrix[n2][n1] = true;
        }

        System.out.println(getInfectNum(nearMatrix, vistedCom, 1));
    }

    private static int getInfectNum(boolean[][] nearMatrix, boolean[] vistedCom, int startIndex)
    {
        int infectedNumber = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(startIndex);
        vistedCom[startIndex] = true;

        while(true)
        {
            if(stack.isEmpty())
            {
                return infectedNumber;
            }
            int currentIndex = stack.pop();

            for(int index = 1; index < vistedCom.length; index++)
            {
                if(nearMatrix[currentIndex][index] && !vistedCom[index])
                {
                    vistedCom[index] = true;
                    infectedNumber++;
                    stack.push(index);
                }
            }
        }
    }
}