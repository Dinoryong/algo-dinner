import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        var Q:Queue<Int> = LinkedList()
        Q.add(1)
        var adj = Array<ArrayList<Int>>(n+1){ArrayList()}
        var chk = Array<Boolean>(n+1){false}
        for(e in edge) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        chk[1] = true
        while(Q.isNotEmpty()){
            var cnt = Q.size
            answer = cnt
            while(cnt != 0){
                var now = Q.poll()
                for(nxt in adj[now]){
                    if(chk[nxt] == true) continue
                    chk[nxt] = true
                    Q.add(nxt)
                }
                cnt--
            }
        }
        return answer
    }
}
