// Solved by Wolfram Hwang
// 단순한 완탐이다.

import Foundation

func solution(_ n:Int, _ path:[[Int]], _ order:[[Int]]) -> Bool {
    var visit : [Int] = []
    var locked : [Int] = [Int](repeating: -1, count: n)
    var lock : [Int] = [Int](repeating: -1, count: n)
    for i in 0...n {
        visit.append(i)
    }
    // 자기 자신 - 미방문, 방문 해도됌
    // 자기 자신이 아닌 양수 -> 방문 해도되고, 하고 나면 풀어줘야함
    // -1 잠금임
    var q : [Int] = []
    var graph : [[Int]] = [[Int]](repeating: q, count: n)
    for x in path {
        graph[x[0]].append(x[1])
        graph[x[1]].append(x[0])
    }
    for x in order {
        lock[x[1]] = x[0]// 누구에 의해 잠겼는지
        locked[x[0]] = x[1] // 누구를 잠갔는지
    }
    if lock[0] != -1 {
        return false
    }
    q.append(0)
    if locked[0] != -1{
        lock[locked[0]] = -1
        locked[0] = -1
    }
    visit[0] = -2
    
    while q.count > 0 {
        let now = q[0]
        q.removeFirst()
        for next in graph[now] {
            if visit[next] == -2 {
                continue
            }
            else{
                if lock[next] != -1 {
                    visit[next] = -1
                }else{
                    if locked[next] != -1 {
                        let belocked = locked[next]
                        locked[next] = -1
                        lock[belocked] = -1
                        if visit[belocked] == -1 {
                            visit[belocked] = -2
                            q.append(belocked)
                        }
                    }
                    visit[next] = -2
                    q.append(next)
                }
            }
        }
    }
    for i in 0..<n {
        if visit[i] != -2 {
            return false
        }
    }
    return true
}
