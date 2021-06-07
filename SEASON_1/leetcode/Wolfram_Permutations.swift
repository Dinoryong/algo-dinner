// solved by Wolfram Hwang
// 간단하게 재귀로 구현하였습니다.

class Solution {
    var arr: [Int] = []
    var visit: [Bool] = []
    var ans : [[Int]] = []
    func getPerm(_ nums: [Int], _ idx: Int){
        if idx == nums.count {
            ans.append(arr)
        }
        for i in 0..<nums.count {
            if visit[i] == false {
                visit[i] = true
                arr.append(nums[i])
                getPerm(nums, idx + 1)
                arr.popLast()
                visit[i] = false
            }
        }
    }
    func permute(_ nums: [Int]) -> [[Int]] {
        visit = [Bool](repeating: false, count: nums.count)
        getPerm(nums, 0)
        let ret = ans
        return ret
    }
}
