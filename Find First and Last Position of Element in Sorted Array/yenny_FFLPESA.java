class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = 0, end = nums.length - 1;
        boolean bstart = false, bend = false;
        
        while(start <= end) {
            if(nums[start] == target && bstart == false) {
                result[0] = start;
                bstart = true;
            }
            if(nums[end] == target && bend == false) {
                result[1] = end;
                bend = true;
            }
            
            if(bstart == true && bend == true) break;
            
            if(bstart == false) start++;
            if(bend == false) end--;
        }
        
        return result;
    }
}
