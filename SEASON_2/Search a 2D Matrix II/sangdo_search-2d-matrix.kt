class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var i = 0
        var j = matrix[0].lastIndex
        for(i in matrix.indices){
            while(j > 0 && matrix[i][j] > target) --j
            if(matrix[i][j] == target) return true
        }
        return false
    }
}
