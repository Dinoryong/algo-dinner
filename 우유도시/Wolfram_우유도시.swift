// Solved by Wolfram Hwang
// 분명히 C로 맞는데 왜, Swift로 하면 틀리는지?
// 이해하기가 어려운 문제입니다.
// 시간복잡도도 최대 2000 *x + 1000000 * y 정도 되는데.. 이해가안가여..
// 지금 내가 쓸수 있는지 없는지로 판단하여 다음 노드에서 쓸것을 결정하는 쉬운문제입니다.

import Foundation


let n = Int(readLine()!)!
var map = [[Int]]()
for _ in 0..<n {
    let inp = readLine()!.split(separator: " ").map{Int(String($0))!}
    map.append(inp)
}

var dp = Array(repeating:Array(repeating:Array(repeating:0,count:2),count:n),count:n)
var memo = Array(repeating: Array(repeating: Array(repeating: -1, count: 2), count: n), count: n)

if map[0][0] == 0 {
    memo[0][0][1] = map[0][0]
    dp[0][0][1] = 1
}else{
    memo[0][0][1] = -1
    dp[0][0][1] = 0
}
memo[0][0][0] = -1

dp[0][0][0] = 0
for i in 1..<n{
    // -1 0 1 2
    // 지금 것을 쓰기 위해선, 이전 것이 차이가 양수 1이 나거나, -2 가 나야함
    // 쓰는 상황을 가정해본다.
    var diff =  map[0][i] - memo[0][i - 1][1]
    if diff == 1 || diff == -2 {
        if dp[0][i][1] < dp[0][i - 1][1] + 1{
            dp[0][i][1] = dp[0][i-1][1] + 1
            memo[0][i][1] = map[0][i]
        }
    }
    diff = map[0][i] - memo[0][i - 1][0]
    if diff == 1 || diff == -2 {
        if dp[0][i][1] < dp[0][i-1][0] + 1 {
            dp[0][i][1] = dp[0][i-1][0] + 1
            memo[0][i][1] = map[0][i]
        }
    }
    //쓰지 않는 상황은?
    dp[0][i][0] = max(dp[0][i-1][0], dp[0][i-1][1])
    memo[0][i][0] = dp[0][i - 1][0] > dp[0][i - 1][1] ? memo[0][i - 1][0] : memo[0][i-1][1]
}
for i in 1..<n{
    // 지금 것을 쓰기 위해선, 이전 것이 차이가 양수 1이 나거나, -2 가 나야함
    // 쓰는 상황을 가정해본다.
    var diff =  map[i][0] - memo[i - 1][0][1]
    if diff == 1 || diff == -2 {
        if dp[i][0][1] < dp[i-1][0][1] + 1{
            dp[i][0][1] = dp[i-1][0][1] + 1
            memo[i][0][1] = map[i][0]
        }
    }
    diff = map[i][0] - memo[i - 1][0][0]
    if diff == 1 || diff == -2 {
        if dp[i][0][1] < dp[i-1][0][0] + 1 {
            dp[i][0][1] = dp[i-1][0][0] + 1
            memo[i][0][1] = map[i][0]
        }
    }
    //쓰지 않는 상황은?
    dp[i][0][0] = max(dp[i-1][0][0], dp[i-1][0][1])
    memo[i][0][0] = dp[i-1][0][0] > dp[i-1][0][1] ? memo[i-1][0][0] : memo[i-1][0][1]
}
for i in 1..<n {
    for j in 1..<n {
        var diff =  map[i][j] - memo[i - 1][j][1]
        if diff == 1 || diff == -2 {
            if dp[i][j][1] < dp[i-1][j][1] + 1{
                dp[i][j][1] = dp[i-1][j][1] + 1
                memo[i][j][1] = map[i][j]
            }
        }
        diff = map[i][j] - memo[i - 1][j][0]
        if diff == 1 || diff == -2 {
            if dp[i][j][1] < dp[i-1][j][0] + 1 {
                dp[i][j][1] = dp[i-1][j][0] + 1
                memo[i][j][1] = map[i][j]
            }
        }
        //쓰지 않는 상황은?
        //
        diff =  map[i][j] - memo[i][j - 1][1]
        if diff == 1 || diff == -2 {
            if dp[i][j][1] < dp[i][j - 1][1] + 1{
                dp[i][j][1] = dp[i][j - 1][1] + 1
                memo[i][j][1] = map[i][j]
            }
        }
        diff = map[i][j] - memo[i][j - 1][0]
        if diff == 1 || diff == -2 {
            if dp[i][j][1] < dp[i][j - 1][0] + 1 {
                dp[i][j][1] = dp[i][j - 1][0] + 1
                memo[i][j][1] = map[i][j]
            }
        }
        //쓰지 않는 상황은?
        dp[i][j][0] = max(max(dp[i][j - 1][0], dp[i][j - 1][1]) ,max(dp[i-1][j][0], dp[i-1][j][1]))
        var x = i
        var y = j - 1
        var z = 0
        if dp[x][y][z] < dp[i][j-1][1] {
            x = i; y = j - 1; z = 1
        }
        if dp[x][y][z] < dp[i-1][j][0] {
            x = i-1; y = j; z = 0
        }
        if dp[x][y][z] < dp[i-1][j][1] {
            x = i-1;y=j;z=1;
        }
        memo[i][j][0] = memo[x][y][z]
    }
}
print(max(dp[n-1][n-1][0], dp[n-1][n-1][1]))


