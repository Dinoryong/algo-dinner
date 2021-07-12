class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        
        if(len == 0) return 0;
        
        int idx = 0;
        for(int i = 1 ; i < nums.length ; ++i){
            if(nums[i] == nums[idx]) continue;
            else{
                idx++;
                nums[idx] = nums[i];
            }
        }
        
        return idx+1;
    }
}