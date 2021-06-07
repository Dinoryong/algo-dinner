// Solved by Wolfram Hwang
// 간단한 BFS문제입니다.
// 탐색하면서 가장 먼 노드에 갈때마다 업데이트를 해주는 형태이고
// 만약 내가 지금까지 탐색했던 가장 긴 거리 와 같은 가중치를 가진 노드라면 , ans에 += 1 을해주어
// 답을 도출했습니다.
import Foundation

func solution(_ n:Int, _ edge:[[Int]]) -> Int {
    var idist: [[Int]] = [[Int]](repeating: [Int](), count: n + 1)
    for node in edge {
        let v1 = node[0]
        let v2 = node[1]
        idist[v1].append(v2)
        idist[v2].append(v1)
    }
    var q: [Int] = [Int]()
    var visit : [Int] = [Int](repeating: 0, count: n + 1)
    q.append(1)
    visit[1] = 1
    var MAX: Int = 0
    var ans: Int = 0
    while !q.isEmpty {
        let now = q[0]
        q.removeFirst()
        for next in idist[now]{
            if visit[next] == 0 {
                visit[next] = visit[now] + 1
                q.append(next)
                if visit[next] > MAX{
                    MAX = visit[next]
                    ans = 1
                }else if visit[next] == MAX{
                    ans += 1
                }
            }
        }
    }
    

    return ans
}
