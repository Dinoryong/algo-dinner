class Solution {
    func findDuplicate(_ nums: [Int]) -> Int {
        var low = 1
        var high = nums.count - 1
        var mid: Int
        while low < high {
            mid = (low + high) / 2
            var count = 0
            for i in nums {
                if i <= mid {
                    count += 1
                }
            }
            if count <= mid {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }
}
