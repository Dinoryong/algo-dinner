// Solved by Wolfram Hwang
// 브루트 포스입니다.
// 조금 머리를 쓰는방법은
// 문자의 half 길이가 최대 압축길이이니
// 그것에 따라 압축을 해 나가면 됩니다.
import Foundation

func solution(_ s:String) -> Int {    
    var answer = "123"
    var len = s.count / 2
    var str : [String] = []
    for c in s {
        str.append(String(c))
        answer += "1"
    }
    if(s.count == 1){
        return 1
    }
    while len > 0 {
        var dic: [String: [Int]] = [String:[Int]]()
            var before = ""
            for i in 0...((s.count / len)) {
                var left = len * i
                var right = len * (i + 1)
                var temp = ""
                for j in left..<right {
                    if str.count <= j {
                        break
                    }
                    temp += str[j]
                }
                if before != temp {
                    if var v = dic[temp] {
                        v.append(1)
                        dic[temp] = v
                    }else{
                        dic[temp] = [1]
                    }
                }else{
                    if var v = dic[temp] {
                        v[v.count - 1] += 1
                        dic[temp] = v
                    }else{
                        dic[temp] = [1]
                    }
                }                                              
                before = temp
            }
            var tempans = ""
            for (key, value) in dic {                
                for val in value {
                    if val == 1{
                        tempans += key
                    }else{
                        tempans += (String(val) + key)
                    }
                }
            }
            if tempans.count < answer.count {
                answer = tempans
            }
        len -= 1
    }
    return answer.count
}
