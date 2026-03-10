import java.util.*;

// 백준 G1 K번째 수
public class Main {
    static int N, K;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        long left = 1;
        long right = K;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt < K) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}