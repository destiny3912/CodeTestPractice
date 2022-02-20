package Beakjoon1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(stdin.readLine()), numberIndex = 0, number = 1;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        ArrayList<Character> result = new ArrayList<Character>();
        boolean makeIt = true;

        int[] numbers = new int[N];

        for(int index = 0; index < N; index++) 
        {
            numbers[index] = Integer.parseInt(stdin.readLine());
        }
        //pop 해야할때 나와야하는 숫자와 pop하는 숫자가 다르면 불가능
        while(true)
        {
            if(numberIndex == N) break;

            if(stack.size() <= 0 || numbers[numberIndex] > stack.get(stack.size() - 1))
            {
                stack.add(number);
                result.add('+');
                number++;
            }
            else if(numbers[numberIndex] == stack.get(stack.size() - 1))
            {
                result.add('-');
                stack.remove(stack.size() - 1);
                numberIndex++;
            }
            else//numbers[numberIndex] < stack.get(stack.size() - 1)
            {
                if(numbers[numberIndex] != stack.get(stack.size() - 1))
                {
                    makeIt = false;
                    break;
                }
            }
        }
   
        if(makeIt)
        {
            for(int index = 0; index < result.size(); index++)
            {
                System.out.println(result.get(index));
            }
        }
        else
        {
            System.out.println("NO");
        }
    }
}