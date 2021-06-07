/*
Solved by Wolfram hwang
문제 자체가 어렵진 않은데요, 해당 답을 도출하는 과정에서 증명이 귀찮네요.
문제에서 요구하는 요구사항은 다음과 같습니다.
어떠한 두 숫자의 조합중, 더 커지는것을 목표로 하여,
내림차순의 정렬을 요구합니다.
그래서 저는 머지 소트를 사용했고, 비교로 compare함수를 사용했습니다.
*/

import Foundation

func split(data: [Int]) -> [Int] {
    if data.count <= 1 { return data }     //#1
    
    let medium = Int(data.count / 2)    //#2
    
    let left = split(data: Array(data[0..<medium]))     //#3
    let right = split(data: Array(data[medium...]))
    
    return merge(left, right)    //#4
}
func comp(_ val1:Int, _ val2: Int)->Bool{
    let str1:String = String(val1)
    let str2:String = String(val2)
    let comp1 = str1 + str2
    let comp2 = str2 + str1
    let rc1 = Int(comp1)
    let rc2 = Int(comp2)
    if rc1! < rc2!{
        return true
    }
    return false
}

func merge(_ left: [Int], _ right: [Int]) -> [Int] {
    var merged: [Int] = []    //#1
    var leftPoint = 0        //#2
    var rightPoint = 0
    
    //#3
    while left.count > leftPoint, right.count > rightPoint {
        if comp(left[leftPoint], right[rightPoint]) == true{    //#4
            merged.append(right[rightPoint])
            rightPoint += 1
        }else {
            merged.append(left[leftPoint])
            leftPoint += 1
        }
    }
    
    //#5
    while left.count > leftPoint {
        merged.append(left[leftPoint])
        leftPoint += 1
    }
    
    while right.count > rightPoint {
        merged.append(right[rightPoint])
        rightPoint += 1
    }
    
    return merged
}

func solution(_ numbers:[Int]) -> String {
    let List: [Int] = split(data: numbers)
    var answer : String = ""
    for val in List{
        let str: String = String(val)
        if str == "0" && answer == ""{
            continue
        }
        answer += str
    }
    if answer == ""{
        answer = "0"
    }
    return answer
}
