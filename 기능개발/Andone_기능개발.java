//쉬워서 설명은 생략한다.

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] notyet = new int[progresses.length];
        int[] need = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            notyet[i] = 100 - progresses[i];
            if(notyet[i] % speeds[i] == 0)
                need[i] = notyet[i] / speeds[i];
            else
                need[i] = notyet[i] / speeds[i]+1;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        deque.push(need[0]);

        for (int i = 1; i < progresses.length; i++) {
            //햇갈리지 말자 deque에서는 peekFirst가 가장 먼저 들어간 요소이다.
            if (deque.peekFirst() >= need[i])
                deque.add(need[i]);
            else {
                list.add(deque.size());
                deque.clear();
                deque.add(need[i]);
            }
        }
        list.add(deque.size());

        answer = new int[list.size()];

        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}