import java.io.*;
import java.util.*;

// 백준 S2 1780 종이의 개수
public class Main {
    static int N;
    static int[][] paper;
    static int minus, zero, plus;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        paper = new int[N][N];
        minus = 0; zero = 0; plus = 0; // 카운트 변수 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        recursion(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
        
//        System.out.println("minus = " + minus);
//        System.out.println("zero = " + zero);
//        System.out.println("plus = " + plus);

    }

    private static void recursion(int r, int c, int size) {
        int first = paper[r][c];
        boolean same = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }
        if (same) {
            if (first == -1) minus++;
            else if (first == 0) zero++;
            else plus++;
            return;
        }
        int next = size / 3;
        for (int dr = 0; dr < 3; dr++) {
            for (int dc = 0; dc < 3; dc++) {
                recursion(r + dr * next, c + dc * next, next);
            }
        }
    }


}