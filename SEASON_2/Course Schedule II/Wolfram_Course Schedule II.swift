// Wolfram Hwang
// 다풀고 힌트를 보니까 Topology Sort라고 되어있던데
// 저는 그냥 BFS로 했습니다.
// 간단해요

import Foundation

class Solution {
    
    func findOrder(_ numCourses: Int, _ prerequisites: [[Int]]) -> [Int] {
        let layer : [Int] = []
        var parent : [[Int]] = [[Int]](repeating: layer, count: numCourses + 1)
        var visit : [Int] = [Int](repeating: 0, count: numCourses + 1)
        var child : [[Int]] = [[Int]] (repeating: layer, count: numCourses + 1)
        for x in prerequisites {
            parent[x[0]].append(x[1])
            child[x[1]].append(x[0])
        }
        var start = -1
        var q : [Int] = [Int] (repeating: 0, count: numCourses)
        var front = 0
        var rear = 0;
        var ans : [Int] = []
        
        for i in 0..<numCourses {
            if parent[i].count == 0 {
                ans.append(i)
                q[rear] = i
                visit[i] = 1
                rear += 1
            }
        }
        
                    
        while front != rear {
            let now = q[front]
            front += 1
            for x in child[now] {
                if visit[x] == 0{
                    var isOK = false
                    for v in parent[x] {
                        if visit[v] == 0 {
                            isOK = true
                            break
                        }
                    }
                    if isOK == true {
                        continue
                    }
                    visit[x] = 1
                    ans.append(x)
                    q[rear] = x
                    rear += 1
                }
            }
        }
        if ans.count != numCourses {
            return []
        }
        return ans
    }
}
