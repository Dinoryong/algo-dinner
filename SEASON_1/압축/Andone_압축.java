import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        char[] charArr = msg.toCharArray();
        List<Integer> list = new ArrayList<>();
        
        
        Map<String,Integer> dic = new HashMap<>();
        
        for(int i=0;i<27;i++) {
            dic.put(Character.toString('A'+i),i+1);
        }
        
        int lastIndex = 27;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<msg.length();i++) {
            char checkChar = charArr[i];
            
            sb.append(checkChar);
            
            
            
            if(dic.containsKey(sb.toString())) {
                if(i==msg.length()-1) {
                    list.add(dic.get(sb.toString()));
                    break;
                }
            }
            else if(!dic.containsKey(sb.toString())) {
                i--;
                dic.put(sb.toString(),lastIndex);
                lastIndex++;
                sb.deleteCharAt(sb.length()-1);
                list.add(dic.get(sb.toString()));
                sb = new StringBuilder();
            }
        }
                
        answer = new int[list.size()];
        for(int i = 0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}