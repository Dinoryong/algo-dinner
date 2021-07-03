class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        var chk = Array<IntArray>(3){IntArray(9)}
        for(i in 0..8){
            for(j in 0..8){
                if(board[i][j] == '.') continue
                var v = 1 shl (board[i][j].toInt() - '0'.toInt())
                if(chk[0][i] and v != 0) return false 
                if(chk[1][j] and v != 0) return false
                if(chk[2][(i/3)*3 + (j/3)] and v != 0) return false
                chk[0][i] = chk[0][i] or v
                chk[1][j] = chk[1][j] or v
                chk[2][(i/3)*3 + (j/3)] = chk[2][(i/3)*3 + (j/3)] or v
            }
        }
        return true
    }
}
