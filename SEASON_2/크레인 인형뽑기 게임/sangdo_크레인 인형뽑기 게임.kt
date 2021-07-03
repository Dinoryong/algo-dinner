import java.util.*
class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var box: Stack<Int> = Stack()
        var dolls = Array<Stack<Int>>(board[0].size){Stack<Int>()}
        for(i in board.lastIndex downTo 0){
            for(j in board[0].indices){
                if(board[i][j] != 0) dolls[j].add(board[i][j])
            }
        }
        var answer = 0
        for(p in moves){
            if(dolls[p-1].isEmpty()) continue
            var d = dolls[p-1].pop()
            if(box.isNotEmpty() && d == box.peek()){
                answer+=2
                box.pop()
                continue
            }
            box.add(d)
        }
        
        return answer
    }
}
