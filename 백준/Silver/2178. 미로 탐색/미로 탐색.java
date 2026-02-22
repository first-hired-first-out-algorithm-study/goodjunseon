import java.io.*;
import java.util.*;

// 백준 S1 2178 미로탐색
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0 ,0}; // x 방향 상하좌우
    static int[] dy = {0, 0, -1 ,1}; // y 방향 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true; // 시작 지점 초기화
        BFS(0, 0);
        System.out.println(map[N-1][M-1]);
        
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) continue;
                queue.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }

        }



    }
}