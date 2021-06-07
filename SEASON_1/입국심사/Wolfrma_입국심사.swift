// Solved by Wolfram Hwang
// start = 0, end = 최대 걸릴수 있는 시간.. n * 최대 입국심사장
// sum += 에는 걸릴 시간 한정 / 해당입국심사장검사시간 
// 해 나가면서, 만약 더 작으면 나누고 커도 나누고.. 이런식으로..


import Foundation

func solution(_ n:Int, _ times:[Int]) -> Int64 {
    let time = times.sorted(by: <)
    var end: Int64 = Int64(time[time.count - 1]) * Int64(n)
    var start: Int64 = 0
    var ans:Int64 = 9876543219
    while start <= end {
        var mid = (start + end) / 2
        var sum: Int64 = 0
        for x in time {
            sum += (mid / Int64(x))
            if sum > n {
                break
            }
        }
        if n <= sum {
            ans = mid
            end = mid - 1
        }
        else{
            start = mid + 1
        }
    }
    
    return ans
}
