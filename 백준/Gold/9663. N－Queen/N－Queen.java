import java.io.*;
import java.util.*;

public class Main {

    private static int[] chess;
    private static int N;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        chess = new int[N];

        dfs(0);

        System.out.println(count);
    }

    private static void dfs(int depth) {
        // 퀸을 다 놓았을 경우
        if (depth == N) {
            count++;
            return;
        }
        // 아직 퀸이 남아있는 겨우
        for (int i = 0; i < N; i++) {
            chess[depth] = i;
            
            // 해당 위치에 퀸을 놓아도 문제가 없다면 true, 문제가 있으면 false 반환한다.
            if (possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean possibility(int col) {

        for (int i = 0; i < col; i++) {
            // 같은 행에 존재할 경우
            if (chess[col] == chess[i]) {
                return false;
            }
            // 대각선상에 놓여있는 경우
            else if (Math.abs(col - i) == Math.abs(chess[col] - chess[i])) {
                return false;
            }
        }
        return true;
    }
}