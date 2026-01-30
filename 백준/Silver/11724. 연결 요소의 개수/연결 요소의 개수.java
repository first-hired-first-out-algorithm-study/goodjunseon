import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 연결 요소의 개수

    static ArrayList<Integer>[] A; // 인접 리스트(Adjacency List)
    static boolean visited[]; // DFS에서 방문 체크하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 엣지(간선)의 개수


        // 인접 리스트와 방문 배열 초기화
        A = new ArrayList[n + 1]; // 인접 리스트 선언
        visited = new boolean[n + 1]; // 기본 값 false

        for (int i = 1; i <  n + 1; i++) { // 인접 리스트 초기화하기
            A[i] = new ArrayList<Integer>();
        }

        /* 인접리스트가 초기화가 필요한 이유
         * A[i]는 "리스트 객체"여야 .add()가 가능하다.
         * 초기화 하지 않으면 A[i]가 null이라서 NullPointerException 발생
         */


        // 간선 입력 받으며 그래프 만들기(무방향 그래프)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e); // 양방향 edge이므로 양쪽에 egge를 더한다.
            A[e].add(s);
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) { // 방문하지 않은 노드가 없을 때까지 반복하기
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) { // 연결 노드 중 방문하지 않았던 노드만 탐색하기
                DFS(i);
            }
        }
    }
}