// Solved by Wolfram Hwang
// 이 문제는 이분탐색으로 해결을 했는데요,
// 처음에 지문이 좀 어려웠다고 해야하나.. 이해가 잘안가서 헤맸습니다.
// 그런데 그냥 생각해보면, 큰 값을 가질수록, 조건에 해당하는게 적어지고,
// 작은값에 가까워질수록 조건에 가까워지지만 찾고자 하는 정답인 가장 큰 수와는 멀어지죠.
// 이런것을 조합했을때, 만약 조건에 부합하다 -> 오른쪽 바운더리로 가서 이분탐색 진행
// 이런식으로 논리를 가꿔 문제를 해결하였습니다.

import Foundation

func binTest(_ citations: [Int], _ val: Int)->Bool{
    var overH: Int = 0
    var underH: Int = 0
    for x in citations{
        if x >= val{
            overH += 1
        }
    }
    if overH >= val{
        return true;
    }
    return false
}
var tempSet: Set<Int> = Set<Int>()
func solution(_ citations:[Int]) -> Int {
    var mid: Int = 0
    var left: Int = 0
    var right: Int = 10000
    var ans: Int = 0
    while left <= right{
        mid = (left + right) / 2
        
        let check = binTest(citations, mid)
        if(check){
            left = mid + 1
            if ans < mid{
                ans = mid
            }
        }else{
            right = mid - 1
        }
    }

    return ans
}
