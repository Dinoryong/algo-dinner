class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        Set<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        
        for(int i=1; i<=nums.length; i++) {
            if(!set.contains(i)) answer.add(i);
        }
        
        return answer;
    }
}