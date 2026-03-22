import java.util.*;

// 백준 S2 소수 구하기
public class Main {
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt(); // 3
        N = sc.nextInt(); // 16

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        if (N >= 0) isPrime[0] = false;
        if (N >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j+= i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}