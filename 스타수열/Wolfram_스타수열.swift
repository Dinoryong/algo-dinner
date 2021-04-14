// Solved by Woflram Hwang
// DP같아보이긴한데..
// DP와는 조금ㄷ ㅏ른?..
// 그냥 하나하나 하면서 갱신해주면 됨 쉬움

import Foundation

func solution(_ a:[Int]) -> Int {
    var ans = -1
    var use: [Int] = [Int](repeating: -1, count : a.count + 10)
    var dp :[Int] = [Int](repeating: 0, count : a.count + 10)
    for i in 0..<a.count {
        if (i > 0) && (a[i] != a[i-1]) && (use[a[i]] != i-1){
            dp[a[i]] += 2
        }else if (i < a.count - 1) && (a[i] != a[i+1]){
            dp[a[i]] += 2
            use[a[i]] = i + 1
         }
    }

    for i in 0..<a.count {
        if(ans < dp[i]) {
            ans = dp[i];
        }
    }
    return (ans)
}
