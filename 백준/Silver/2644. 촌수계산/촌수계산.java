import java.io.*;
import java.util.*;

// 백준 S2 2644 촌수계산
public class Main {
    static int N, E;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int result;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int start = sc.nextInt();
        int end = sc.nextInt();

        E = sc.nextInt();

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            A[first].add(second);
            A[second].add(first);
        }

        // DFS를 위한 결과 변수 result
        result = -1;

        DFS(start, end, 0);
        System.out.println(result);


    }

    private static void DFS(int current, int target, int depth) {
        // DFS 알고리즘을 재귀 방식으로 구현 해보자!
        if (current == target) {
            result = depth;
            return;
        }
        visited[current] = true;

        for (int i : A[current]) {
            if (!visited[i]) {
                DFS(i, target, depth + 1);
                // 이미 답 찾았으면 더 탐색 안하고 탈출(가지치기)
                if (result != -1) return;
            }
        }
    }
}