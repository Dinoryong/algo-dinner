// Solved by Wolfram Hwang
// 문제의 요지는 간단합니다.
// i * j <= m 을 만족하는 누적값을 구합니다.
// 그리고 그것이 작다면 위로 크다면 아래로
// 왔다갔다하면서 이분탐색하면됩니다.


import Foundation

let n = Int(readLine()!)!
let k = Int(readLine()!)!
var left = 1; var right = k
var ans = 0
while left <= right {
    var cnt = 0
    let mid = (left + right) / 2
    for i in 1...n {
        cnt += min(mid / i, n)
    }
    if cnt < k {
        left = mid + 1
    }else{
        ans = mid
        right = mid - 1
    }
}
print(ans)
