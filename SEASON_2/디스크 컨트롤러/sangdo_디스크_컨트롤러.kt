import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var time = 0
        var complete = 0
        var chk = Array<Boolean>(jobs.size){false}
        var pq = PriorityQueue<Int>{i,j->
            var st1 = if(time > jobs[i][0]) time else jobs[i][0]
            var ed1 = st1 + jobs[i][1]
            var st2 = if(ed1 > jobs[j][0]) ed1 else jobs[j][0]
            var ed2 = st2 + jobs[j][1]
            var p1 = ed1 - jobs[i][0] + ed2 - jobs[j][0]
            st1 = if(time > jobs[j][0]) time else jobs[j][0]
            ed1 = st1 + jobs[j][1]
            st2 = if(ed1 > jobs[i][0]) ed1 else jobs[i][0]
            ed2 = st2 + jobs[i][1]
            var p2 = ed1 - jobs[j][0] + ed2 - jobs[i][0]
            p1 - p2
        }
        while(complete < jobs.size) {
            pq.clear()
            var minTime = 0x3f3f3f3f
            for(i in jobs.indices) {
                if(chk[i] == true) continue
                minTime = Math.min(jobs[i][0], minTime)
                if(time >= jobs[i][0]) {
                    pq.add(i)
                }
            }
            if(pq.isNotEmpty()){
                var idx = pq.poll()
                time = (if(time > jobs[idx][0]) time else jobs[idx][0]) + jobs[idx][1] 
                answer += time - jobs[idx][0]
                chk[idx] = true
                complete++
            }
            else{
                time = minTime
            }
        }
        return answer / jobs.size
    }
}
