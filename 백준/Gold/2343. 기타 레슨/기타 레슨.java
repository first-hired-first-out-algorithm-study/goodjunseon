import com.sun.source.tree.IfTree;

import java.io.*;
import java.util.*;

// 백준 S4 수 찾기
public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i]; // end = sum(arr)
            if (arr[i] > start) start = arr[i]; // start = max(arr)
        }

        System.out.println(binarySearch(start, end));

    }

    private static int binarySearch(int start, int end) {
        int answer = end;

        while (start <= end) {
            int mid = (start + end) / 2;

            int count = 1; // 블루레이 최소 1개
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) { // 현재 블루레이에 못 담으면
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (count > M) { // 블루레이가 너무 많이 필요하면 용량을 키워야함
                start = mid + 1;
            } else { // M개 이내로 가능하다면 더 줄여볼 수 있음
                answer = mid;
                end = mid - 1;
            }
        }

        return answer;
    }
}
