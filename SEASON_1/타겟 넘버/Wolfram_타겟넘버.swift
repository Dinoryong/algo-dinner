// Solved By Wolfram Hwang
// BFS나, DFS문제는 아닙니다.
// 단순 재귀문제고, 최대 나올수 있는 가짓수는 2의 20승이네요


import Foundation
var ans: Int = 0
var tg = 0
func calc(_ numbers: [Int], _ idx: Int, _ val: Int){
    if idx == numbers.count {
        if val == tg{
            ans += 1
        }
        return
    }
    calc(numbers, idx + 1, val + numbers[idx])
    calc(numbers, idx + 1, val - numbers[idx])
}

func solution(_ numbers:[Int], _ target:Int) -> Int {
    tg = target
    calc(numbers, 0, 0)
    return ans
}
