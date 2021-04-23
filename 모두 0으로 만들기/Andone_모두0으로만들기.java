//..? 왜 틀리지 채점이 이상해요..

import java.util.*;

class Solution {
    static long cnt;
    static List<List<Integer>> list;
    static boolean[] visited;

    
    public boolean isRight(int[] a) {
        long total = 0;
        for(int i=0;i<a.length; i++) {
            total+=a[i];
        }
        if(total == 0) return true;
        return false;
    }
    
    public void dfs(int a[], int before) {
        for(int i=0;i<list.get(before).size();i++) {
            int next = list.get(before).get(i);
            if(visited[next]) continue;
            visited[before] = true;
            dfs(a,next);
            a[before]+=a[next];
            cnt+=Math.abs(a[next]);
            a[next]=0;
        }
        visited[before] = false;
    }
    
    public long solution(int[] a, int[][] edges) {
        long answer = -1;
        cnt = 0;
        visited = new boolean[a.length];
        Arrays.fill(visited,false);
        
        list = new ArrayList<>();
        
        for(int i=0;i<a.length;i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        if(!isRight(a)) {
            return -1;
        }
        dfs(a, 0);
        
        answer = cnt;
        return answer;
    }
}