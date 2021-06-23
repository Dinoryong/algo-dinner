import Foundation

func solution(_ board:[[Int]], _ moves:[Int]) -> Int {
    var answer = 0
    let range = 0..<board[0].count
    var stk : [Int] = []
    let layer = [Int](repeating: 0, count: board[0].count)
    var map : [[Int]] = [[Int]](repeating: layer, count : board.count)
    for i in 0..<board.count {
        for j in 0..<board[i].count {
            map[i][j] = board[i][j]
        }
    }
    for idx in moves {
        let i = idx - 1
        for j in range {
            if map[j][i] != 0 {
                if stk.count > 0 && stk[stk.count - 1] == map[j][i]{
                    answer += 2
                    stk.removeLast()
                }
                else{
                    stk.append(map[j][i])
                }
                map[j][i] = 0
                break
            }
        }
    }
    return answer
}
