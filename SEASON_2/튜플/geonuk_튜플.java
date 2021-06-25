import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        HashSet<Integer> set = new HashSet<>();

        ArrayList<String> foo = new ArrayList<>();
        String bar = "";
        boolean flag = false;

        for(int i = 1 ; i < s.length()-1 ; ++i){

            if(s.charAt(i) == ',' && !flag) {
                foo.add(bar);
                bar = "";
                flag = false;
            } else if(s.charAt(i) == '{'){
                bar += "{";
                flag = true;
            }
            else if(s.charAt(i) == '}') {
                bar+="}";
                flag = false;
            }
            else bar += String.valueOf(s.charAt(i));
        }
        foo.add(bar);

        Collections.sort(foo, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < foo.size() ; ++i){
            String[] input = foo.get(i).substring(1, foo.get(i).length()-1).split(",");
            for(int j = 0 ; j < input.length ; ++j){
                int val = Integer.parseInt(input[j]);
                if(set.contains(val)) continue;
                else {
                    res.add(val);
                    set.add(val);
                }
            }
        }
        answer = new int[res.size()];
        int idx = 0;
        for(int i : res) answer[idx++] = i;

        return answer;
    }
}
