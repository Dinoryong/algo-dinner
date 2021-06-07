// Solved by Wolfram Hwang
// 간단한 트리 DP인데,
// 특이한게 방향성이 제시되어있지않아서 누구도 부모가 될수있고 그러네요.
// 그 점만 잘 캐치한다면 쉽게 풀릴문제입니다.

import Foundation

let n = Int(readLine()!)!
let lay = [Int]()
var graph: [[Int]] = [[Int]](repeating: lay, count: n + 10)
for _ in 1..<n {
    let node = readLine()!.split(separator: " ").map{Int(String($0))!}
    graph[node[0]].append(node[1])
    graph[node[1]].append(node[0])
}
let layer = [Int](repeating: 0, count: 2)
var visit: [Int] = [Int](repeating: 0, count : n + 10)
var dp: [[Int]] = [[Int]](repeating: layer, count: n + 10)

func go(_ now: Int){
    visit[now] = 1
    dp[now][1] = 1
    for next in graph[now] { 
        if visit[next] == 0{           
            go(next)
            dp[now][0] += dp[next][1]
            dp[now][1] += min(dp[next][0], dp[next][1]) 
        }
    }
}

go(1)
print(min(dp[1][0], dp[1][1]))
