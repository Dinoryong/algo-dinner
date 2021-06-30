import java.util.*

class Solution {
    fun solution(numbers: IntArray): String {
        var pq = PriorityQueue<String>(){ str1, str2->
            var sb1 = StringBuilder(str1)
            var sb2 = StringBuilder(str2)
            sb1.append(sb2)
            sb2.append(StringBuilder(str1))
            sb2.toString().toInt() - sb1.toString().toInt()
        }
        for(num in numbers){
            pq.add(num.toString())
        }
        var sb = StringBuilder()
        while(pq.isNotEmpty()){
            var str = pq.poll()
            sb.append(StringBuilder(str))
        }
        var zeros = 0
        for(i in sb.lastIndex downTo(0)){
            if(sb[i] != '0') break
            zeros++
        }
        return if(zeros == sb.length) "0" else sb.toString()
    }
}