"""
[topics]
string

[sketch]
"""
#
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return("")
        if len(strs) == 1:
            return(strs[0])

        pref = strs[0]
        len_p = len(pref)

        for s in strs[1:]:
            while pref != s[0:len_p]:
                pref = pref[0:(len_p-1)]
                len_p -= 1

                if len_p == 0:
                    return("")

        return(pref)
