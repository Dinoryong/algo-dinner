//문제가 이해가 잘 안되긴 했는데.. 어찌어찌 잘 풀었습니다..

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr = new Integer[citations.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = citations[i];
        }

        Arrays.sort(arr,Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (i<arr[answer]) {
                answer++;
            }
            else break;
        }

        return answer;
    }
}