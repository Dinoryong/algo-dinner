import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<moves.length;i++) {
            int column = moves[i];
            int j = 0;
                        
            while(board[j][column-1] == 0 && j<board.length-1) {
                j++;
            }
            
            int doll = board[j][column-1];
            board[j][column-1]=0;

            System.out.println(doll);
            
            if(doll != 0) {
                if(!stack.isEmpty() && (stack.peek() == doll)) {
                    stack.pop();
                    answer++;
                    answer++;
                } else {
                    stack.push(doll);
                }
            }
        }
        return answer;
    }
}