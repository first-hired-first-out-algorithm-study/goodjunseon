import java.util.*;

// 백준 S2 랜선자르기
public class Main {
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        long[] arr = new long[N];
        long left = 1;
        long right = 0;
        long answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (long x : arr) {
                count += (x / mid);
            }

            if (count >= K) { // 가능한 경우
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}