class Solution {
    let dx = [1,-1,0,0,1,1,-1,-1]
    let dy = [0,0,1,-1,1,-1,1,-1]
    func gameOfLife(_ board: inout [[Int]]) {
        let row = 0..<board.count
        let col = 0..<board[0].count
        for i in row {
            for j in col {
                if board[i][j] == 0 {//dead
                    var cnt = 0
                    for d in 0..<dx.count{
                        let nx = i + dx[d]
                        let ny = j + dy[d]
                        if nx >= 0, nx < board.count, ny >= 0,  ny < board[0].count {
                            if board[nx][ny] == 1 || board[nx][ny] == 3 {
                                cnt += 1
                            }
                        }                        
                    }
                    if cnt == 3 {
                        board[i][j] = 2
                    }
                }
                else {
                    var cnt = 0
                    for d in 0..<dx.count {
                        let nx = i + dx[d]
                        let ny = j + dy[d]                        
                        if nx >= 0, nx < board.count, ny >= 0,  ny < board[0].count {
                            if board[nx][ny] == 1 || board[nx][ny] == 3 {
                                cnt += 1
                            }
                        }
                    }
                    if cnt < 2 || cnt > 3 {
                        board[i][j] = 3
                    }
                }
            }
        }
        for i in row {
            for j in col {
                if board[i][j] == 3 {
                    board[i][j] = 0
                }
                if board[i][j] == 2 {
                    board[i][j] = 1
                }
            }
        }

    }
}
