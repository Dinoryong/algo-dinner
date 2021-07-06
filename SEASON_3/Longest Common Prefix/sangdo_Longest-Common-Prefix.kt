class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var res = 0
        var len = 0x3f3f3f3f
        strs.forEach{len = Math.min(len,it.length)}
        
        for(i in 0 until len){
            var same = true
            var c = strs[0][i]
            strs.forEach{if(it[i] != c) same = false}
            if(same == false) return strs[0].substring(0,i)
        }
        return strs[0].substring(0, len)
    }
}
