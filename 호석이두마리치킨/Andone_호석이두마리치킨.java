import java.io.*;
import java.util.*;

class AnswerCandidate {
    int store1;
    int store2;
    int distance;

    public AnswerCandidate(int store1, int store2, int distance) {
        this.store1 = store1;
        this.store2 = store2;
        this.distance = distance;
    }
}

class Solution {
    List<List<Integer>> choiceList = new ArrayList<>();
    List<List<Integer>> list;
    public void combine(int n, int r, int start, boolean[] visited) {
        if(r==0) {
            choiceList.add(new ArrayList<>());
            for(int i=0;i<visited.length;i++) {
                if(visited[i]) {
                    choiceList.get(choiceList.size()-1).add(i+1);
                }
            }
            return;
        }
        for(int i=start;i<n;i++) {
            visited[i]=true;
            combine(n,r-1,i+1,visited);
            visited[i]=false;
        }
    }

    public void bfs(int store, int N, int[] distance) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(store);
        int before = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if(!visited[now]) {
                visited[now]=true;
                before++;
                for (int node : list.get(now)) {
                    distance[node]=Math.min(distance[node],before);
                    queue.offer(node);
                }
            }
        }
    }

    public int[] solution(String[] info,int N, int M) {
        list = new ArrayList<>();
        ArrayList<AnswerCandidate> answerCandidates = new ArrayList<>();

        for(int i=0;i<N+1;i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=0;i<M;i++) {
            st=new StringTokenizer(info[i]);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }

        combine(N,2,0,new boolean[N]);

        for(List<Integer> temp : choiceList) {
            int[] distance = new int[N+1];
            Arrays.fill(distance,Integer.MAX_VALUE);
            distance[0]=0;
            int store1 = temp.get(0);
            int store2 = temp.get(1);

            bfs(store1, N, distance);
            bfs(store2, N, distance);
            distance[store1]=0;
            distance[store2]=0;
            int ans = 0;
            for(int dis : distance) {
                ans+=dis;
            }
            answerCandidates.add(new AnswerCandidate(store1,store2,ans*2));
        }

        Collections.sort(answerCandidates,(o1,o2) -> {
            if(o2.distance-o1.distance==0) {
                if(o1.store1==o2.store1) {
                    return o1.store2-o2.store2;
                } else {
                    return o1.store1-o2.store1;
                }
            } else {
                return o1.distance-o2.distance;
            }
        });
        int[] answer = new int[3];
        answer[0]=answerCandidates.get(0).store1;
        answer[1]=answerCandidates.get(0).store2;
        answer[2]=answerCandidates.get(0).distance;
        return answer;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[M];
        for(int i=0;i<M;i++) {
            arr[i] = br.readLine();
        }
        Solution s = new Solution();
        int[] answer = s.solution(arr,N,M);
        System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
    }
}