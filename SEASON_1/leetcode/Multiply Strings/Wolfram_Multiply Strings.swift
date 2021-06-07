// Solved By Wolfram Hwang
// 저는 이걸 O(N)을 푸는 방법은 모르겠습니다.
// N * M 을 풀었어요.
// 문제의 요는 간단합니다.
// 실제 우리가 초등학교 수학에서 배웠던 곱셈을 적용하면 돼요.

class Solution {
    func multiply(_ num1: String, _ num2: String) -> String {
        var mp : [Character: Int] = [Character : Int]()
        mp["0"] = 0; mp["1"] = 1; mp["2"] = 2; mp["3"] = 3; mp["4"] = 4
        mp["5"] = 5; mp["6"] = 6; mp["7"] = 7; mp["8"] = 8; mp["9"] = 9
        var numbSet : [Int] = [Int](repeating: 0, count: num1.count * num2.count + 3)
        
        var st = 0
        for c1 in num1.reversed() {
            var idx = st
            for c2 in num2.reversed() {
                let nb = mp[c1]! * mp[c2]!
                numbSet[idx] += nb
                if numbSet[idx] >= 10 {
                    var carry = numbSet[idx] / 10
                    var carryidx = idx + 1
                    while true {
                        numbSet[carryidx] += carry
                        if numbSet[carryidx] < 10 {
                            break
                        }
                        carry = numbSet[carryidx] / 10
                        numbSet[carryidx] %= 10
                        carryidx += 1
                    }
                }
                numbSet[idx] %= 10
                idx += 1
            }
            st += 1
        }
        var ret = ""
        var idx = numbSet.count - 1
        var isdigit = false
        while idx >= 0 {
            if isdigit == false && numbSet[idx] != 0 {
                isdigit = true
            }
            
            if numbSet[idx] == 0, isdigit == false {
                idx -= 1
                continue
            }
            ret += String(numbSet[idx])
            idx -= 1
        }
        if ret == ""{
            ret = "0"
        }
        return ret
    }
}

