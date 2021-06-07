class Solution {
    public int lengthOfLongestSubstring(String s) {
        int point1 = 0;
        int point2 = 1;
        if(s.length()==0) {
            return 0;
        }
        int answer = 1;

        char[] words = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        map.put(words[point1],1);

        while(point1 < words.length && point2 < words.length) {
            if(map.getOrDefault(words[point2],0) == 0) {
                answer = Math.max(answer, point2-point1+1);
                map.put(words[point2], map.getOrDefault(words[point2],0));
                map.computeIfPresent(words[point2],(k,v)->v+1);
                point2++;
            } else {
                map.computeIfPresent(words[point1], (k,v)->v-1);
                point1++;
            }
        }

        return answer;
    }
}