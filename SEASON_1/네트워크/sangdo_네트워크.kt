//union find

class Solution {
    var parent = IntArray(0)
    fun getParent(a:Int): Int {
        if(parent[a] < 0) return a
        parent[a] = getParent(parent[a])
        return parent[a]
    }
    fun join(a:Int, b:Int){
        var pa = getParent(a)
        var pb = getParent(b)
        if(pa == pb) return
        if(parent[pa] < parent[pb]){
            var t = pa
            pa = pb
            pb =t
        }
        parent[pb] += parent[pa]
        parent[pa] = pb
    }
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        parent = IntArray(n){-1}
        var chk = Array<Boolean>(n){false}
        for(i in 0 until n){
            for(j in 0 until n) {
                if(computers[i][j] == 1) join(i,j)
            }
        }
        for(i in 0 until n){
            var pa = getParent(i)
            if(chk[pa] == false) {
                answer++
                chk[pa] = true
            }
        }
        return answer
    }
}
