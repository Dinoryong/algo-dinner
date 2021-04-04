
//
//  main.swift
//  BOJ_Algorithm
//
//  Created by 황지웅 on 2021/04/04.
//
// 굉장히 간단한 BFS문제입니다.
// 큐를 하나만 사용하면 되고 가중치가 동일한만큼 BFS에서 말하는 최소 거리가 나오기때문에
// 그냥 하시던대로 BFS를 구현하시면 될것 같습니다.

import Foundation

let nm = readLine()!.split(separator: " ").map { Int($0)! }
var idist: [[Int]] = [[Int]](repeating: [Int](), count: nm[0] + 1)

for i in 0..<nm[1] {
    let v = readLine()!.split(separator: " ").map { Int($0)! }
    let A = v[0]
    let B = v[1]
    idist[A].append(B)
    idist[B].append(A)
}

let inp = 987654321
var ans = inp
var printans:[Int] = [0,0]
for i in 1...nm[0]-1 {
    for j in i+1...nm[0]{
        var visit: [Int] = [Int](repeating: inp, count: nm[0] + 1)
        var Total: Int = 0
        var q: [Int] = [Int]()
        visit[i] = 0; visit[j] = 0
        q.append(i)
        q.append(j)
        while q.count != 0 {
            let now = q[0]
            q.removeFirst()
            for next in idist[now]{
                if visit[next] > visit[now] + 2{
                    if visit[next] == inp {
                        Total += visit[now] + 2
                    }else{
                        Total -= visit[next]
                        Total += visit[now] + 2
                    }
                    visit[next] = visit[now] + 2
                    q.append(next)
                }
            }
        }
        if ans > Total{
            ans = Total
            printans[0] = i
            printans[1] = j
        }
        
    }
}
print("\(printans[0]) \(printans[1]) \(ans)")





