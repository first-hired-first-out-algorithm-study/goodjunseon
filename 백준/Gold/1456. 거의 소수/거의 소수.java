import java.util.*;

// 백준 G5 거의 소수
public class Main {
    static long A, B;
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();

        int limit = (int) Math.sqrt(B);
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);

        if (limit >= 0) isPrime[0] = false; // 0은 소수 X
        if (limit >= 1) isPrime[1] = false;// 1은 소수 X


        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                long value = (long) i * i; // i^2 부터 시작

                while (value <= B) {
                    if (value >= A) {
                        count++;
                    }
                    if (value > B / i) break;
                    value *= i;
                }
            }
        }
        System.out.println(count);
    }
}