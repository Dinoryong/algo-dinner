class Solution {
    static List<List<Integer>> lose;
    static List<List<Integer>> win;
    static int[] cntLose;
    static int[] cntWin;
    static int answer = 0;
    static int wholeN;

    public void bfs(int start, int n, List<List<Integer>> list,int[] cntList) {
        boolean[] visited = new boolean[wholeN+1];
        int cnt = 0;

        Deque<Integer> dq = new ArrayDeque<Integer>();
        dq.add(start);
        while(!dq.isEmpty()) {
            int now = dq.poll();

            for(int item : list.get(now)) {
                if(!visited[item]) {
                    dq.add(item);
                    visited[item] = true;
                    cnt++;
                }
            }
        }

        cntList[start]=cnt;
    }

    public int solution(int n, int[][] results) {
        lose = new ArrayList<>();
        win = new ArrayList<>();
        cntLose = new int[n+1];
        cntWin = new int[n+1];
        wholeN = n;
        for(int i=0;i<n+1;i++) {
            lose.add(new ArrayList<>());
            win.add(new ArrayList<>());
        }

        for(int i=0;i<results.length;i++) {
            lose.get(results[i][1]).add(results[i][0]);
            win.get(results[i][0]).add(results[i][1]);
        }

        for(int i=1;i<n+1;i++) {
            bfs(i,n,lose,cntLose);
            bfs(i,n,win,cntWin);
        }

        int[] cntcnt = new int[n+1];


        for(int i=1;i<n+1; i++) {
            cntcnt[i] = cntLose[i]+cntWin[i];
        }

        for(int i=1;i<n+1; i++) {
            if(cntcnt[i]==n-1) {
                answer++;
            }
        }



        return answer;
    }
}