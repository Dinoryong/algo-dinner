import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for(String item : participant) {
            map.computeIfPresent(item,(String key, Integer value)->++value);
            map.putIfAbsent(item,1);
        }

        for(String comple : completion) {
            map.computeIfPresent(comple,(String key, Integer value)->--value);
        }

        for(int i=0;i<participant.length;i++) {
            if(map.get(participant[i])!=0) {
                answer=participant[i];
            }
        }

        return answer;
    }
}