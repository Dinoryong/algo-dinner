//결론적으로 MST를 구하라는 이야기였고 크루스칼 알고리즘을 이용해서 풀었다.

import java.io.*;
import java.util.*;

class Way {
    int from;
    int to;
    int distance;

    public Way(int from, int to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
}

class Solution {

    int[] parent;


    public int findSet(int p1) {
        if (parent[p1] == p1) return p1;
        return parent[p1] = findSet(parent[p1]);
    }

    public void union(int p1, int p2) {
        int pa = parent[p1];
        int pb = parent[p2];
        if (pa == pb) return;
        parent[pa] = pb;
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        PriorityQueue<Way> pq = new PriorityQueue<>(((o1, o2) -> o1.distance - o2.distance));
        boolean[] visited = new boolean[n];

        for (int[] item : costs) {
            pq.add(new Way(item[0], item[1], item[2]));
        }

        for(int i=0;i<n;i++)
            parent[i]=i;

        while (!pq.isEmpty()) {
            Way way = pq.poll();
            int p1 = way.from;
            int p2 = way.to;

            if (findSet(p1) == findSet(p2))
                continue;
            union(p1,p2);

            answer += way.distance;
        }

        return answer;
    }
}
