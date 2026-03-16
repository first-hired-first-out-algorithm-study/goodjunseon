import java.util.*;

// 백준 S4 동전 0
public class Main {
    static int N, K;
    static int[] coin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = N-1; i >= 0; i--) {
            if (coin[i] <= K) {
                result += K / coin[i];
                K = K % coin[i];
            }
        }

        System.out.println(result);

    }
}