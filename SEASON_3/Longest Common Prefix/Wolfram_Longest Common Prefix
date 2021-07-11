
class Solution {
    func longestCommonPrefix(_ strs: [String]) -> String {
        let layer : [String] = []
        var map : [[String]] = [[String]](repeating: layer, count: strs.count)
        var cnt = 0
        for i in strs {
            for c in i {
                map[cnt].append(String(c))
            }
            cnt += 1
        }
        var prefix = ""
        var str : [String] = [String](repeating: "", count: strs.count - 1)
        for i in 0..<map[0].count {
            let before = prefix
            prefix += map[0][i]
            for j in 1..<map.count {
                if i >= map[j].count {
                    return before
                }
                str[j - 1] += map[j][i]
                if str[j - 1] != prefix {
                    return before
                }
            }
        }
        return strs[0]
    }
}
