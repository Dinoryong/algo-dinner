class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        if(n <= 1) return;
        
        int[] newArr = new int[n];
        k %= n;
        for(int i = 0 ; i < n ; ++i) newArr[i] = nums[i];
        
        int idx = 0;
         
        for(int i = n - k ; i < n ; ++i) nums[idx++] = newArr[i];  
        for(int i = 0 ; i < n - k ; ++i) nums[idx++] = newArr[i];
        
    }
}