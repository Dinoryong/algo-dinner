import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int R = board.length;
        int C = board[0].length;

        for(int i = 0 ; i < moves.length ; ++i){
            for(int j = 0 ; j < R ; ++j){
                if(board[j][moves[i]-1] == 0) continue;
                else {
                    int val = board[j][moves[i]-1];
                    board[j][moves[i]-1] = 0;

                    if(stack.size() == 0) stack.push(val);
                    else{
                        if(stack.peek() == val) {
                            stack.pop();
                            answer += 2;
                        }
                        else stack.push(val);
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}