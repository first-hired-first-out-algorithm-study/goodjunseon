import java.io.*;
import java.util.*;

// 백준 S4 수 찾기
public class Main {

    public static void main(String[] args) {
        int N, M;
        int[] A;
        int[] B;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
           A[i] = sc.nextInt();
        }

        M = sc.nextInt();
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(A, B[i]) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
