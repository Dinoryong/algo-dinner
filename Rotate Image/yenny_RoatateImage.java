class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<(n+1)/2; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[n-i-1][j];
                matrix[n-i-1][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
