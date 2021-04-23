// Solved by Wolfram Hwang
// 이건 BFS로는 풀기 어려울것 같네요
// 단순하게 재귀를 타고가는데
// 잊지말아야 할 조건이
// 모든 티켓을 써야한다는 겁니다.
// 티켓을 노드로 보셔야 문제를 풀수 있어요.


import Foundation

var ans : [String] = [String]()
var rans : [String] = [String]()
var limit: Int = 0
var graph: [String: [String]] = [String: [String]]()
var visit: [String: [Bool]] = [String: [Bool]]()
 func go(_ now : String, _ count : Int) {
     
     if let arr = graph[now] {
         let len = arr.count         
         for i in 0..<len {
             if visit[now]![i] == false {
                 visit[now]![i] = true
                 ans.append(arr[i])
                 if count + 1 == limit {
                    rans = ans
                     return
                 }  
                 go(arr[i], count + 1)
                 ans.popLast()
                 visit[now]![i] = false
             }
         }
     }
 }
func solution(_ tickets:[[String]]) -> [String] {
    for node in tickets {
        if let arr = graph[node[0]] {
            graph[node[0]]!.append(node[1])
            limit += 1
        }else{
            graph[node[0]] = [node[1]]            
            limit += 1
        }
    }
    for (key, value) in graph {
        graph[key] = value.sorted()
        visit[key] = [Bool](repeating: false, count: graph[key]!.count)
    }
    ans.append("ICN")
    go("ICN", 0)
    return rans
}
