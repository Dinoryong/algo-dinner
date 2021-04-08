import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        int allCloth = clothes.length;
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<clothes.length;i++) {
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],1)+1);
        }

        int com = 1;

        for(Integer i : map.values()) {
            com*=i;
        }

        answer = com;

        return answer-1;
    }
}