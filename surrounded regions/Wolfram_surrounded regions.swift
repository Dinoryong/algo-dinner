// Solved by Wolfram Hwang
// BFS 문제네요

class Solution {
    func solve(_ board: inout [[Character]]) {
        let m = board.count
        let n = board[0].count
        var q : [(Int, Int)] = [(Int, Int)](repeating: (0,0), count : m * n)
        //원형 큐
        var front = 0
        var rear = 0

        let rangeRow = 0..<m
        let rangeCol = 0..<n
        let dx = [0,0,1,-1]
        let dy = [1,-1,0,0]
        let visitL : [Bool] = [Bool](repeating: false, count : n)
        var visit : [[Bool]] = [[Bool]](repeating : visitL, count : m)
// BFS    
        for i in rangeRow {
            for j in rangeCol {
                if board[i][j] == "O" && visit[i][j] == false{
                    var nq : [(Int, Int)] = [(Int, Int)]()
                    q[rear] = (i, j)
                    rear += 1
                    visit[i][j] = true
                    var isBorder = false
                    while front != rear {
                        let x = q[front].0
                        let y = q[front].1
                        nq.append((x, y))
                        front += 1
                        for v in 0..<4 {
                            let nx = x + dx[v]
                            let ny = y + dy[v]
                            if nx >= 0, nx < m, ny >= 0, ny < n {
                                if board[nx][ny] == "O" && visit[nx][ny] == false{
                                    q[rear] = (nx, ny)
                                    rear += 1
                                    visit[nx][ny] = true
                                }
                            }else{
                                isBorder = true
                            }
                        }
                        
                    }
                    if isBorder == false{
                        for (x,y) in nq {
                            board[x][y] = "X"
                        }
                    }

                }
            }
        }
        

    }
}
