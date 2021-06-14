class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        var temp = 0
        var temp2 = nums[0]
        let len = nums.count
        var idx = 0
        var cnt = 0
        for i in 0..<len {
            let val = (idx + k) % len
            temp = nums[val]
            nums[val] = temp2
            temp2 = temp
            idx = val
            if idx == cnt, len > 1 {
                if cnt == nums.count - 1 {
                    continue
                }
                cnt += 1
                idx = cnt
                temp = 0
                temp2 = nums[idx]
            }
        }
        
    }
}
