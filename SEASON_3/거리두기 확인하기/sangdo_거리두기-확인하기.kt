import java.util.*

class Solution {
    var dr = intArrayOf(-1,0,1,0)
    var dc = intArrayOf(0,1,0,-1)
    var visit = Array(5){IntArray(5)}
    var q =0
    fun getDist(p: Array<String>, r: Int, c: Int): Boolean {
        q++
        var Q:Queue<Pair<Int,Int>> = LinkedList()
        Q.add(Pair(r,c))
        visit[r][c] = q
        var cnt = 2
        while(cnt != 0) {
            var c = Q.size
            
            while(c != 0) {
                val (nr,nc) = Q.poll() 
                for(d in 0 .. 3){
                    var nnr = nr + dr[d]
                    var nnc = nc + dc[d]
                    if(nnr < 0 || nnc < 0 || nnr == 5 || nnc == 5) continue
                    if(visit[nnr][nnc] == q) continue
                    if(p[nnr][nnc] == 'P') return false
                    if(p[nnr][nnc] == 'X') continue
                    visit[nnr][nnc] = q
                    Q.add(Pair(nnr,nnc))
                }
                c--
            }
            cnt--
        }
        return true
    }
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = IntArray(5)
        for(id in places.indices) {
            var arr = places[id]
            var res = 1
            for(i in 0 .. 4) {
                for(j in 0 .. 4) {
                    if(arr[i][j] == 'P' && !getDist(arr,i,j)){
                       res = 0 
                        break
                    }
                }
            }
            answer[id] = res
        }
        return answer
    }
}
