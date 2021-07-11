"""
[topics]

[sketch]
"""
#
class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        N, M = len(mat[0]), len(mat)
        T = r*c
        if N*M != T:
            return mat

        output = [[0 for _ in range(c)] for _ in range(r)]
        k = 0
        for i in range(M):
            for j in range(N):
                output[k//c][k%c] = mat[i][j]
                k += 1

        return output