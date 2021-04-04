// Solved by Wolfram Hwang
// 문제 풀이에 트라이 개념을 사용해야 하나? 라는 궁금증이 들었던 문제입니다.
// 작년에 해당 문제를 풀때는 트라이를 사용했던것같아요
// 근데 이번에는 어차피 따져야하는 컬럼이 4개, 총 가지수 16개에
// 50000* 16 = 80만의 숫자를 가지고 맵핑해서 만드는것도 괜찮겠다 싶었습니다.
// 하여, 모든 이름의 조합에 해당하는 [String: [배열]] 맵을 만들었고
// 하나하나 타고가면서, 정렬을 해준뒤에
// 쿼리 하나씩 조회할때 나오는 문자열 -> 맵 타고가서 해당 배열에서의
// lower bound의 인덱스와 배열 사이즈를 비교하여 answer에 append해주었습니다.

import Foundation
var dic:[String: [Int]] = [String: [Int]]()

func recur(_ arr: [String], _ idx: Int, _ ret: String, _ point : Int) {
    if idx == arr.count - 1 {
        if let Iarr = dic[ret] {
            dic[ret]?.append(point)
        }else{
            dic[ret] = [Int]()
            dic[ret]?.append(point)
        }
        return
    }
    
    recur(arr, idx + 1, ret + arr[idx], point)
    recur(arr, idx + 1, ret, point)
}

func solution(_ info:[String], _ query:[String]) -> [Int] {
    for str in info{
        let arr = str.split(separator: " ")
        var inp: [String] = [String]()
        for st in arr {
            inp.append(String(st))
        }
        let before = inp[inp.count - 1]
        if let val = Int(before) {
            recur(inp, 0, "" , val)
        }
    }
    for item in dic {
        dic[item.key] = item.value.sorted()
    }
    var answer: [Int] = [Int]()
    for q in query {
        let sb = q.split(separator: " ")
        var key : String = ""
        for i in 0..<sb.count - 1 {
            let c = String(sb[i])
            if c == "-" || c == "and"{
                continue
            }
            key += c
        }
        //print(key)
        let before = String(sb[sb.count - 1])
        let val = Int(before)
        if let arr = dic[key]{
            if arr[arr.count - 1] < val! {
                answer.append(0)
                continue
            }
            if arr[0] >= val! {
                answer.append(arr.count)
                continue
            }
            var start = 0
            var end = arr.count - 1
            while end > start {
                let mid = (start + end) / 2
                if arr[mid] >= val! {
                    end = mid
                }else{
                    start = mid + 1
                }
            }
            answer.append(arr.count - end)
        }else{
            answer.append(0)
        }
        //print(sb)
    }
    //print(dic)
    return answer
}
