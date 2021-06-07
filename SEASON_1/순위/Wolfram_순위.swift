// Solved by Wolfram Hwang
// 단순한 문제입니다.
// BFS를 써도 좋고, DFS를 써도 상관은 없으나
// 한 노드에서 부모 노드를 타고가는 갯수 + 자식노드를 타고가는 갯수 = 전체 노드 - 1 인 지점만 찾아내면 됩니다.
// 저는 visit배열을 아예 일차원으로만줬는데
// 그냥 n * n 배열을 줘도 됩니다.
// Swift 는 그게 조금 번거로워서 ㅎㅎ

import Foundation
var Parent: [[Int]] = [[Int]]()
var Child: [[Int]] = [[Int]]()
var ans = 0
var childnode = 0
var parentnode = 0
var visitP : [Int] = [Int]()
var visitC : [Int] = [Int]()
func checkC(_ now : Int){
    if Child[now].count == 0 {
        return
    }
    for next in Child[now] {
        if visitC[next] == 0 {
            childnode += 1
            visitC[next] = 1
            checkC(next)
        }
    }
}
func checkP(_ now: Int) {
    if Parent[now].count == 0 {
        return
    }
    for next in Parent[now] {
        if visitP[next] == 0 {
            parentnode += 1
            visitP[next] = 1
            checkP(next)
        }
    }
}

func solution(_ n:Int, _ results:[[Int]]) -> Int {
    var layer :[Int] = [Int]()
    for _ in 0...n {
        Parent.append(layer)
        Child.append(layer)
    }
    for x in results {
        let first = x[0]
        let second = x[1]
        Parent[second].append(first)
        Child[first].append(second)
    }
    for i in 1...n {
        visitC = [Int](repeating: 0, count: n + 1)
        visitP = [Int](repeating: 0, count: n + 1)
        visitC[i] = 1
        visitP[i] = 1
        checkC(i)
        checkP(i)
        if childnode + parentnode == n - 1{
            ans += 1
        }
        childnode = 0
        parentnode = 0
    }

    return ans
}
