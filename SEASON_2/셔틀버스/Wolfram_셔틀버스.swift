// Solved by Wolfram Hwang

func solution(_ n:Int, _ t:Int, _ m:Int, _ timetable:[String]) -> String {
    var arr: [(Int, Int)] = [(Int, Int)]()
    for val in timetable {
        let HM = val.split(separator: ":")
        let H = Int(HM[0])!
        let M = Int(HM[1])!
        arr.append((H, M))
    }
    arr = arr.sorted {
        if $0.0 < $1.0 {
            return true
        }else if $0.0 == $1.0 {
            return $0.1 < $1.1
        }else {
            return false
        }
    }
    var cur = 9 * 60
    var idx = 0
    for i in 0..<n-1 {
        for j in 0..<m {
            if arr[idx].0 * 60 + arr[idx].1 <= cur {
                idx += 1
            }
        }
        cur += t
    }
    for i in 0..<m-1 {
        if arr[idx].0 * 60 + arr[idx].1 <= cur {
            idx += 1
            if idx == arr.count {
                break
            }
        }
    }
    var temp = 0
    if idx >= arr.count {
        temp = cur
    }else if arr[idx].0 * 60 + arr[idx].1 <= cur {
        temp = arr[idx].0 * 60 + arr[idx].1 - 1
    }
    else{
        temp = cur
    }

    var hh = temp / 60
    var mm = temp % 60
    var answer = ""
    if hh < 10 {
        answer += "0"
    }
    answer += String(hh) + ":"
    if mm < 10 {
        answer += "0"
    }
    answer += String(mm)
    return answer
}
