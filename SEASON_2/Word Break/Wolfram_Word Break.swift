// Solved by Wolfram Hwang
// 간단한 재귀문제네요
class Solution {
    var str : [String] = []
    var dict : [String: [String]] = [String: [String]]()
    var visit : [Int] = [Int]()
    var ans  = false
    func go(_ idx : Int) {
        if ans == true {
            return
        }
        if idx >= str.count {
            ans = true
            return
        }
        if let arr = dict[str[idx]] {
            for st in arr {
                let len = st.count
                if idx + len > str.count {
                    continue
                }
                var comp = ""
                for i in idx..<(idx + len) {
                    comp += str[i]
                }
                if comp == st, visit[idx + len] == 0{
                    visit[idx + len] = 1
                    go(idx + len)
                }
            }
        }
    }
    func wordBreak(_ s: String, _ wordDict: [String]) -> Bool {
        var set : Set<String> = Set<String>()
        visit = [Int](repeating : 0, count : s.count + 1)
        for st in wordDict {
            for ss in st {
                set.insert(String(ss))
            }
            for c in st {
                
                if let v = dict[String(c)] {
                    dict[String(c)]?.append(st)
                }else{
                    dict[String(c)] = [st]
                }
                break
            }
        }
        for c in s {
            str.append(String(c))
            if set.contains(String(c)) == false {
                return false
            }
        }
        for (key, value) in dict {
            dict[key] = value.sorted {
                $0.count < $1.count
            }
        }
        go(0)
        return ans
    }
}
