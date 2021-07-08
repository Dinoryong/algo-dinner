// 비트로 풀다가 말았음


class Solution {
    static let pow = 17
    static let mod = 1000000007

    func strStr(_ haystack: String, _ needle: String) -> Int {
        if needle.isEmpty { return 0 }
        if haystack.isEmpty || haystack.count < needle.count { return -1 }
        let csn: [Int] = needle.utf8.map { Int($0) }
        let cs: [Int] = haystack.utf8.map { Int($0) }
        var hayHash = 0
        var needleHash = 0
        var pow2 = 1
        for i in 0..<needle.count {
            hayHash = hayHash * Solution.pow
            hayHash = (cs[i] + hayHash) % Solution.mod
            needleHash = needleHash * Solution.pow
            needleHash = (csn[i] + needleHash) % Solution.mod
            pow2 = pow2 * Solution.pow % Solution.mod
        }
        if hayHash == needleHash { return 0 }
        var i = 0
        for j in needle.count..<haystack.count {
            hayHash = hayHash * Solution.pow % Solution.mod
            hayHash = hayHash - (cs[i] * pow2) % Solution.mod
            if hayHash < 0 { hayHash += Solution.mod }
            hayHash = (hayHash + cs[j]) % Solution.mod
            i += 1
            if hayHash == needleHash { return i }
        }
        return -1
    }
}
