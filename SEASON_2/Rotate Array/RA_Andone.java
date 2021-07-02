class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
                
        for(int i=0;i<nums.length;i++) {
            int index = (i+k)%nums.length;
            temp[index] = nums[i];
        }
        
        for(int i=0;i<nums.length;i++) {
            nums[i]=temp[i];
        }
    }
}