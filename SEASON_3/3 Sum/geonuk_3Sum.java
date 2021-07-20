class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        int len = nums.length;
        if(len < 3) return new ArrayList<>();
        
        if(len == 3){
            if(nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> tmp = new ArrayList<>();
                
                tmp.add(nums[0]);
                tmp.add(nums[1]);
                tmp.add(nums[2]);
                
                res.add(tmp);
                return res;
            } else return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0 ; i < len ; ++i){
            int l = i + 1;
            int r = len - 1;
            
            if(nums[i] > 0) break;
            
            while(l < len && r >= 0 && l != r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    String val = nums[i] + "" + nums[l] + "" + nums[r] ;
                    if(!set.contains(val)){
                        List<Integer> tmp = new ArrayList<>();
                
                        tmp.add(nums[i]);
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);

                        res.add(tmp);
                        set.add(val);
                    }        
                    r--;
                }
                else if (sum > 0) r--;
                else if(sum < 0) l++;
            }
        }
        
        return res;
    }
}