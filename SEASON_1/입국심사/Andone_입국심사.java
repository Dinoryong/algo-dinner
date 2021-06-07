//이전에 굉~~~장히 오래 고민했던 백준 K번째 수와 비슷하게 접근하면 되는 문제였다. 입력값이 크며 특정 값을 찾는게 아니라 최소, 최대를 찾는 문제에선 다음과 같이 접근해보자.

import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long min = 0;
        long max = Long.MAX_VALUE;
        long mid, maxPerson;

        while (min <= max) {
            mid = (max + min) / 2;
            
            maxPerson = 0;
            
            for (int i = 0;i<times.length;i++) {
                maxPerson += mid / times[i];
                //테스트케이스 6,9번이 계속 틀려서 확인해봤더니 최대처리량에서 Overflow가 발생하는 것 같아서 처리해줬다.
                if(maxPerson >= n)
                    break;
            }

            if (maxPerson < n) {
                min = mid + 1;
            } else {
                max = mid - 1;
                answer = Math.min(mid, answer);
            }
        }

        return answer;
    }
}
