import java.io.*;
import java.util.*;

//DFS 문제이다. 연결 리스트를 만들어 준 뒤 방문할 때 마다 visitied를 true로 바꿔준다.

class Solution {
    static int answer = 0;
    boolean[] visitied;
    static List<List<Integer>> list;
    public void dfs(int now) {
        if(visitied[now])
            return;
        visitied[now]=true;
        for(int item : list.get(now)) {
            if(now==item || visitied[item])
                continue;
            dfs(item);
        }
    }

    public int solution(int n, int[][] computers) {
        visitied = new boolean[n+1];
        list = new ArrayList<>();

        for(int i=0;i<n+1;i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    list.get(i+1).add(j+1);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            if(visitied[i])
                continue;
            dfs(i);
            answer++;
        }

        return answer;
    }
}