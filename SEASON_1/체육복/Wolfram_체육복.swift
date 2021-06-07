// solved by Wolfram Hwang
// 재귀로 풀었습니다.
// 양 옆에 가질때 안가질때 나누고,
// 순차적으로 앞에가 선택함에 따라 달라지기 떄문에
// 순차적 재귀가 적합하다 판단했습니다.

import Foundation

var classNumb : [Int] = [Int]()
var ans : Int = 0
func recur(_ lost:[Int], _ idx: Int, _ cnt: Int){
    if idx == lost.count{
        if ans < cnt {
            ans = cnt
        }
        return
    }
    let posi = lost[idx]
    if posi + 1 < classNumb.count{
        if classNumb[posi + 1] > 0{
            classNumb[posi + 1] = 0
            recur(lost, idx + 1, cnt + 1)
            classNumb[posi + 1] = 1
        }else{
            recur(lost, idx + 1, cnt)
        }
    }
    if posi - 1 > 0 {
        if classNumb[posi - 1] > 0{
            classNumb[posi - 1] = 0
            recur(lost, idx + 1, cnt + 1)
            classNumb[posi - 1] = 1
        }else{
            recur(lost, idx + 1, cnt)
        }
    }
}

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    classNumb = [Int](repeating: 0, count: n + 1)
    for n in reserve{
        classNumb[n] = 1
    }
    var inpL : [Int] = [Int]()
    for n in lost{
        if classNumb[n] > 0{
            classNumb[n] = 0
        }
        else{
            inpL.append(n)
        }
    }
    recur(inpL, 0, 0)
    ans += (n - inpL.count)
    return ans
}
