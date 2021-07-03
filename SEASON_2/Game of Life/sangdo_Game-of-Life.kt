class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        var dr = intArrayOf(-1,-1,-1,0,0,1,1,1)
        var dc = intArrayOf(-1,0,1,-1,1,-1,0,1)
        for(i in board.indices){
            for(j in board[0].indices){
                var live = 0
                for(d in 0 .. 7){
                    var nr = i+ dr[d]
                    var nc = j + dc[d]
                    if(nr < 0 || nc < 0 || nr == board.size || nc == board[0].size) continue
                    live += board[nr][nc] and 1
                }
                if(board[i][j].and(1) == 0 && live == 3) board[i][j] = board[i][j] or 2
                if(board[i][j].and(1) == 1 && (live < 2 || live > 3)) board[i][j] = board[i][j] or 2
            }
        }
        for(i in board.indices){
            for( j in board[0].indices) {
                board[i][j] = board[i][j].and(1).xor(board[i][j].shr(1))
            }
        }
    }
}
