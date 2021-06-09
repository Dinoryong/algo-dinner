class Solution {
    public void gameOfLife(int[][] board) {
        int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
        int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
        int m = board.length;
        int n = board[0].length;
        
        // 2 : 원래  비활성화 상태였지만 활성화 상태로 변함
        // 3 : 원래 활성화 상태였지만 비활성화 상태로 변함
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int me = board[i][j]; // 현재 세포
                int cnt = 0; // 활성화  된 세포 개수
                
                // 8 방향으로 탐색
                for(int d=0; d<8; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue; // 좌표 밖을 벗어났을 때
                    if(board[nx][ny] == 1 || board[nx][ny] == 3) cnt++; // 이웃 세포
                }
				
                if(me == 1 && cnt < 2) board[i][j] = 3; // 활성화 : 주변 활성화 세포가 2개 미만일 경우
                if(me == 1 && cnt > 3) board[i][j] = 3; // 활성화 : 주변 활성화 세포가 3개 초과일 경우
                if(me == 0 && cnt == 3) board[i][j] = 2; // 비활성화 : 주변 활성화 세포가 3개일 경우
            }
        }
		
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 2) board[i][j] = 1;
                else if(board[i][j] == 3) board[i][j] = 0;
            }
        }
    }
}
