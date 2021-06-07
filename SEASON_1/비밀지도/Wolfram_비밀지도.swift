func solution(_ n:Int, _ arr1:[Int], _ arr2:[Int]) -> [String] {
    var answer: [String] = []
    var map : [Int] = []
    var idx = 0
    while idx < arr1.count {
        let val = arr1[idx] | arr2[idx]
        map.append(val)
        idx += 1
    }
    
    for val in map {
        var str = ""
        var j = n - 1
        while j >= 0 {
            if val & (1 << j) == 0 {
                str += " "
            }else{
                str += "#"
            }
            j -= 1
        }
        answer.append(str)
    }
    return answer
}

