import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    // === 고려해야할 내용 ===
    // 지수 법칙 활용 a^(m+n) = a^m * a^n
    // 모듈려 연산 활용 (a * b) % c = {(a % c) * (b % c)} % c
    // int -> long
    public static long pow(long a, long exponent) {

        // 지수가 1인경우 a^1 이므로 a를 그대로 리턴한다.
        if (exponent == 1) {
            return a % C;
        }

        long temp = pow(a, exponent / 2);

        // 지수가 홀수인 경우
        // a^(exponent / 2) * a^(exponent / 2) * a 이므로
        // a를 한번 더 곱해줘야한다.
        // a^ 11 = a^5 * a^5 * a
        if (exponent % 2 == 1) {
            return (temp * temp % C) * a % C;
        }

        // 지수가 짝수인 경우
        return temp * temp % C;
    }
}

