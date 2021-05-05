// Solved by Wolfram Hwang
// 단순한 완탐이다.

import Foundation
var visit : [Int] = []
var locking : [Int] = []
var locked : [Int] = []
var graph: [[Int]] = [[Int]]()
var q : [Int] = []
func initArr(_ n : Int) {
    let layer:[Int] = []
    graph = [[Int]](repeating: layer, count: n)
    locking = [Int](repeating: -1, count: n)
    locked = [Int](repeating: -1, count: n)
    for i in 0...n {
        visit.append(i)
    }
}

func bfs() {
    q.append(0)
    if locking[0] != -1{
        locked[locking[0]] = -1
        locking[0] = -1
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
                if locked[next] != -1 {
                    visit[next] = -1
                }else{
                    if locking[next] != -1 {
                        let belocked = locking[next]
                        locking[next] = -1
                        locked[belocked] = -1
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
}

func solution(_ n:Int, _ path:[[Int]], _ order:[[Int]]) -> Bool {
    initArr(n)
    for x in path {
        graph[x[0]].append(x[1])
        graph[x[1]].append(x[0])
    }
    
    for x in order {
        locked[x[1]] = x[0]// 누구에 의해 잠겼는지
        locking[x[0]] = x[1] // 누구를 잠갔는지
    }
    
    if locked[0] != -1 {
        return false
    }
    
    bfs()
    
    for i in 0..<n {
        if visit[i] != -2 {
            return false
        }
    }
    return true
}
