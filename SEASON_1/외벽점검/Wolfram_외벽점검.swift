// Not solved by Wolfram Hwang
// Solved by ByoungHwi in Programmers
// 그리디인줄알고 세그트리로 했다가 틀렸습니다.
// 완전탐색으로 풀려고했는데 코드짜기 너무귀찮아서.. 그냥..

import Foundation

func solution(_ n:Int, _ weak:[Int], _ dist:[Int]) -> Int {
    var record: [Set<[Int]>] = [[weak]]
    var dist = dist
    if dist.last! >= n {
        return 1
    }
    for count in 1...dist.count {
        if weak.count == count { return count }
        let movable = dist.popLast()!
        var remainWeaks: Set<[Int]> = []
        for weakList in record[count-1] {
            for weakIndex in 0..<weakList.count {
                let start = weakList[weakIndex]
                let end = start + movable
                var over = end - n
                over = max(-1, over)
                let remained = weakList.filter {
                    return !((start...end) ~= $0 || (-1...over) ~= $0  )
                }
                if (remained.count == 0){ return count }
                remainWeaks.insert(remained)
            }
        }
        record.append(remainWeaks)
    }
    return -1
}
