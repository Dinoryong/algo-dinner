import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static List<String> answerList;
    static Map<String,List<String>> map;
    static int totalWay;

    public boolean checkIsEmpty() {
        List<List<String>> list = new ArrayList<>(map.values());

        for(int i=0;i<list.size();i++) {
            if(list.get(i).size()!=0) return false;
        }
        return true;
    }

    public boolean dfs(String now) {
        if(!map.containsKey(now)) return checkIsEmpty();

        if(map.get(now).isEmpty()) {
            return checkIsEmpty();
        }

        List<String> list = map.get(now);

        for(int i=0;i<list.size();i++) {
            String nextPort = list.get(i);
            list.remove(i);
            answerList.add(nextPort);
            boolean check = dfs(nextPort);
            if(check)
                return true;
            else {
                answerList.remove(answerList.size()-1);
                list.add(0,nextPort);
            }
        }
        return false;
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        answerList = new ArrayList();
        map = new HashMap<>();
        totalWay = tickets.length*2-1;
        for(int i=0;i<tickets.length;i++) {
            map.putIfAbsent(tickets[i][0],new ArrayList<String>());
        }

        //map 생성
        for(int i=0;i<tickets.length;i++) {
            map.get(tickets[i][0]).add(tickets[i][1]);
        }

        Collection<List<String>> list = map.values();

        //경로 생성
        for(List<String> tempList : list) {
            Collections.sort(tempList);
        }

        answerList.add("ICN");
        dfs("ICN");

        answer = new String[answerList.size()];

        int i = 0;
        for(String item : answerList) {
            answer[i] = item;
            i++;
        }

        return answer;
    }
}
