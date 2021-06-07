// Solved by Wolfram Hwang
// 문제자체는 굉장히 쉬운데
// 짜면서 어떻게 이걸.. 깨끗하고 간결하게 짤수 있을지에 대한 고민이 많이 들게하는 거 같습니다.
// 제가 푼 방식은 Swift는 문자열 에서 하나하나씩 조회도 힘들고, 짜증나는 감이있어서 String배열을 사용해서 해결했구요
// 바뀌는게 여러번 있기에 그냥 배열 두개를 번갈아가면서 사용하게 되었습니다.

import Foundation

func solution(_ new_id:String) -> String {
    //1단계 완.
    let secondId: String = new_id.lowercased()
    var mod1: [String] = [String]()

    for str in secondId {
        mod1.append(String(str))
    }
    let isOK = "0123456789abcdefghijklmnopqrstuvwxyz-_."
    //2단계 new_id에서 알파벳 소문자, 숫자, 
    //빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    var Dic: [String: Int] = [String: Int]()
    for c in isOK{
        Dic[String(c)] = 1
    }
    var mod2: [String] = [String]()

    for c in mod1{
        if let val = Dic[c] {
            mod2.append(c)
        }
    }
    var ispoint = false
    mod1 = [String]()
    for c in mod2{
        if c == "."{
            if ispoint == true{
                continue
            }else{
                ispoint = true
                mod1.append(c)
            }
        }else{
            ispoint = false
            mod1.append(c)
        }
    }
    mod2 = [String]()
    for c in 0..<mod1.count{
        if mod1[c] == "."{
            if c == 0{
                continue
            }
            if c == mod1.count - 1{
                continue
            }  
        }
        mod2.append(mod1[c])
    }
    mod1 = [String]()
    if mod1 == mod2{
        mod2.append("a")
    }
    if mod2.count >= 16{
        for idx in 0..<15{
            if idx == 14 && mod2[idx] == "."{
                continue
            }
            mod1.append(mod2[idx])
        }
        mod2 = mod1
    }

    if mod2.count <= 2{
            let lastC = mod2[mod2.count - 1] 
            while mod2.count != 3{
                mod2.append(lastC)
            }
    }

    var answer: String = ""
    for c in mod2{
        answer += c
    }


    return answer
}
