//간단한 시뮬레이션 문제였는데 문제를 잘못 이해했다....
class Solution {
    public void gameOfLife(int[][] board) {
        int[] dx = {-1,-1,0,1,0,1,-1,1};
        int[] dy = {-1,0,-1,0,1,1,1,-1};
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] answer = new int[n][m];
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int count = 0;
                int cell = board[i][j];
                for(int k=0;k<8;k++) {
                    int nowX = j + dx[k];
                    int nowY = i + dy[k];
                    
                    if(nowX<0||nowY>=n||nowY<0||nowX>=m)
                        continue;
                    else if(board[nowY][nowX]==1){
                        count++;
                    }
                }
                if(cell == 0 && count == 3){
                    answer[i][j] = 3;
                } else if(cell == 1 && (count==2 || count == 3)) {
                    answer[i][j] = 3;
                } else if(cell == 1 && (count < 2 || count > 3)) {
                    answer[i][j] = 2;
                }
            }
        }
    
        
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(answer[i][j] == 3) {
                    board[i][j] = 1;
                } else if(answer[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }
}