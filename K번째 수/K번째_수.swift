// Solved by WolframHwang 21/03/23
// 문제에서 특정한 알고리즘 사용은 필요가 없어서 사용하지 않았습니다.

import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    var ret: [Int] = [Int]()
    
    for cmd in commands{
        var arr = array[(cmd[0] - 1)..<cmd[1]]
        let convertArr = arr.sorted()        
        ret.append(convertArr[cmd[2] - 1])
    }
    
    
    return ret
}
