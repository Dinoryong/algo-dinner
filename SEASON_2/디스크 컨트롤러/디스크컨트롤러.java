import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int totalLength = jobs.length;
        int waiting = 0;
        
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0]-o2[0];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
        
        int idx = 0;
        int time = 0;
        int nowJob;
        while(idx<totalLength || !pq.isEmpty()) {
            while(idx<totalLength && jobs[idx][0]<=time) {
                pq.offer(jobs[idx++]);//하나의 작업이 끝날때 까지 큐에 집어넣음
            }
            
            if(pq.isEmpty()) {
                time = jobs[idx][0];//수행해야하는 대기 큐에 작업이 없을 경우
            } else {
                int[] nowjob = pq.poll();
                waiting += -nowjob[0] + time + nowjob[1]; //앞선시간 + 작업시간 - 시작시간
                time += nowjob[1]; //수행시간을 더해서 시간의 시점을 옮김
            }
        }
        
        return waiting/totalLength;
    }
}