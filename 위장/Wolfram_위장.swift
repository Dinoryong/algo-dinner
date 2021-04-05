// Solved by Wolfram Hwang 21/04/05
// 문제가 굉장히 간단합니다.
// 일반적으로 파이썬이나, JAVA, 제가 쓰는 Swift까지
// 전부 MAP 이나, Dictionary 형태로 아마 구조는 RB+-이겠으나
// 해시에 준하는 STL을 내장하고있기때문에
// 특정 아이템에 대하여 (실제 쓸 것) : (장착 부위) 로 맞추어 보았을때
// 장착 부위를 Key로 하여, 실제 쓸것은 유일하기에 그냥 갯수로 카운팅을 해서 올리면 
// 부위의 전체갯수 + 1(입지 않을 경우 고려함) 한것을 계속 곱해나가면 됩니다.
// 다만 주의할것은 다 입지 않는 경우는 없기에, 최종에서 1을 빼주면 깔끔한 Solution이 되는 것입니다.
,
import Foundation

func solution(_ clothes:[[String]]) -> Int {
    var map: [String: Int] = [String : Int] ()
    for substr in clothes {
        if let val = map[substr[1]] {
            map[substr[1]] = val + 1
        }else{
            map[substr[1]] = 1
        } 
    }
    var ans: Int = 0
    for item in map { 
        if ans == 0 { 
            ans = (item.value + 1)
        }else{
            ans *= (item.value + 1)
        }
    }
    return ans - 1
}
