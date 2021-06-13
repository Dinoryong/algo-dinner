class Solution {
    func countAndSay(_ n: Int) -> String {
        if n == 1 {
            return "1"
        }
        var base = "1"
        var count = n
        while count > 1 {
            var next = ""
            var before = ""
            var cnt = 0
            for c in base {
                if before == String(c) {
                    cnt += 1
                }else{
                    if cnt > 0 {
                        next += (String(cnt) + before)
                    }
                    cnt = 1
                    before = String(c)
                }
            }
            next += (String(cnt) + before)
            base = next
            count -= 1
        }
        return base
    }
}
