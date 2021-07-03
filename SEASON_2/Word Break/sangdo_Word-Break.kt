var dp = Array<Boolean>(300){false}
class Solution {
    fun dfs(i: Int, wordDict: List<String>, s:String): Boolean{
        if(i == s.length) return true
        if(dp[i]) return false
        dp[i] = true
        for(w in wordDict) {
            if(i + w.length <= s.length && s.substring(i, i+w.length) == w) {
                if(dfs(i+w.length, wordDict, s)) return true
            }
        }
        return false
    }
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        dp = Array<Boolean>(300){false}
        return dfs(0,wordDict, s)
    }
}
