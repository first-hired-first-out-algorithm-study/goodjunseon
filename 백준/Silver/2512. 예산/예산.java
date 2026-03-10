import java.util.*;

// 백준 S2 예산
public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > right) right = arr[i];
        }

        M = sc.nextInt();

        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int x : arr) {
                sum += Math.min(x, mid);
            }

            if (sum <= M) {
                answer = mid;
                left = mid + 1;
            } else if (sum > M) {
                right = mid - 1;
            }

        }

        System.out.println(answer);
    }
}