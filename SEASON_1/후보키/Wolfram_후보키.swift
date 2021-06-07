// Solved by Wolfram Hwang
// 후보키에서 유일성 검증이 꽤나 까다로운 문제입니다.
// 
import Foundation
var row = 0
var col = 0
var arr: [Int] = []
var rel : [[String]] = []
var ans :[Set<Int>] = []
func recur(_ idx: Int, _ cnt : Int) {
    if cnt >= 1 {
        var strs = Set<String>()
        for r in 0..<row {
            var str = ""
            for i in 0..<cnt {
                str += rel[r][arr[i]]
                str += " "
            }
            strs.insert(str)
        }
        if strs.count == row {
            var v = 0
            for i in 0..<cnt {
                v |= (1 << arr[i])
            }
            ans[cnt].insert(v)
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
    
    let ST = Set<Int>()
    ans = [Set<Int>](repeating: ST, count: row + 1)
    recur(0, 0)
    var real : [[Int]] = []
    let input : [Int] = []
    real.append(input)
    for i in 1...row {
        real.append(input)
        for val in ans[i] {
            real[i].append(val)
        }
    }
    
    for i in 1...(row-1) {
        
        for j in 0..<real[i].count {
            if real[i][j] == 0 {
                continue
            }
            for k in (i + 1)...row{
                for l in 0..<real[k].count {
                    if real[i][j] & real[k][l] == real[i][j] {
                        real[k][l] = 0
                    }
                }
            }
        }
    }
    var ret = 0
    for i in 1...row {
        for val in real[i] {
            if val != 0 {
                ret += 1
            }
        }
    }
    return ret
}
