import Foundation

func solution(_ absolutes:[Int], _ signs:[Bool]) -> Int {
    var idx = 0
    var ret = 0
    while idx < absolutes.count {
        if signs[idx] == false{
            ret -= absolutes[idx]
        }else{
            ret += absolutes[idx]
        }
        idx += 1
    }
    return ret
}
