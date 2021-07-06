class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if(r*c != mat.size*mat[0].size) return mat
       var res = Array<IntArray>(r){IntArray(c)} 
       for(i in mat.indices){
           for(j in mat[i].indices){
               var pos = i*mat[i].size + j
               res[pos/c][pos%c] = mat[i][j]
           }
       }
       return res
    }
}
