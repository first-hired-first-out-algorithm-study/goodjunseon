import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int front = 0;
        int rear = N-1;

        while (front < rear){
            if (arr[front] + arr[rear] == M) {
                count++;
                front++;
                rear--;
            } else if (arr[front] + arr[rear] < M) {
                front++;
            } else if (arr[front] + arr[rear] > M) {
                rear--;
            }
        }
        System.out.println(count);
    }
}