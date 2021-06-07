class Solution {
    var ans : [[Int]] = []
    var arr : [Int] = []
    var limit = 0
    func go(_ idx : Int, _ nums :[Int]){
        if idx == limit {
            ans.append(arr)
            return
        }
        arr.append(nums[idx])
        go(idx + 1, nums)
        arr.popLast()

        go(idx + 1, nums)
    }
    func subsets(_ nums: [Int]) -> [[Int]] {
        limit = nums.count
        go(0, nums)
        return ans
    }
}
