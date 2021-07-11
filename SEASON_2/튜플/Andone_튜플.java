import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        String[] strArr = s.split("\\},\\{");
        List<String> strList = Arrays.stream(strArr)
            .map(s1 -> s1.replaceAll("[{}]", ""))
            .sorted(Comparator.comparingInt(o -> o.split(",").length))
            .collect(Collectors.toList());
        
        strList.sort(Comparator.comparingInt(o -> o.split(",").length));
        
        HashMap<String,Integer> map = new HashMap<>();
        String[] allStr = strList.get(strList.size()-1).split(",");
        
        for(int i=0;i<allStr.length;i++) {
            map.put(allStr[i],1);
        }
        
        List<String> answerList = new ArrayList<>();
        
        for(int i=0;i<strList.size();i++) {
            String[] tempList = strList.get(i).split(",");
            for(int j=0;j<tempList.length;j++) {
                if(map.get(tempList[j]) == 1) {
                    answerList.add(tempList[j]);
                    map.computeIfPresent(tempList[j],(String key, Integer value)->--value);
                    break;
                }
            }
        }
        
        answer = new int[answerList.size()];
        
        for(int i=0;i<answer.length;i++) {
            answer[i] = Integer.parseInt(answerList.get(i));
        }
        
        return answer;
    }
}