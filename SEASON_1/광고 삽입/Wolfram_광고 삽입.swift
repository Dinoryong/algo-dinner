// Solved by Wolfram Hwang
// 처음에는 투포인터 같은 느낌도, 바이너리 서칭같은 느낌도 있었습니다.
// 굳이 log n이 아니더라도 N으로 줄일방법은 없는지 고민해봤는데
// 누적합 을 두번하면 시간까지 알수있지않나...? 라는 생각이 들어서.. 해봤어요
// 누적합을 처음 적용하게되면, 횟수를.
// 횟수를 차례대로 더해나가면 실제 사용한 시간초에 대해서 알수있겠죠
// 이러한 방법으로 문제를 해결하였습니다.

import Foundation
func timeToInt(_ time: String)->Int{
    var ret = 0
    let date = time.split(separator: ":")
    let h = Int(date[0])
    let m = Int(date[1])
    let s = Int(date[2])
    ret = (h! * 60 * 60) + (m! * 60) + s!
    return ret
}
func intToTime(_ int: Int)->String {
    let h = (int / 3600)
    let m = ((int % 3600) / 60)
    let s = int - (h * 3600) - (m * 60)
    var hh = String(h)
    var mm = String(m)
    var ss = String(s)
    while hh.count < 2 {
        hh = "0" + hh
    }
    while mm.count < 2{
        mm = "0" + mm
    }
    while ss.count < 2 {
        ss = "0" + ss
    }
    return "\(hh):\(mm):\(ss)"
}
func solution(_ play_time:String, _ adv_time:String, _ logs:[String]) -> String {
    let pTime = timeToInt(play_time)
    let adTime = timeToInt(adv_time)
    var timeline = [Int](repeating: 0, count: pTime + 2)
    var log: [(Int, Int)] = [(Int, Int)]()
    for str in logs {
        let inp = str.split(separator: "-")
        let pair = (timeToInt(String(inp[0])), timeToInt(String(inp[1])))
        log.append(pair)
    }
    for x in log {
        timeline[x.0] += 1
        timeline[x.1] -= 1
    }
    //횟수..
    for i in 1...pTime {
        timeline[i] += timeline[i - 1]
    }
    
    for i in 1...pTime {
        timeline[i] += timeline[i - 1] //누적 시간
    }
    var s = 0
    var e = adTime
    var ans = (0, Int.max)
    for i in 0..<pTime{
        let adpoint = i + adTime - 1
        var logIdx = adpoint
        if adpoint >= pTime{
            logIdx = pTime - 1
        }
        var logIdx2 = i - 1
        if i - 1 < 0 {
            logIdx2 = 0
        }
        let len = timeline[logIdx] - timeline[logIdx2]
        if len > ans.0 {
            ans = (len, i)
        }
    }
    return intToTime(ans.1)
}

