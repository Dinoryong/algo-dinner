import java.util.*

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var pq = PriorityQueue<Int>()
        var res = IntArray(commands.size)
        for(j in commands.indices) {
            pq.clear()
            var (s,e,k) = commands[j]
            for(i in s-1 .. e-1){
                pq.add(array[i])
            }
            for(i in 1 .. k) {
                res[j] = pq.poll()
            }
        }
        
        return res
    }
}