import java.util.*;

// 백준 S4 숫자카드2
public class Main {
    static int N, M;
    static int[] cards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        Arrays.sort(cards);


        M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            int count = upperBound(cards, target) - lowerBound(cards, target);
            sb.append(count).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    // target 이상이 처음 나오는 위치
    private static int lowerBound(int[] cards, int target) {
        int left = 0, right = cards.length; // [left,right)

        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // target 초과가 처음 나오는 위치
    private static int upperBound(int[] cards, int target) {
        int left = 0, right = cards.length; // [left, right)
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
