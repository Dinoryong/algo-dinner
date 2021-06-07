

//
//  main.swift
//  BOJ_Algorithm
//
//  Created by 황지웅 on 2021/04/04.
//  간단한 DP문제인데..
//  Swift로 풀어서 틀렸네요
//  let mn = 에서 Int(string($0))을 Int($0) 만하게 되면 시간초과가 납니다.. 이상한문제임

import Foundation


let nn = readLine()!
let v = Int(nn)
var T: [Int] = [0]
var P: [Int] = [0]
var dp: [[Int]] = [[]]
if let n = v {
    for _ in 0..<n {
        let mn = readLine()!.split(separator: " ").map { Int(String($0))! }
        T.append(mn[0])
        P.append(mn[1])
    }
    let layer = [Int](repeating: 0, count: n + 2)
    dp = [[Int]](repeating: layer, count: 2)
    var ans = 0
    for i in 1...n {
        if i + T[i] <= n + 1{
            dp[1][i + T[i]] = max(dp[1][i + T[i]], max(dp[0][i], dp[1][i]) + P[i])
            ans = max(ans, dp[1][i + T[i]])
        }
        dp[0][i + 1] = max(dp[1][i], dp[0][i])
        ans = max(ans, dp[0][i + 1])
    }
    print(ans)
}//let n = readLine()!.split(separator: " ").map { Int($0)! }



