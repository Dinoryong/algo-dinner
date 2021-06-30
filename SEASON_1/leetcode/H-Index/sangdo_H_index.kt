class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var s = 0
        var e = citations.size+1
        while(s < e){
            var m = (s+e)/2
            var cnt = 0
            for(j in citations){
                if(j >= m) cnt++
            }
            if(cnt >= m) s = m+1
            else e = m
        }
        return e-1
    }
}