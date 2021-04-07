import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        int[] result = new int[query.length];
        List<List<String>> person = new ArrayList<>();

        List<List<String>> queryString = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            person.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(info[i]);
            for (int j = 0; j < 5; j++) {
                person.get(person.size() - 1).add(st.nextToken());
            }
        }

        for (int i = 0; i < query.length; i++) {
            queryString.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(query[i]);
            for (int j = 0; j < 8; j++) {
                if (j % 2 == 0)
                    queryString.get(queryString.size() - 1).add(st.nextToken());
                else if (j == 7)
                    queryString.get(queryString.size() - 1).add(st.nextToken());
                else
                    st.nextToken();
            }
        }
        Collections.sort(person, (o1,o2)->Integer.parseInt(o2.get(4))-Integer.parseInt(o1.get(4)));
        for (int i = 0; i < query.length; i++) {
            for (int j = 0; j < info.length; j++) {
                int cnt = 0;
                if (Integer.parseInt(queryString.get(i).get(4)) <= Integer.parseInt(person.get(j).get(4))) {
                    cnt++;
                } else {
                    break;
                }
                for (int k = 0; k < 4; k++) {
                    if (queryString.get(i).get(k).equals(person.get(j).get(k)) || queryString.get(i).get(k).equals("-")) {
                        cnt++;
                    }
                }
                if (cnt == 5) {
                    result[i]++;
                }
            }
        }
        answer=result;
        return answer;
    }
}