// Solved by WolframHwang
// 그냥 단순한 BFS문제입니다.
// 더이상 뭐.. 설명할것도 없네요..


import Foundation

func solution(_ n:Int, _ computers:[[Int]]) -> Int {
    var islandNumb = 1
    var q:[Int] = [Int]()
    var visit: [Int] = [Int](repeating: 0, count: n + 1)
    let range = 0..<n
    for startIsland in range {
        if visit[startIsland] != 0 {
            continue
        }
        q.append(startIsland)
        visit[startIsland] = islandNumb
        while q.isEmpty == false{
            let now = q[0]
            q.removeFirst()
            for next in range{
                if computers[now][next] == 0 {
                    continue
                }
                if visit[next] == 0 {
                    visit[next] = islandNumb
                    q.append(next)
                }
            }
        }
        islandNumb += 1
    }
    return islandNumb - 1
}

