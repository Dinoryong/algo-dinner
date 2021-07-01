class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var zeros = 0
        var zid = -1
        var mul = 1
        for(i in nums.indices) {
            mul*=if(nums[i] != 0) nums[i] else 1; 
            if(nums[i] == 0) {
                zeros++
                zid = i
            }
        }
        for(i in nums.indices){
            nums[i] = if (zeros > 1) 0 else {if(zeros == 0) mul/nums[i] else if(zid == i) mul else 0}
            
        }
        return nums   
    }
}
