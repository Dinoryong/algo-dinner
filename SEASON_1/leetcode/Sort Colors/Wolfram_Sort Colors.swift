class Solution {
    func sortColors(_ nums: inout [Int]) {
        var map : [Int] = [0,0,0]
        for x in nums {
            map[x] += 1
        }
        var idx = 0
        for i in 0...2 {
            for j in 0..<map[i]{
                nums[idx] = i
                idx += 1
            }
        }
    }
}
