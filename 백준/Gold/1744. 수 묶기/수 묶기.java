import java.util.*;

// 백준 G4 카드 정렬하기
public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                zero++;
            } else if (input == 1) {
                one++;
            } else if (input > 1) {
                plusPq.offer(input);
            } else {
                minusPq.offer(input);
            }
        }

        int result = 0;

        while (plusPq.size() > 1) {
            int a = plusPq.poll(); // 제일 큰 값
            int b = plusPq.poll(); // 두번 째로 큰 값
            result += a * b;
        }

        if (!plusPq.isEmpty()) {
            result += plusPq.poll();
        }

        while (minusPq.size() > 1) {
            int a = minusPq.poll();
            int b = minusPq.poll();
            result += a * b;
        }

        if (!minusPq.isEmpty()) {
            if (zero == 0) {
                result += minusPq.poll();
            }
        }

        result += one;

        System.out.println(result);
    }
}