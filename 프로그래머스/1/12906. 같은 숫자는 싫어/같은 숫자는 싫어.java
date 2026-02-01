import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < arr.length; i++) {
            // 만약 큐의 상단 값이 달라야만 넣어라!
            if(q.isEmpty() || q.peekLast() != arr[i]){
                q.offer(arr[i]);
            } 
        }
        int[] answer = new int[q.size()];
        // 여기까지 작업하면 큐에는 1301이 들어있어염
        for(int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }
        
        return answer;
    }
}