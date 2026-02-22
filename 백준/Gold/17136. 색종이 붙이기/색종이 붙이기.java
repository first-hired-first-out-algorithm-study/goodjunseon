import java.io.*;
import java.util.*;

// 백준 G2 17136
public class Main {

    static int[][] map = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 10*10 크기의 맵 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 실행
        backtracking(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    private static void backtracking(int xy, int useCnt) {
        // 탐색이 모두 끝난 경우
        if (xy == 100) {
            result = Math.min(useCnt, result);
            return;
        }
        int x = xy % 10;
        int y = xy / 10;

        // 가지치기: 이전에 최소로 사용된 색종이 수보다 현재 탐색에서 사용한 색종이 수가 더 많으면 바로 탐색 중단
        if (result <= useCnt) return;

        if (map[y][x] == 1) {
            for (int i = 5; i > 0; i--) {
                if (paper[i] > 0 && check(x, y, i)) {
                    paper[i]--; // 종이 사용하기
                    fill(x, y, i, 0);
                    backtracking(xy + 1, useCnt + 1);
                    paper[i]++; // 사용한 종이 다시 채우기
                    fill(x, y, i, 1); // 종이 떼어 내기: 기존에 덮인 부분 0 -> 1로 초기화
                }
            }
        } else {
            backtracking(xy + 1, useCnt);
        }
    }

    static void fill(int x, int y, int size, int num) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                map[i][j] = num;
            }
        }
    }

    static boolean check(int x, int y, int size) {
        // x, y의 범위가 map 밖인 경우 바로 false 반환
        if (x + size > 10 || y + size > 10) return false;

        //
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }
}