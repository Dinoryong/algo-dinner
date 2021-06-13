class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        
        int x = matrix.length - 1, y = 0; 
        while(x >= 0 && y < matrix[0].length) {
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] > target) x--;
            else y++;
        }
        
        return false;
    }
}
