
// solved by Wolfram Hwang 21/03/30
// 탐욕법입니다.
// 어차피 앞자리부터 제일 큰놈을 채우면 되겠다 싶었어요
// 근데, 처리 하나 해준것중에, 어차피 9면 더이상 안찾아도 되거든요
// 그거만 나중에 처리해줬습니다.

import Foundation

func solution(_ number:String, _ k:Int) -> String {
    let Len = number.count - k
    var num : [Int] = [Int]()
    for c in number{
        let n = Int(String(c))!
        num.append(n)
    }
    let start = k
    let last = number.count
    var left : Int = 0
    var right : Int = 0
    var ans: String = ""
    var cnt: Int = 0
    for i in start..<last{
        right = i
        var MX = num[i]
        var MIDX = i
        for j in left..<right{
            var comp = num[j]
            if MX == 9 && MIDX != i{
                break
            }
            if MX < comp{
                MX = comp
                MIDX = j
            }
            else if MX == comp && MIDX > j{
                MIDX = j
            }
        }
        ans += String(MX)
        left = MIDX + 1
    }
    return ans
}
// 100072613 3 172613
