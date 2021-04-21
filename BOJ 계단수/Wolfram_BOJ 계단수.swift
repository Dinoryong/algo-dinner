// Solved by Wolfram Hwang
// 3차원 DP네요
// 비트마스킹을 하면서 차순대로 하면 되는 문제입니다.

import Foundation

let n = Int(readLine()!)!
let MOD:Int64 = 1000000000
let MAX = (1 << 10) - 1
let SIZE = 101
let lastlayer = [Int64](repeating: 0, count: MAX + 10)
let secondlayer = [[Int64]](repeating: lastlayer, count: 20)
var dp:[[[Int64]]] = [[[Int64]]](repeating: secondlayer, count: 102)

for i in 1..<10 {
    dp[1][i][(1 << i)] = 1
}
if n > 1 {
    for i in 2...n {
        for j in 0..<10 {
            if j == 0 {
                for k in 1...MAX {
                    dp[i][j][k | (1 << j)] += dp[i-1][1][k]
                }
            }
            else if j == 9 {
                for k in 1...MAX {
                    dp[i][j][k | (1 << j)] += dp[i-1][8][k]
                }
            }else{
                for k in 1...MAX {
                    dp[i][j][k | (1 << j)] += ((dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD)
                }
            }
        }
    }
    var ans: Int64 = 0
    for i in 0..<10 {
        ans  = (ans + dp[n][i][MAX]) % MOD
    }
    print(ans)
}else{
    print(0)
}

