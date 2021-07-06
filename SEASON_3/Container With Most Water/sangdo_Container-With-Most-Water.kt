class Solution {
    fun maxArea(height: IntArray): Int {
        var s = 0;var e = height.lastIndex 
        var res = 0
        while(s < e){
            res = Math.max(res, (e-s)*Math.min(height[s], height[e]))
            if(height[s] < height[e]) s++
            else e--
        }
        return res
    }
}
