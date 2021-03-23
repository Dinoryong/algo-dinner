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
