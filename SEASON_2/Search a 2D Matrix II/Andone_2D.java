class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int i = 0;
        int j = m-1;
        
        
        while(i<n && j>=0) {
            int num = matrix[i][j];
                        
            if(num == target)
                return true;
            else if(num > target) {
                j--;
            } else {
                i++;
            }
        }
        
        return false;
    }
} 