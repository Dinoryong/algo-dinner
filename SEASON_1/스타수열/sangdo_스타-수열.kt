import java.util.*
class Solution {
    fun solution(a: IntArray): Int {
        var hashL = HashMap<Int,Pair<Int,Int>>()
        var hashR = HashMap<Int,Pair<Int,Int>>()
        if(a.size == 1) return 0
        var answer: Int = -1
        for(i in a.indices) {
            val v = a[i]
            var llen = hashL[v]?.let{it.first} ?: 0
            var rlen = hashR[v]?.let{it.first} ?: 0
            
            if(i < a.lastIndex && a[i] != a[i+1]) {
                if(hashL[v] == null) {
                   llen = 1
                }
                else {
                    val (l, pi) = hashL[v]!!
                    llen = if(pi < i-1) l + 1 else l
                }
                if(hashR[v] != null) {
                    llen = Math.max(llen, hashR[v]!!.first + 1)
                }
            }
            if(i > 0 && a[i-1] != a[i]) {
                if(hashR[v] == null) {
                    rlen = 1
                }
                else {
                    val(l, pi) = hashR[v]!!
                    rlen = if(pi < i-1)  l+1 else l
                }
                if(hashL[v] != null){
                   	val (l, pi) = hashL[v]!!
                    rlen = Math.max(rlen, if(pi < i-2) l + 1 else l)
                }
            }
            hashL[v] = Pair(llen,i)
            hashR[v] = Pair(rlen,i)
            answer = Math.max(answer, llen*2)
            answer = Math.max(answer, rlen*2)
        }
        return answer
    }
}
