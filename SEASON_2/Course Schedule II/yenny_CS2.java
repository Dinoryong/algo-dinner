class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        
        int len = prerequisites.length;
        if(len == 0) {
            for(int i=0; i<numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        
        int[] count = new int[numCourses];
        for(int i=0; i<len; i++) {
            count[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++) {
            if(count[i] == 0) queue.add(i);
        }
        
        int index = 0;
        int cnt = queue.size();
        
        while(!queue.isEmpty()) {
            int q = queue.remove();
            result[index++] = q;
            
            for(int i=0; i<len; i++) {
                if(prerequisites[i][1] == q) {
                    count[prerequisites[i][0]]--;
                    if(count[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        cnt++;
                    }
                }
            }
        }
        
        if(numCourses == cnt) return result;
        else return new int[0];
    }
}
