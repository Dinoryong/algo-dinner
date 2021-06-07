// solved by Wolfram Hwang
// 누적 합의 향연
// swift라 용량이 엄청크게나오네요..


func solution(_ lines:[String]) -> Int {
    
    var arr1 : [Int] = [Int](repeating: 0, count: 86400002)
    var arr2 : [Int] = [Int](repeating: 0, count: 86400002)
    let limit = 86400000
    for x in lines {
        let dayInfo = x.split(separator: " ")
        let time = dayInfo[1]
        var overtime = ""
        for str in dayInfo[2]{
            if str == "s"{
                break
            }
            overtime += String(str)
        }
        let endInfo = Double(overtime)! * 1000
        let end = Int(endInfo)
        let timeInfo = time.split(separator: ":")
        let h = Int(timeInfo[0])! * 60 * 60 * 1000
        let m = Int(timeInfo[1])! * 60 * 1000
        let ss = Double(timeInfo[2])! * 1000
        let s = Int(ss)
        let info = h + m + s
        arr2[info] += 1
        //print(info)
        if info - end + 1 < 0 {
            arr1[0] += 1
        }else{
            arr1[info - end + 1] += 1    
        }
        //print(info - end + 1)
    }
    var left = 0
    var right = 0
    var sum = 0
    var ans = 0
    while right < 1000 {
        if arr1[right] > 0 {
            sum += arr1[right]
        }
        right += 1
    }
    if sum > ans {
        ans = sum
    }
    if arr2[left] > 0 {
        sum -= arr2[left]
    }
    while right < limit {
        right += 1
        left += 1
        if arr1[right] > 0 {
            sum += arr1[right]
        }
        if arr2[left] > 0 {
            sum -= arr2[left]
        }        
        if sum > ans {
            ans = sum
        }        
    }
    print(sum)
    return ans
}
