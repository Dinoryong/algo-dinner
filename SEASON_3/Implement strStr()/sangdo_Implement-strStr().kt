class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if(needle.length ==0) return 0
        var kmp = IntArray(needle.length)
        kmp[0] = 0
        var j = -1
        for(i in needle.indices) {
            kmp[i] = j
            while(j != -1 && needle[j] != needle[i]) j = kmp[j]
            ++j
        }
        j = 0
        for(i in haystack.indices) {
            while(j!= -1 && haystack[i] != needle[j]) j = kmp[j]
            ++j
            if(j == needle.length) return i-needle.length+1
        }
        return -1
    }
}
