class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var all = brown + yellow
        for(i in 1 .. all){
            if(all % i == 0) {
                var j = all/i
                if(brown == (i+j)*2-4) return(intArrayOf(j,i))
            }
        }
        return intArrayOf(-1,-1)
    }
}