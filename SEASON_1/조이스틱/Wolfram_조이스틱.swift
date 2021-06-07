// Solved By Wolfram Hwang
// 간단한듯 하면서 빡치는 문제입니다.
// 11번 테스트 케이스때문에 화나서 1시간 넘게 투자했어요.
// 논리는 그냥 DFS입니다. 마치 탐욕법 같은..
// 제일 가까운 거리와, 그리고 알파벳 거리에 따라 해주시면 됩니다.
// 아직까지 스위프트 언어에 익숙하지가 않아서 어려웠네요.
import Foundation
var alpDicUp:[Character: Int] = [Character:Int]()
var alpDicDown: [Character: Int] = [Character: Int]()
var NAME:[Int] = [Int]()
var visit: [Int] = [Int]()
var ans: Int = 987654321
func recur(_ idx: Int, _ val: Int, _ cnt: Int){
    if cnt == NAME.count{
        if val < ans{
            ans = val
        }
        return
    }
    for i in 0..<NAME.count{
        if visit[i] == 0{
            visit[i] = 1
            var big = 0, short = 0
            if i < idx{
                big = idx
                short = i
            }else{
                big = i
                short = idx
            }
            var firstLen = big - short
            short += NAME.count
            let secondLen = short - big
            if firstLen > secondLen{
                firstLen = secondLen
            }
            recur(i, val + firstLen + NAME[i], cnt + 1)
            
            visit[i] = 0
        }
    }
}

func solution(_ name:String) -> Int {
    let str =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    let str2 = "ZYXWVUTSRQPONMLKJIHGFEDCBA"
    var idx = 0
    for c in str{
        alpDicUp[c] = idx
        idx += 1
    }
    idx = 0
    for c in str2{
        if c == "A"{
            alpDicDown[c] = 0
            break
        }
        alpDicDown[c] = idx + 1
        idx += 1
    }
    var dummy : [Int] = [Int] ()
    var cnt = 0
    for c in name{
        let val1 = alpDicUp[c]!
        let val2 = alpDicDown[c]!
        if c == "A"{
            visit.append(1)
            cnt += 1
        }
        else{
            visit.append(0)
        }
        dummy.append(0)
        if val1 < val2{
            NAME.append(val1)
        }else{
            NAME.append(val2)
        }
    }
    visit[0] = 1
    if NAME[0] == 0{
        cnt -= 1
    }
    recur(0, NAME[0], cnt + 1)
    let answer = ans
    return answer
}
