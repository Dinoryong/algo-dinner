class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        var lid = 0
        var rid = 0
        var now = 0
        var wear = IntArray(n+1){1}
        for(i in lost) wear[i]--
        for(i in reserve) wear[i]++
        for(i in 1 .. n) {
            if(wear[i] == 2 && i -1 > 0 && wear[i-1] == 0) {
                answer++
                wear[i]--
            }
            if(wear[i] == 2 && i+1 <= n && wear[i+1] == 0) {
                wear[i+1]++
            }
            if(wear[i] > 0) answer++
        }
        return answer
    }
}