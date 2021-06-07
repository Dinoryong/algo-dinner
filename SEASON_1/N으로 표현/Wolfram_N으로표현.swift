// Solved by Wolfram Hwang
// DP이긴... 한데..
// 완탐으로도 .. ㅎㅎ;;ㅋㅋ;;ㅈㅅ;;

import Foundation
var ans = 0
let inf = 987654321
let range = 0...8
func dfs(_ N: Int, _ cnt: Int,_ num : Int, _ number: Int ){
    if ans < inf && cnt > ans {
        return
    }
    if cnt > 8 {
        return
    }
    if num == number {
        ans = min(ans, cnt)
        return
    }
    var next = 0
    
    for i in range {
        next = next * 10 + N
        dfs(N, cnt + 1 + i, num + next, number)
        dfs(N, cnt + 1 + i, num - next, number)
        dfs(N, cnt + 1 + i, num * next, number)
        dfs(N, cnt + 1 + i, num / next, number)
    }
}

func solution(_ N:Int, _ number:Int) -> Int {
    if N == number {
        return 1
    }
    ans = inf
    dfs(N, 0, 0, number)
    
    if ans == inf {
        return -1
    }
    return ans
}
