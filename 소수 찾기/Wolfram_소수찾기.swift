// 21/03/24 Solved By Wolfram
// 완전탐색했습니다.
// 1. 재귀로 모든 값을 찾습니다.
// 2. 찾는 값에 중복이 되지 않도록 1차적인 요소로 방문지를 활용했습니다.
// 3. 제대로 되어있는 Value에 따라 값을 소수인지 판단합니다.
// 4. 소수 라면, 그대로 intSet에 insert 해 줍니다.
// 5. 최종적으로 SET에 개수만 리턴하면 답을 구할수 있게 됩니다.

import Foundation

var intSet:Set<Int> = Set<Int>()
var str: String = ""
var isVisit:[Int] = [Int]()

func isPrime(_ P: Int) -> Bool{
    var idx = 2
    while ((idx * idx) <= P){
        if P % idx == 0{
            return false
        }
        idx += 1
    }
    return true
}

func recur(_ cnt: Int, _ value: String?){
    if cnt > str.count{
        return
    }
    if let val = value {
        if let V = Int(val){
            if V > 1 && isPrime(V){
                intSet.insert(V)
            }
        }
    }
    var idx = 0
    for s in str{
        if isVisit[idx] == 0{
            isVisit[idx] = 1
            recur(cnt + 1, value! + String(s))
            isVisit[idx] = 0
        }
        idx = idx + 1
    }
}

func solution(_ numbers:String) -> Int {
    
    str = numbers
    for _ in numbers{
        isVisit.append(0)
    }
    recur(0, "")
    print(intSet)
    return intSet.count
}

