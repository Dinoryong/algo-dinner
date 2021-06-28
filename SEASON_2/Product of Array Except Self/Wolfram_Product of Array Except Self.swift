class Solution {
    func productExceptSelf(_ nums: [Int]) -> [Int] {
        let lenOfnums = nums.count
        var ans: [Int] = []
        for i in 0..<lenOfnums{
            ans.append(0)
        }
        ans[0] = 1
        for i in 1..<lenOfnums{
            ans[i] = nums[i-1] * ans[i-1]
        }
        var R = 1
        var loopStart = lenOfnums - 1
        while loopStart >= 0{
            ans[loopStart] = ans[loopStart] * R
            R *= nums[loopStart]
            loopStart -= 1
        }
        return ans
    }
}
