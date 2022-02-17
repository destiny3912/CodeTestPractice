package Beakjoon1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main 
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(stdin.readLine()), index;
        int[] A = new int[N];
        String str = stdin.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        
        for(index=0; index < N; index++)
        {
            A[index] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        //mergeSort(A, 0, N-1);

        int M = Integer.parseInt(stdin.readLine());
        int[] X = new int[M];

        str = stdin.readLine();
        stdin.close();
        st = new StringTokenizer(str, " ");

        for(index = 0; index < M; index++)
        {
            X[index] = Integer.parseInt(st.nextToken());
        }

        for(index = 0; index < M; index++)
        {
            boolean result = binarySearch(A, X[index]);

            if(result) System.out.println("1");
            else System.out.println("0");
        }
    }
    private static boolean binarySearch(int[] list, int target)
    {
        int first = 0, last = list.length - 1;
        int mid;

        while(first <= last)
        {
            mid = (first + last) / 2;

            if(list[mid] == target) return true;
            else if(list[mid] > target) last = mid - 1;
            else first = mid + 1;
        }

        return false;
    }

    /*private static void mergeSort(int[] A, int s, int e)
    {
        int mid = (s + e) / 2;//분할
        if(s < e)
        {
            mergeSort(A, s, mid);//정복
            mergeSort(A, mid + 1, e);//정복
            merge(A, s, mid, e);//결합
        }
    }

    private static void merge(int[] A, int left, int mid, int right)
    {
        int i, j, k;
        int index;
        int[] sorted = new int[A.length];
        i = left;
        j = mid + 1;
        k = left;

        while(i <= mid && j <= right)//분할된 양쪽 리스트를 다 볼때까지
        {
            if(A[i] < A[j])//만약 좌측이 우측보다 작은경우
            {
                sorted[k++] = A[i++];
                //좌측 리스트의 값을 sorted 리스트로 넣는다
            }
            else//만약 좌측이 우측보다 큰 경우
            {
                sorted[k++] = A[j++];
                //우측의 값을 sorted 리스트에 넣는다
            }
        }

        if(i > mid)//만약 좌측 리스트가 비어있다면
        {
            //우측 리스트는 비어있지 않기때문에 나머지를 복사한다
            for(index = j; index <= right; index++)
            {
                sorted[k++] = A[index];
            }
        }
        else//만약 우측 리스트가 비어있다면
        {
            //좌측 리스트는 비어있지 않으므로 나머지를 복사한다
            for(index = i; index <= mid; index++)
            {
                sorted[k++] = A[index];
            }
        }

        //결과를 다시 원본에 복사 그 범위는 결합을 요청받은 범위로 left ~ right
        for(index = left; index <= right; index++)
        {
            A[index] = sorted[index];
        }
    }*/
}