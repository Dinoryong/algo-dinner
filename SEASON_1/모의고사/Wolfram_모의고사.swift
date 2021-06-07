// 21.03.23 Solved By Wolfram Hwang
// 정말 너무 귀찮아서 다 일일이 했어요.
// 논리는 간단합니다 , 모의고사 찍는 규칙을 토대로 하여, 반복문으로 돌면서 확인하는 방식인데요,
// 근데 각각 반복되는 찍기의 주기가 다르니, 각각 따로 주기를 설정해줘서 체크해주는방식을 차용했습니다.
// 감사합니다.
import Foundation

func solution(_ answers:[Int]) -> [Int] {
    let first: [Int] = [1,2,3,4,5]
    var idx1:Int = 0
    let second: [Int] = [2,1,2,3,2,4,2,5]
    var idx2: Int = 0
    let third: [Int] = [3,3,1,1,2,2,4,4,5,5]
    var idx3: Int = 0
    
    var answer: [Int] = [0,0,0]
    var MX = 0
    for ans in answers{
        if ans == first[idx1]{
            answer[0] += 1
            if MX < answer[0]{
                MX = answer[0]
            }
        }
        if ans == second[idx2]{
            answer[1] += 1
            if MX < answer[1]{
                MX = answer[1]
            }
        }
        if ans == third[idx3]{
            answer[2] += 1
            if MX < answer[2]{
                MX = answer[2]
            }
        }
        idx1 += 1
        idx1 %= first.count
        idx2 += 1
        idx2 %= second.count
        idx3 += 1
        idx3 %= third.count
    }
    var idx = 0
    var ret:[Int] = [Int]()
    for ans in answer{
        if MX == ans{
            ret.append(idx + 1)
        }
        idx += 1
    }
    return ret
}
