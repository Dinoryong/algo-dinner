// solved by Wolfram Hwang
// Upper Bound 문제입니다.
// C++로 할때는 이상하게... 무슨 세트가지고 푼거같은데..
// 아무튼 어퍼바운드임

import Foundation

func solution(_ stones:[Int], _ k:Int) -> Int {
    var min = 987654321
    var max = 0
    for x in stones {
        if x < min{
            min = x
        }
        if x > max{
            max = x
        }
    }
    var start = min
    var end = max
    while start <= end {
        let mid = (start + end) / 2
        var count = 0
        var isCorrect = false
        for x in stones {
            if x <= mid {
                count += 1
            }
            else{
                count = 0
            }
            if count == k {   
                isCorrect = true             
                break
            }
        }
        if isCorrect == true {
            end = mid - 1
        }else{
            start = mid + 1
        }
    }
    let ans = ((start + end) / 2)
    return ans + 1
}
