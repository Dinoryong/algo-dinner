class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visitied = new boolean[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) {
            list.add(new ArrayList<Integer>());
            list2.add(new ArrayList<Integer>());
        }
        
        int[] incLink = new int[numCourses];
        
        for(int i=0;i<prerequisites.length;i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            incLink[prerequisites[i][0]]++;
            list2.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        List<Integer> answer = new ArrayList<>();
        int[] answerArray = new int[numCourses];
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0;i<list2.size();i++) {
            if(list2.get(i).size()==0)
                dq.add(i);
        }    
        
        int finalPoint = -1;
        
        for(int i = 0;i<list2.size();i++) {
            if(list.get(i).size()==0)
                finalPoint = i;
        }    

        
        if(dq.isEmpty() || finalPoint == -1) {
            return new int[0];
        }
        
        while(!dq.isEmpty()) {
            int now = dq.poll();
            answer.add(now);
            for(int next : list.get(now)) {
                incLink[next]--;
                if(incLink[next]==0) {
                    dq.add(next);
                }
            }
        }
        
        int i=0;
        
        if(answer.size() != numCourses) {
            return new int[0];
        }
        
        for(int item : answer) {
            answerArray[i] = item;
            i++;
        }
        
        return answerArray;
    
    }
}