// Solved by Wolfram Hwang
// 간단한 탐욕법인 Minimum spanning Tree입니다.
// 최소 가중치를 구하는 문제이니 
// 먼저 가중치에 따라 정렬을 오름차순으로 합니다.
// 그리고 (노드, 노드, 가중치) 를 하나씩 보면서, 연결 되어있는지 확인하며
// 만약 연결이 되어있다면 더이상 연결할필요 가없으며
// 만약 반대로 연결이 안되어 있다면, 연결할 필요가있고 해당 가중치는 사용해야하므로 ans에 +하게 됩니다.

import Foundation
var parent: [Int] = [Int]()
func ischeck(_ node1: Int, _ node2: Int)->Bool {
    var nodeA = node1
    while nodeA != parent[nodeA] {
        let old = nodeA
        nodeA = parent[nodeA]
        parent[old] = nodeA
    }
    var nodeB = node2
    while nodeB != parent[nodeB] {
        let old = nodeB
        nodeB = parent[nodeB]
        parent[old] = nodeB
    }
    
    if nodeA != nodeB {
        if nodeA < nodeB {
            parent[nodeB] = nodeA
        }else{
            parent[nodeA] = nodeB
        }
        return false
    }
    return true
}
func solution(_ n:Int, _ costs:[[Int]]) -> Int {
    let cost = costs.sorted{ (v1, v2) -> Bool in
        return v1[2] < v2[2]
    }
    //parent = [Int](repeating: 0, count: n + 1)
    print(parent)
    let range = 0..<n
    for i in range {
        parent.append(i)
    }
    var ans = 0
    for i in 0..<cost.count {
        if ischeck(cost[i][0], cost[i][1]) == false {
            ans += cost[i][2]
        }
    }
    return ans
}


