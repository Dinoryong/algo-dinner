class Solution {
    func convert(_ s: String, _ numRows: Int) -> String {
        if numRows == 1 {
            return s
        }
        let layer : [String] = [String](repeating: "", count: numRows)
        var mat : [[String]] = [[String]](repeating: layer, count: 1)
        var cnt = 0
        var row = 0
        var isFull = false
        for i in s {
            let str = String(i)
            if isFull == false {
                mat[row][cnt] = str
                cnt += 1
                if cnt == numRows {
                    isFull = true
                    row += 1
                    cnt -= 2
                    if cnt <= 0 {
                        cnt = 0
                        isFull = false
                    }
                    mat.append(layer)
                }
            }else{
                mat[row][cnt] = str
                cnt -= 1
                row += 1
                mat.append(layer)
                if cnt == 0 {
                    isFull = false
                }
            }
        }
        var ret = ""
        for i in 0..<numRows {
            for j in 0...row {
                if mat[j][i] == "" {
                    continue
                }
                ret += mat[j][i]
            }
        }
        return ret
    }
}
