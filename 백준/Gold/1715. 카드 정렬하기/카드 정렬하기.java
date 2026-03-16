import java.util.*;

// 백준 G4 카드 정렬하기
public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(sc.nextInt());
        }
        int result = 0;
        
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            
            int sum = a + b;
            result += sum;
            
            pq.offer(sum);
        }

        System.out.println(result);




    }
}