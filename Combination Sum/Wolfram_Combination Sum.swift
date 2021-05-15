class Solution {
    var ans : [[Int]] = []
    var layer : [Int] = []
    func go(_ idx : Int, _ value: Int, _ arr: [Int]){
        if value < 0 {
            return
        }
        if value == 0 {
            ans.append(arr)
            return
        }
        var apd = arr
        if value >= layer[idx] {            
            apd.append(layer[idx])
            go(idx, value - layer[idx], apd)
            apd.popLast()
        }
        if idx + 1  < layer.count{
            go(idx + 1, value, apd)
        }
    }
    func combinationSum(_ candidates: [Int], _ target: Int) -> [[Int]] {
        layer = candidates
        if target == 0 {
            return ans
        }
        let lay : [Int] = []
        go(0, target, lay)
        return ans
    }
}
