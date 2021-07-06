class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int R = mat.length;
        int C = mat[0].length;
        if (r * c != R * C) return mat;
        int[] arr = new int[R * C];
        int[][] res = new int[r][c];
        for(int i = 0 ; i < R ; ++i){
            for(int j = 0 ; j < C ; ++j){
                arr[i * C + j] = mat[i][j];
            }
        }
        //System.out.println(Arrays.toString(arr));
        if(r == 1) {
            res[0] = arr;
            return res;
        }
        
        for(int i = 0 ; i < R * C ; ++i){
            res[i/c][i%c] = arr[i];
        }
        
        return res;
    }
}