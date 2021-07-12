import java.util.*
class Solution {
    var pa = IntArray(0)
    fun getP(i: Int): Int {
        if(pa[i] < 0) return i
        pa[i] = getP(pa[i])
        return pa[i]
    }
    
    fun join(a:Int, b:Int): Boolean {
        var p1 = getP(a)
        var p2 = getP(b)
        if(p1 == p2) return false
        if(pa[p1] < pa[p2]) {
            var t = p1
            p1 = p2
            p2 = t
        }
        pa[p2] += pa[p1]
        pa[p1] = p2
        return true
    }
    fun solution(n: Int, costs: Array<IntArray>): Int {
        pa = IntArray(n){-1}
        var chk = IntArray(n){1}
        Arrays.sort(costs, Comparator{i,j -> i[2] - j[2]})
        var con = 0
        var answer = 0
        for(edge in costs) {
            var i = edge[0]
            var j = edge[1]
            var c = edge[2]
            if(join(i,j)){
                con += chk[i] + chk[j]
                chk[i] = 0
                chk[j] = 0
                answer += c
            }
        }
        
        return answer
    }
}
