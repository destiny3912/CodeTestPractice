package Beakjoon1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String[] str = stdin.readLine().split(" ");
        int N, M, V;

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        V = Integer.parseInt(str[2]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] isolated = new boolean[N];
        Arrays.fill(isolated, true);

        for (int index = 0; index < N; index++) {
            graph.add(new ArrayList<>());
        }

        for (int index = 0; index < M; index++) {
            String[] sp = stdin.readLine().split(" ");
            int n1 = Integer.parseInt(sp[0]);
            int n2 = Integer.parseInt(sp[1]);
            isolated[n1 - 1] = false;
            isolated[n2 - 1] = false;

            graph.get(n1 - 1).add(n2);
            graph.get(n2 - 1).add(n1);
        }


        for (int index = 0; index < N; index++) {
            Collections.sort(graph.get(index));
        }

        if(!isolated[V - 1])
        {
            System.out.println(DFS(graph, V, N));
        }
        else
        {
            System.out.println(V);
        }

        if(!isolated[V - 1])
        {
            System.out.println(BFS(graph, V, N));
        }
        else
        {
            System.out.println(V);
        }
    }

    private static String DFS(ArrayList<ArrayList<Integer>> graph, int startNode, int nodeNum) {
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        stack.push(startNode);
        int currentNode = startNode;
        int vistedNum = 1;
        boolean[] vistedList = new boolean[nodeNum];
        Arrays.fill(vistedList, false);
        vistedList[startNode - 1] = true;
        sb.append(startNode);
        // 정점 번호가 작은것을 우선으로 방문한다

        while(!(vistedNum >= nodeNum))
        {   
            boolean isEnd =  false;

            for(int index = 0; index < graph.get(currentNode - 1).size(); index++)
            {
                if(!vistedList[currentNode - 1])
                {
                    stack.push(currentNode);
                    vistedList[currentNode - 1] = true;
                    sb.append(" " + currentNode);
                    vistedNum++;
                    break;
                }
            }

            for(int index = 0; index < graph.get(currentNode - 1).size(); index++)
            {
                if(!vistedList[graph.get(currentNode - 1).get(index) - 1])
                {
                    currentNode = graph.get(currentNode - 1).get(index);
                    break;
                }
                else
                {
                    if(index == graph.get(currentNode - 1).size() - 1)
                    {
                        isEnd = true;
                    }
                }
            }

            if(isEnd)
            {   
                int dump = stack.pop();
                if(stack.empty()) break;
                currentNode = stack.peek();
            }
        }

        return sb.toString();
    }

    
    private static String BFS(ArrayList<ArrayList<Integer>> graph, int startNode, int nodeNum)
    {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        int currentNode = startNode, vistedNum = 1;
        boolean[] vistedList = new boolean[nodeNum];
        Arrays.fill(vistedList, false);
        vistedList[startNode - 1] = true;
        sb.append(startNode);

        while(!(vistedNum >= nodeNum))
        {
            currentNode = queue.poll();

            for(int index = 0; index < graph.get(currentNode - 1).size(); index++)
            {
                int number = graph.get(currentNode - 1).get(index);
                if(!vistedList[number - 1])
                {
                    queue.offer(number);
                    vistedList[number - 1] = true;
                    sb.append(" " + number);
                }
            }

            if(queue.isEmpty()) break;
        }
        return sb.toString();
    }
}