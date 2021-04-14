import java.io.*;

//parametric search이며 내가 탐색해야 할 범위를 반으로 줄여주는 방식으로 풀어야 한다.
//그것은 금방 했는데 정작 isOk를 n이 아니라 n^2으로 풀어서 계속 틀렸었다.. 그냥 false일때 0으로 초기화 시켜 주면 되는것을..
class Solution {
    boolean isOk(int[] stones, int max, int k) {
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if(stones[i]<max) cnt++;
            else cnt=0;

            if(cnt>=k) return false;
        }
        return true;
    }

    public int solution(int[] stones, int k) {
        int answer = 0;

        int howMany = 0;
        int mid;
        int max = Integer.MAX_VALUE;

        while (howMany <= max) {
            mid = (max + howMany) / 2;

            if (isOk(stones, mid, k)) {
                answer = mid;

                howMany = mid + 1;
            } else max = mid - 1;
        }

        return answer;
    }
}
