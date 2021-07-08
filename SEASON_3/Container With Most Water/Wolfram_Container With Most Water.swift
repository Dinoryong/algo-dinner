class Solution {
    func maxArea(_ height: [Int]) -> Int {
        var ret = 0
        var l = 0
        var r = height.count - 1
        while l < r {
            ret = max(ret, min(height[l], height[r]) * (r - l) )
            if height[l] < height[r] {
                l += 1
            }
            else {
                r -= 1
            }
        }        
        return ret
    }
}
