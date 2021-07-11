class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        nums = nums.sorted()
        var ret = 1
        if nums.count == 0 {
            return 0
        }
        var before = nums[0]
        let INF = Int.max
        if nums.count >= 1 {
            for i in 1..<nums.count {
                if before != nums[i] {
                    before = nums[i]
                    ret += 1
                }else{
                    nums[i] = INF
                }
            }
        }
        nums = nums.sorted()
        return ret
    }
}
