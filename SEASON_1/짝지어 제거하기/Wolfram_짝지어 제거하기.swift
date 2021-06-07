import Foundation
func solution(_ s:String) -> Int{
    var answer:Int = -1
    var str : [Character] = []
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    for c in s {
        if str.count == 0 {
            str.append(c)
        }
        else if str[str.count - 1] == c {
            str.popLast()
        }else{
            str.append(c)
        }
    }
    if str.count == 0 {
        return 1
    }
    else {
        return 0
    }
}
