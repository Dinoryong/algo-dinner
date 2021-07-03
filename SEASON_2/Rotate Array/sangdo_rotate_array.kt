class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var c = nums.size - k%nums.size
        var l = 0
        var r = c-1
        while(l < r) {
            var t = nums[l]
           nums[l++] =nums[r] 
            nums[r--] = t
        }
        l = c
        r = nums.lastIndex
        while(l < r){
            var t = nums[l]
            nums[l++] = nums[r]
            nums[r--] = t
        }
        nums.reverse()
    }
}
