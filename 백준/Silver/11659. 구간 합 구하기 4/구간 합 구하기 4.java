import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] dp;
    static int N, M;

    public static void main(String[] args) throws IOException {

        /*
            5 3
            5 4 3 2 1
            1 3  -> 5 + 4 + 3 = 12
            2 4 -> 4 + 3 + 2 = 9
            5 5 -> 1
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr = 5, 4, 3, 2, 1

        dp = new int[N]; // 5, 9, 12, 14, 15
        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 1) { // 부분합일 때,
                System.out.println(dp[end - 1]);
            } else { // 구간합일 때,
                System.out.println(dp[end - 1] - dp[start - 2]);
            }
        }

    }
}