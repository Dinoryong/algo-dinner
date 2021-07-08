import java.util.*;


class Pair {
    String answer;
    Integer count;

    Pair(String answer, Integer count) {
        this.answer = answer;
        this.count = count;
    }
}
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();

    public void combine(char[] arr, int n, int r, int start, boolean[] visited) {
        if(r == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<arr.length;i++) {
                if(visited[i]) {
                    sb.append(arr[i]);
                }
            }
            String com = sb.toString();
            map.put(com,map.getOrDefault(com,0)+1);

            return;
        }

        for(int i = start; i<n; i++) {
            visited[i] = true;
            combine(arr, n, r-1, i+1, visited);
            visited[i] = false;
        }
    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for(int i=0;i < orders.length; i++) {
            char[] now = orders[i].toCharArray();
            Arrays.sort(now);
            for(int j=0;j<course.length;j++) {
                combine(now, now.length, course[j], 0, new boolean[now.length]);
            }
        }

        List<Pair> list = new ArrayList<>();

        map.forEach((s, integer) -> {
            if(integer>=2) {
                list.add(new Pair(s, integer));
            }
        });

        list.sort((o1, o2) -> {
            if(o2.answer.length() == o1.answer.length())
                return o2.count - o1.count;
            else
                return o2.answer.length() - o1.answer.length();
        });

        List<Pair> answerList = new ArrayList<>();
        list.forEach((o1)-> {
            if(answerList.isEmpty())
                answerList.add(o1);
            else if(answerList.get(answerList.size()-1).answer.length() == o1.answer.length()) {
                if(answerList.get(answerList.size()-1).count == o1.count) {
                    answerList.add(o1);
                }
            } else {
                answerList.add(o1);
            }
        });

        answerList.sort((Comparator.comparing(o -> o.answer)));

        answer = new String[answerList.size()];

        for(int i=0;i<answer.length;i++) {
            answer[i] = answerList.get(i).answer;
        }

        return answer;
    }
}
