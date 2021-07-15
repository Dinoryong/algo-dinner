class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for(i in nums.indices) {
            var dest = i+1
            while(dest != nums[i]) {
                var to = nums[i]-1
                if(nums[to] == nums[i]) return nums[i]
                // 이부분 고쳐주세요우 ㅎㅎ - By Wolfram HWang
                var t = nums[to]
                nums[to] = nums[i]
                nums[i] = t
            }
        }
        return nums.size+1
    }
}
