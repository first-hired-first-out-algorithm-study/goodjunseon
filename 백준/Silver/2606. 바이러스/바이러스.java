import java.io.*;
import java.util.*;

// 백준 S3 2606 바이러스
public class Main {

    static int N, E, COUNT;
    static ArrayList<Integer>[] A;
    static boolean[] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        COUNT = 0;

        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            A[start].add(end);
            A[end].add(start); // 양방향 그래프이므로 두개 다 추가
        }

        BFS(1);
        System.out.println(COUNT-1); // -1을 하는 이유는 1번 노드를 카운팅 제외하기 위해

    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            COUNT++;
            for (int i: A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }


    }
}