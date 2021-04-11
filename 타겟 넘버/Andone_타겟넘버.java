import java.io.*;
import java.util.*;

//DFS 문제이다. 끝 깊이에 들어갔을 때 해당 값을 확인하고 해당 함수를 벗어나게 한다.

class Solution {
    static int answer = 0;
    void dfs(int[] numbers, int target, int now, int depth) {
        if(depth==numbers.length) {
            if(now==target)
                answer++;
            return;
        }
        int number = numbers[depth];
        dfs(numbers, target, now+number, depth+1);
        dfs(numbers, target, now-number, depth+1);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);

        return answer;
    }
}
