import java.util.*

class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        var childs = IntArray(n+1)
        var parents = IntArray(n+1)
        var win = Array<ArrayList<Int>>(n+1){ArrayList()}
        var lose = Array<ArrayList<Int>>(n+1){ArrayList()}
        for(r in results) {
            var a = r[0]
            var b = r[1]
            win[a].add(b)
            lose[b].add(a)
        }
        var Q:Queue<Int> = LinkedList()
        var chk = IntArray(n+1)
        
        for(i in 1 .. n) {
            Q.add(i)
            chk[i] = i*2
            while(Q.isNotEmpty()) {
                var now = Q.poll()
                childs[i]++
                for(nxt in win[now]) {
                    if(chk[nxt] == i*2) continue
                    chk[nxt] = i*2
                    Q.add(nxt)
                }
            }
            childs[i]--
            chk[i] = i*2+1
            Q.add(i)
            while(Q.isNotEmpty()) {
                var now = Q.poll()
                parents[i]++
                for(nxt in lose[now]) {
                    if(chk[nxt] == i*2+1) continue
                    chk[nxt] = i*2+1
                    Q.add(nxt)
                }
            }
            if(parents[i] + childs[i] == n) answer++
        }
        return answer
    }
}
