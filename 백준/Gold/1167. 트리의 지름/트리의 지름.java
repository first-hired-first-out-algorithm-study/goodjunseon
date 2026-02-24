import java.io.*;
import java.util.*;

// 백준 G2 트리의 지름
public class Main {
    static boolean visited[];
    static int[] distance;
    static ArrayList<Edge>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<Edge>();
        }

        /*
         * 입력 형식: S E1 V1 E2 V2 ... -1
         */
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1) break;
                int V = sc.nextInt();
                A[S].add(new Edge(E, V));
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(1); // 1에서 가장 먼 노드 Max 찾기 임의의값 1임 아무노드 넣어도됨
        int Max = 1;

        for (int i = 2; i <= N; i++) { // distance 배열에서 가장 큰 값으로 다시 시작점 설정
            if (distance[Max] < distance[i]) Max = i;
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(Max); // Max에서 가장 먼 거리 찾기 = 지름
        Arrays.sort(distance);
        System.out.println(distance[N]);

    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Edge i : A[now_node]) {
                int e = i.e;
                int v = i.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
        }
    }

    static class Edge {
        int e;
        int value;
        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
