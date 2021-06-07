class Solution {
    int n;
public:
    void rotate(vector<vector<int>>& matrix) {
        n = matrix.size();
        transpose(matrix);
        reflect(matrix);
    }
    
    void transpose(vector<vector<int>>& matrix){
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    void reflect(vector<vector<int>>& matrix){
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
};