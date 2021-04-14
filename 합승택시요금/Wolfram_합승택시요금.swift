// Solved by Wolfram Hwang
// 플로이드 와샬..
// Solved By Wolfram Hwang
// 처음에는 Dijkstra로 풀었는데
// 계속 시간초과가 나더군요..
// 아무래도 최대 복잡도가 생각보다 많이 큰 모양입니다.
// 애초에 N값이 100 대라 차라리 플로이드 와샬이 확실한 풀이법이긴합니다.(고정된 시간 복잡도)



import Foundation

let INF = 987654321

func solution(_ n:Int, _ s:Int, _ a:Int, _ b:Int, _ fares:[[Int]]) -> Int {
    let tempLayer: [Int] = [Int](repeating: INF, count: n + 1)
    let tempLayer2: [Int] = [Int](repeating: -1, count: n + 1)
    var dist : [[Int]] = [[Int]](repeating: tempLayer, count: n + 1)
    var before: [[Int]] = [[Int]](repeating: tempLayer2, count: n + 1)
    for x in fares {
        dist[x[0]][x[1]] = x[2]
        dist[x[1]][x[0]] = x[2]
    }
    for i in 1...n {
        dist[i][i] = 0
    }
    for i in 1...n {
        for ss in 1...n {
            for ee in 1...n{
                if dist[ss][ee] > dist[ss][i] + dist[i][ee] {
                    dist[ss][ee] = dist[ss][i] + dist[i][ee]
                }
            }
        }
    }
    var minV = INF
    for i in 1...n {
        if minV > dist[i][s] + dist[i][a] + dist[i][b] {
            minV = dist[i][s] + dist[i][a] + dist[i][b]
        }
    }
    //print(dist)
    return minV
}
