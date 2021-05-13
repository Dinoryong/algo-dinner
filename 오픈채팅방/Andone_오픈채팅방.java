import java.util.*;

class Pair {
    public String oper;
    public String userId;

    Pair(String oper, String userId) {
        this.oper=oper;
        this.userId=userId;
    }
}

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String[]> list = new ArrayList<>();
        List<Pair> answerList = new ArrayList<>();
        List<String> finalAnswerList = new ArrayList<>();

        Map<String,String> nicknameMap = new HashMap<>();
        for (String s : record) {
            String[] temp = s.split(" ");
            list.add(temp);
        }

        for (String[] now : list) {
            if (now[0].equals("Enter")) {
                nicknameMap.put(now[1], now[2]);
                answerList.add(new Pair("Enter",now[1]));
            } else if (now[0].equals("Leave")) {
                answerList.add(new Pair("Leave",now[1]));
            } else {
                nicknameMap.replace(now[1], now[2]);
            }
        }

        for(Pair item : answerList) {
            if(item.oper.equals("Enter")) {
                finalAnswerList.add(nicknameMap.get(item.userId)+"님이 들어왔습니다.");
            } else {
                finalAnswerList.add(nicknameMap.get(item.userId)+"님이 나갔습니다.");
            }
        }


        answer = new String[answerList.size()];

        for(int i=0;i<finalAnswerList.size();i++) {
            answer[i] = finalAnswerList.get(i);
        }

        return answer;
    }
}