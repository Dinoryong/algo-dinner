class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0) grid[i][j] = grid[i][j] + grid[i][j-1]; // 오른쪽 방향 합
                else if(j == 0) grid[i][j] = grid[i][j] + grid[i-1][j]; // 아래 방향 합
                else grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]); // 오른쪽과 아래 중 최소 합
            }
        }
        
        return grid[m-1][n-1];
    }
}
