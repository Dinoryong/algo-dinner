class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        for(i in nums.lastIndex downTo 0){
            for(j in nums.lastIndex downTo i+1){
                if(nums[j] > nums[i]){
                    var t = nums[j]
                    nums[j] = nums[i]
                    nums[i] =   t
                    for(k in 0 until (nums.size-(i+1))/2){

                        var t = nums[i+1+k] 
                        nums[i+1+k] = nums[nums.lastIndex-k]
                        nums[nums.lastIndex -k] = t
                    }
                    return
                }
            }
        }
        for(i in 0 until nums.size/2){
            var t = nums[i]
            nums[i] = nums[nums.lastIndex-i]
            nums[nums.lastIndex-i] = t
        }
    }
}
