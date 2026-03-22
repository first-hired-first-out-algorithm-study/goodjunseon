import java.util.*;

// 백준 S2 잃어버린 괄호
public class Main {
    static int N;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = Sum(str[i]);
            if (i == 0)
                answer = answer + temp; // 가장 앞의 값은 더하기
            else
                answer = answer - temp; // 뒷부분은 더한 값들의 뺌

        }
        System.out.println(answer);
    }

    private static int Sum(String s) {
        int sum = 0;
        String temp[] = s.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}