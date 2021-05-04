// Solved by Wolfram Hwang
// 투포인터로 풀수 있는문제입니다.
// 간단하게 생각하면 Gem 의 모든 보석들을 모두 가질떄까지 앞으로 나갑니다.
// 만약 다 채웠다면, 이제 쓸모 없는것들을 제거해야겠죠.
// 그 때부터 left를 += 1 해주는 겁니다.
// 이러한 방식으로 가장 작은 길이를 찾고, 그에 해당하는 답을 채워나가면 됩니다.

import Foundation

func solution(_ gems:[String]) -> [Int] {
    var Gem: [String: Int] = [String: Int]()
    for gem in gems{
        if let v = Gem[gem] {
            Gem[gem] = 0
        }else{
            Gem[gem] = 0
        }
    }
    var ans = 987654321
    var arr: [Int] = []
    var left = 0
    var right = 0
    var totCnt = 0
    while left <= right{
        if totCnt < Gem.count {
            if right == gems.count {
                break
            }
            if let v = Gem[gems[right]] {
                if v == 0 {
                    totCnt += 1
                }
                Gem[gems[right]] = v + 1
            }
            right += 1
        }else{
            if let v = Gem[gems[left]] {
                if v == 1{
                    totCnt -= 1
                }
                Gem[gems[left]] = v - 1
            }
            left += 1
        }

        if right - left < ans && totCnt == Gem.count{
            ans = right - left
            arr = [left + 1, right]
        }
    }
    return arr
}
