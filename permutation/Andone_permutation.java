class Solution {
    List<List<Integer>> answer;
    void permutaion(int[] nums, int n, int depth, boolean[] visited, int r,int[] output) {
        if(depth==r) {
            List<Integer> list = new ArrayList<>();
            for(Integer item : output) {
                list.add(item);
            }
            answer.add(list);
        }

        for(int i=0;i<n;i++) {
            if (!visited[i]) {
                visited[i]=true;
                output[depth]=nums[i];
                permutaion(nums, n, depth+1, visited, r, output);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        int[] output = new int[nums.length];
        permutaion(nums, nums.length, 0, new boolean[nums.length], nums.length, output);
        return answer;
    }
}