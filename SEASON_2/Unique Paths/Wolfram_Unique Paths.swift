class Solution {
    func uniquePaths(_ m: Int, _ n: Int) -> Int {
        let layer = [Int](repeating: 0, count: m)
        var dp = [[Int]](repeating: layer, count: n)
        dp[0][0] = 1
        for i in 1..<m {
            dp[0][i] = dp[0][i - 1]
        }
        for i in 1..<n {
            dp[i][0] = dp[i - 1][0]
        }
        for i in 1..<n {
            for j in 1..<m {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[n - 1][m - 1]
    }
}
