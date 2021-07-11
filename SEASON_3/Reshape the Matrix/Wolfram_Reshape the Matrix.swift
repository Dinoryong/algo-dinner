class Solution {
    func matrixReshape(_ mat: [[Int]], _ r: Int, _ c: Int) -> [[Int]] {
        let layer : [Int] = []
        var ret : [[Int]] = [[Int]](repeating: layer, count : 1)
        var row = 0
        let total = mat[0].count * mat.count
        var col = total / r
        if col == 0 {
            return mat
        }
        var x = 0
        for i in 0..<mat.count {
            for j in 0..<mat[i].count {
                ret[row].append(mat[i][j])
                x += 1
                if ret[row].count == col {
                    row += 1
                    if x != total {
                        ret.append(layer)
                    }
                }
            }
        }
        if ret.count > r {
            return mat
        }
        return ret
    }
}
