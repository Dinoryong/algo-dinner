class Solution {
    func grayCode(_ n: Int) -> [Int] {
        var ret : [Int] = []
        var i = 0
        while i < (1 << n) {
            ret.append(i ^ (i >> 1))
            i += 1
        }
        return ret
    }
}
