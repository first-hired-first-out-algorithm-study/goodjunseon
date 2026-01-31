import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    
        int size = progresses.length;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < size; i++) {
            int remain = 100 - progresses[i]; // 남은 퍼센트 예: 7%, 70%, 45%
            int days = (remain + speeds[i] -1) / speeds[i]; // 남은 일 수 = 퍼센트/속도 예: 7, 3, 9 
            dq.offer(days); // 7, 3, 9 들어가 있음
        }
        
        int maxDays = Collections.max(dq); // 최대로 걸리는 일수 예: 9
        List<Integer> answerList = new ArrayList<>();
        
        for(int day = 0; day <= maxDays && !dq.isEmpty(); day++) {
            if(!dq.isEmpty() && dq.peek() == day) {
                int count = 0;
                
                while(!dq.isEmpty() && dq.peek() <= day) {
                    dq.poll();
                    count ++;
                }
                
                answerList.add(count); 
            }
        }
               
        
        int[] answer = new int[answerList.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}