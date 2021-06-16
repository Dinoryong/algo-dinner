import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        StringBuilder answer = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < timetable.length ; ++i){
           pq.add(timeToMin(timetable[i]));
        }
        
        int curBusTime = 540;
        int busLastTime = 0;
        
        while(n-->0){
            int possible = m;
            int lastCrewTime = 0;
            //System.out.println(pq.toString());
            //System.out.println(curBusTime);

            while(!pq.isEmpty()){
                if(pq.peek() <= curBusTime && possible > 0){
                    lastCrewTime = pq.poll();
                    possible--;
                } else break;
            }
            
            if(n > 0){
                if(pq.isEmpty()){
                    busLastTime = curBusTime + (n + 1) * t;
                    break;
                }
                curBusTime += t;
            } else {
                if (possible > 0) busLastTime = curBusTime;
                else busLastTime = lastCrewTime - 1;
                break;
            }
        }
        //System.out.println(busLastTime);
        answer.append(String.format("%02d", busLastTime / 60));
        answer.append(":");
        answer.append(String.format("%02d", busLastTime % 60));
        return  answer.toString();
    }
    
    public int timeToMin(String s){
        String[] times = s.split(":");
        
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}