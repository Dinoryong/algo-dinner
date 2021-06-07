// solved by wolfram Hwang
// 그냥.. dp문제임

import Foundation

let n = Int(readLine()!)!
for _ in 0..<n{    
    let len = Int(readLine()!)!
    let inparr = readLine()!.split(separator: " ").map{Int(String($0))!}
    var dp = [[Int]](repeating:[Int](repeating: 0, count : len + 1), count: len + 1)
    var sum = [0] + inparr
    for i in 1..<sum.count{
        sum[i] = sum[i-1] + sum[i]
    }

    for gap in 1..<len{
        for start in 1...len-gap{        
            let end = start + gap
            dp[start][end] = Int.max
            for mid in start..<end{
                dp[start][end] = min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1] )
            }
        }
    }
    print(dp[1][len])
}

