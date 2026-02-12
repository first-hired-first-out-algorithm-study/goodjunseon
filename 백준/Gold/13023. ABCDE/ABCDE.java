import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;

    static void dfs(int v, int depth) {
//        System.out.print(v + " "); // 방문 순서 출력
        if (found) return; // 이미 찾았으면 더이상 탐색 X
        if (depth == 5) { // 정점 5개를 연속 방문 성공했을 경우
            found = true;
            return;
        }

        visited[v] = true; // 방문 처리

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (found) return;
            }
        }
        visited[v] = false; // 백트래킹: 다른 경로에서 v를 다시 갈 수 있음
    }

    // 친구 관계 파악하기
    public static void main(String[] args) throws IOException {
        int N; // 사람의 수  5 <= N <= 2,000
        int M; // 친구 관계의 수 (엣지) 1 <= N <= 2,000

        // 풀이
        // 탐색한 노드가 5개거나, 간선이 4개 이상이면 true(1) 반환, 그렇지 않으면 false(0) 반한한다.
        // 여기서 탐색은 중복된 길은 지나지 않는다.
        // 즉 깊이 우선 탐색을 사용한다(DFS)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 8
        M = Integer.parseInt(st.nextToken()); // 8

        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

//        System.out.println("N = " + N + "M = " + M);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
            graph[second].add(first);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
//            System.out.println();
            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }
}
