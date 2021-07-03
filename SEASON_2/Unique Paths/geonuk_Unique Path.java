class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for(int i = 0 ; i < m ; ++i) map[i][0] = 1;
        for(int i = 0 ; i < n ; ++i) map[0][i] = 1;
        
        for(int r = 1 ; r < m ; ++r){
            for(int c = 1 ; c < n ; ++c){
                map[r][c] = map[r-1][c] + map[r][c-1];
            }
        }
        
        return map[m-1][n-1];
    }
}