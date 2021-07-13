class Solution {
    func nextPermutation(_ nums: inout [Int]) {
        if nums.count <= 1 { return }

        var i = nums.count - 2
        while i > 0 && nums[i] >= nums[i + 1] { i -= 1 }

        var j: Int = i
        while j < nums.count - 1 && nums[i] < nums[j + 1] { j += 1 }

        guard i != j else { nums.reverse(); return }

        (nums[i], nums[j]) = (nums[j], nums[i])

        i += 1
        j = nums.count - 1
        while i < j {
            (nums[i], nums[j]) = (nums[j], nums[i])
            i += 1
            j -= 1
        }
    }
}
