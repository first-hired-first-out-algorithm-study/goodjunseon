import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        int N, R, C;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N); // 한변의 길이

        find(size, R, C);
        System.out.println(count);

    }

    // 2^n * 2^n 배열에서 (r,c)를 방분하는 순서를 반환하는 함수
    public static void find(int size, int r, int c) {
        // Base condition
        if (size == 1) {
            return;
        }

        if (r < size / 2 && c < size / 2) { // 1사분면
            find(size/2, r, c);

        } else if (r < size / 2 && c >= size / 2) { //2사분면
            count += size * size / 4;
            find(size/2, r, c - size/2);

        } else if (r >= size / 2 && c < size / 2) { // 3사분면
            count += (size * size / 4) * 2;
            find(size/2, r - size/2, c);

        } else if (r >= size / 2 && c >= size / 2) { //4사분면
            count += (size * size / 4) * 3;
            find(size/2, r - size/2, c - size/2);
        }

    }
}

