class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        let layer = [Int](repeating : 0, count : grid[0].count)
        var dp : [[Int]] = [[Int]](repeating : layer, count : grid.count)
        let range = 1..<grid.count
        dp[0][0] = grid[0][0]
        for i in range {
            dp[i][0] = dp[i-1][0] + grid[i][0]
            
        }
        for i in 1..<grid[0].count {
            dp[0][i] = dp[0][i-1] + grid[0][i]
        }

        for i in range {
            for j in 1..<grid[0].count {
                dp[i][j] = min(dp[i-1][j], dp[i][j - 1]) + grid[i][j]
            }
        }
        //print(dp)
        return dp[grid.count - 1][grid[0].count - 1]
    }
}
