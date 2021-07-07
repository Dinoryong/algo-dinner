class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        for(b in 0 until (1 shl numbers.size)){
            var bit = b
            var res = 0
            for(i in numbers.indices){
                if(bit and (1 shl i) != 0){
                    res += numbers[i]
                }
                else{
                    res -= numbers[i]
                }
            }
            if(res == target) answer++
        }
        return answer
    }
}
