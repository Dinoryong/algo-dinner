import java.util.*
class Solution {
    var nums = IntArray(9)
    var map = HashMap<Int,Int>()
    
    fun solution(N: Int, number: Int): Int {
        map.clear()
        var sb = StringBuilder()
        var dp = ArrayList<Int>()
        for(i in 1 .. 8) {
            sb.append(N.toString())
            nums[i] = sb.toString().toInt()
            dp.add(nums[i])
            map[nums[i]] = i
        }
        for(i in 1 .. 8){
            for(i in dp.lastIndex downTo 0){
                val k = dp[i]
                val v = map[k]!!
                
                for(j in i downTo 0){
                    val k2 = dp[j]
                    val v2 = map[k2]!!
                    if(v + v2 > 8) continue
                    if(map[k + k2] == null || map[k+k2]!! > v+ v2){
                        if(map[k+k2] == null) dp.add(k+k2)
                        map[k+k2] = v+v2
                    }
                    if(map[k*k2] == null || map[k*k2]!! > v + v2) {
                        if(map[k*k2] == null) dp.add(k*k2)
                         map[k*k2] = v+v2
                    }
                    if(map[k - k2] == null || map[k-k2]!! > v + v2){
                        if(map[k-k2] == null) dp.add(k-k2)
                        map[k-k2] = v+v2
                    }
                    if(map[k2 - k] == null || map[k2-k]!! > v + v2){
                        if(map[k2-k] == null) dp.add(k2-k)
                        map[k2-k] = v+v2
                    }
                    if(k != 0 && (map[k2/k] == null || map[k2/k]!! > v + v2)){
                        if(map[k2/k] == null) dp.add(k2/k)
                        map[k2/k] = v+v2
                    }
                    if(k2 != 0 && (map[k/k2] == null || map[k/k2]!! > v + v2)){
                        if(map[k/k2] == null)  dp.add(k/k2)
                        map[k/k2] = v+v2
                    }
                }
            }
        }
        return map[number]?.let{it} ?: -1
    }
}
