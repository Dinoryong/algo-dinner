class Solution {
    public void gameOfLife(int[][] board) {
        
        for(int r = 0 ; r < board.length ; ++r){
            for(int c = 0 ; c < board[0].length; ++c){
                int neighbors = neighborsCount(board, r,c);
                if  (board[r][c] == 1 && (neighbors < 2 || neighbors > 3)) board[r][c] = 2;
                if (board[r][c] == 0 && neighbors == 3) board[r][c] = 3;
                
            }
        }
        
        for(int r = 0 ; r < board.length ; ++r){
            for(int c = 0 ; c < board[0].length; ++c){
                if (board[r][c] == 2) {
                    board[r][c] = 0;
                }
                if (board[r][c] == 3) {
                    board[r][c] = 1;
               }
            }
        }       
    }
    
    private int neighborsCount(int[][] board, int r, int c){
        int[][] dir = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        int neighbors = 0;
        
        for(int i = 0 ; i < 8 ; ++i){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            if(board[nr][nc] == 1 || board[nr][nc] == 2) neighbors += 1;
        }
        
        return neighbors;
    }
}