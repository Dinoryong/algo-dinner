class Solution {
    func canCompleteCircuit(_ gas: [Int], _ cost: [Int]) -> Int {
        let len = gas.count
        let range = 0..<len
        var arr : [Int] = [Int](repeating: 0, count : len)
        var sum = 0
        var max_val = -987654321
        var ans = -1
        var max = len - 1
        while max >= 0 {
            sum += gas[max] - cost[max]
            if sum > max_val{
                max_val = sum
                ans = max
            }
            max -= 1
        }
        if sum < 0 {
            return -1
        }
        return ans
    }
}
