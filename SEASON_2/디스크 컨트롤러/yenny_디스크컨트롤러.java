import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
        int index = 0; // jobs의 인덱스
        int complete = 0; // 완료된 작업의 개수
        int time = 0; // 누적 시간
        int end = 0; // 작업의 끝점
		
        while(complete < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }
			
            if(pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] temp = pq.poll();
                time += temp[1] - temp[0] + end;
                end += temp[1];
                complete++;
            }
		}
        
        return (int)Math.floor(time/complete);
    }
}
