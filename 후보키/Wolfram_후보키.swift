// Solved by Wolfram Hwang
// 단순 재귀 문제입니다.
import Foundation
var row = 0
var col = 0
var arr: [Int] = []
var rel : [[String]] = []
var ans = 0
func recur(_ idx: Int, _ cnt : Int) {
    if cnt >= 1 {
        var strs = Set<String>()
        for r in 0..<row {
            var str = ""
            for i in 0..<cnt {
                str += rel[r][arr[i]] 
            }
            strs.insert(str)
        }
        if strs.count == row {
            ans += 1
            return
        }
    }
    if idx >= col {
        return
    }
    arr[cnt] = idx
    recur(idx + 1, cnt + 1)
    arr[cnt] = 0
    recur(idx + 1, cnt)
}
func solution(_ relation:[[String]]) -> Int {
    row = relation.count
    col = relation[0].count
    arr = [Int](repeating: 0, count: col)
    rel = relation
    recur(0, 0)
    return ans
}
