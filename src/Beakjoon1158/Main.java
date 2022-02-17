package Beakjoon1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String args[])throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String str = stdin.readLine();
        stdin.close();
        StringTokenizer st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] queue = new int[N];
        int Qnum = 0, cursor = K-1;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int index = 0; index < N; index++)
        {
            list.add(index + 1);
        }

        while(Qnum < N)
        {
            if(Qnum >= N) break;

            queue[Qnum] = list.get(cursor);
            Qnum++;
            list.remove(cursor);
            if(list.size() == 0) break;
            cursor--;
            

            if(cursor + K >= list.size())
            {
                cursor = (cursor + K)%list.size();
            }
            else
            {
                cursor = cursor + K;
            }
        }

        System.out.print("<");
        for(int index = 0; index < N; index++)
        {
            if(index != N - 1)
                System.out.print(queue[index] + ", ");
            else
                System.out.print(queue[index] + ">");
        }
    }
}
