class Solution {
    fun grayCode(n: Int): List<Int> {
        var arr = arrayListOf(0,1)
        for(i in 1 until n) {
            var cnt = arr.size
            for(j in arr.lastIndex downTo 0){
                arr.add(arr[j] or (1 shl i))
            }
        }
        return arr
    }
}
