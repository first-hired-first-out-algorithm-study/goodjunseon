import java.util.*;

// 백준 S2 나무 자르기
public class Main {
    static int N, M;
    static int[] trees;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt(); // 필요한 나무의 기링

        trees = new int[N]; // 20 15 10 17
        int max = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
            max = Math.max(max, trees[i]);
        }

        int left = 0; // 절단기 높이 최소
        int right = max; //절단기 높이 최대
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long got = getTree(mid);

            if (got >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static long getTree(int cut) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > cut) {
                sum += (tree - cut);
            }
        }
        return sum;
    }


}