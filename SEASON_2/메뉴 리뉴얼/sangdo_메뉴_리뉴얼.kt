import java.util.*
class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var cnt = IntArray(1 shl 26)
        for(m in orders) {
            for(i in 1 until (1 shl m.length)) {
                var menu = 0
                var b = i
                for(j in m.indices){
                    if(b and 1 == 1){
                        menu = menu or (1 shl (m[j].toInt()-'A'.toInt()))
                    }
                    b = b shr 1
                }
                cnt[menu]++
            }
        }
        var max = IntArray(11)
        var list = Array<ArrayList<String>>(11){ArrayList<String>()}
        var answer: ArrayList<String> = arrayListOf<String>()
        for(i in 1 until (1 shl 26)){
            var n = (i and 0x55555555) + ((i shr 1) and 0x55555555)
            n = (n and 0x33333333) + ((n shr 2) and 0x33333333)
            n = (n and 0x0f0f0f0f) + ((n shr 4) and 0x0f0f0f0f)
            n = (n and 0x00ff00ff) + ((n shr 8) and 0x00ff00ff)
            n = (n and 0x0000ffff) + ((n shr 16) and 0x0000ffff)
            if(cnt[i] >= 2 && n in course) {
                if(max[n] < cnt[i]){
                    max[n] = cnt[i]
                    list[n].clear()
                }
                else if(max[n] > cnt[i]) continue
                var b = i
                var sb = StringBuilder()
                for(j in 0 until 26){
                    if(b and 1 == 1){
                        sb.append(('A'.toInt()+j).toChar())
                    }
                    b = b shr 1
                }
                list[n].add(sb.toString())
            }
        }
        var len = 0
        list.forEach{len += it.size}
        
        var a = Array<String>(len){""}
        len = 0
        
        for(i in list){
            for(j in i){
               a[len++] = j
            }
        }
        Arrays.sort(a, Comparator{i,j -> when{
            i<j->-1
            else ->1
        }})
        return a
    }
}
