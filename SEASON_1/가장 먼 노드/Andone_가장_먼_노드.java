import java.io.*;
import java.util.*;


class Solution {
    //거리 BFS로 거리계산을 한다. 간선의 거리가 모두 동일함으로 다익스트라로 해결할 이유는 없음.
    public void dj(int[] distance, List<List<Integer>> list, int n) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> pq = new ArrayDeque<>();
        pq.add(1);
        distance[1]=1;
        while (!pq.isEmpty()) {
            int now = pq.poll();
            visited[now] = true;
            for(int i=0;i<list.get(now).size();i++) {
                int next = list.get(now).get(i);
                if(visited[next])
                    continue;
                visited[next]=true;
                pq.add(next);
                distance[next]+=distance[now]+1;
            }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n+1;i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edge.length;i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }

        int[] distance = new int[n+1];

        dj(distance, list, n);

        Arrays.sort(distance);

        int Max = distance[distance.length-1];

        for(int i=0;i<distance.length;i++) {
            if(distance[i]==Max)
                answer++;
        }

        return answer;
    }
}