// Solved by Wolfram Hwang
// 단순 재귀

import Foundation

class Solution {
    var map : [Character : [Character]] = [Character : [Character]]()
    var ans : [String] = []
    func recur(_ str: String, _ idx : Int, _ input : [Character]) {
        if idx == input.count {
            ans.append(str)
            return
        }
        let range = 0..<map[input[idx]]!.count
        for i in range {
            recur(str + String(map[input[idx]]![i]), idx + 1, input)
        }
    }
    func letterCombinations(_ digits: String) -> [String] {
        map["1"] = []
        map["2"] = ["a","b","c"]
        map["3"] = ["d","e","f"]
        map["4"] = ["g","h","i"]
        map["5"] = ["j","k","l"]
        map["6"] = ["m","n","o"]
        map["7"] = ["p","q","r","s"]
        map["8"] = ["t","u","v"]
        map["9"] = ["w","x","y","z"]
        var char : [Character] = []
        for c in digits {
            char.append(c)
        }
        if digits.count != 0 {
            recur("", 0, char)
        }
        return ans
    }
}
