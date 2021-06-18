class Solution {
    func isValidSudoku(_ board: [[Character]]) -> Bool {
        var row : [Int] = [Int](repeating: 0, count: 9)
        var col : [Int] = [Int](repeating: 0, count: 9)
        var cel : [Int] = [Int](repeating: 0, count: 9)
        let layer  : [Int] = [Int] (repeating: 0, count : 9)
        var map : [[Int]] = [[Int]](repeating: layer, count : 9)
        for i in 0..<9 {
            for j in 0..<9 {
                if board[i][j] == "." {
                    continue
                }else{
                    map[i][j] = Int(String(board[i][j]))!
                }
            }
            
        }
        for i in 0..<9 {
            var r = row[i]
            var c = col[i]
            for j in 0..<9{
                if board[i][j] != "." {
                    let x = map[i][j]
                    let v = (1 << x)
                    if v & row[i] == 0 {
                        row[i] |= v
                    }else{
                        return false
                    }
                }
                if board[j][i] != "." {
                    let x = map[j][i]
                    let v = (1 << x)
                    if v & col[i] == 0 {
                        col[i] |= v
                    }else{
                        return false
                    }
                }
            }
        }
        for i in 0..<3 {
            for j in 0..<3{
                for k in 0..<3{
                    if map[j][k + i * 3] != 0, cel[i * 3] & (1 << map[j][k + i * 3]) != 0 {
                        return false
                    }
                    cel[i * 3] |= (1 << map[j][k + i * 3])
                    if map[j + 3][k + i * 3] != 0,cel[i * 3 + 1] & (1 << map[j + 3][k + i * 3]) != 0 {
                        return false
                    }
                    cel[i * 3 + 1] |= (1 << map[j + 3][k + i * 3])
                    if map[j + 6][k + i * 3] != 0, cel[i * 3 + 2] & (1 << map[j + 6][k + i * 3]) != 0 {
                        return false
                    }
                    cel[i * 3 + 2] |= (1 << map[j + 6][k + i * 3])
                }
            }            
        }
        return true
    }
}
