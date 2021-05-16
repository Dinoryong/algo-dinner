class Solution {
    List<List<Integer>> answerList = new ArrayList<>();

    public void combine(int[] nums, int n, int r, int start, boolean[] visited) {
        if(r==0) {
            Set<Integer> newList = new HashSet<>();
            for(int i=0;i<nums.length;i++) {
                if(visited[i]){
                    newList.add(nums[i]);
                }
            }
            answerList.add(new ArrayList<>(newList));
            return;
        }

        for(int i=start;i<n;i++) {
            visited[i]=true;
            combine(nums, n,r-1,i+1,visited);
            visited[i]=false;
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        int arrLength = nums.length;
        for(int i=0;i<arrLength+1;i++) {
            boolean[] visited = new boolean[arrLength];
            combine(nums, arrLength, i, 0, visited);
        }

        return answerList;
    }
}
