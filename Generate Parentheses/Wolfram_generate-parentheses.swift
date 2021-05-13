class Solution {
    var ans : [String] = []
    var limit : Int = 0
    func genfunc(_ str: String, _ left: Int, _ right: Int){
        if right == limit {
            ans.append(str)
            return
        }
        if right + 1 <= left {
            genfunc(str + ")", left, right + 1)
        }
        if left + 1 <= limit {
            genfunc(str + "(" , left + 1, right)
        }
    }
    func generateParenthesis(_ n: Int) -> [String] {
        limit = n
        genfunc("", 0, 0)
        return ans
    }
}
