"""
string, two pointer,
"""
# sol.1.pythonic
class Solution:
	def strStr(self, haystack: str, needle: str) -> int:
		if haystack == "" and needle == "":
			return 0
		else:
			if needle in haystack:
				return(haystack.index(needle))
			else:
				return -1

# sol.2.pythonic
class Solution(object):
    def strStr(self, haystack, needle):
        return haystack.find(needle)

# sol.3.
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle or haystack == needle:
            return 0
        len_needle, len_haystack = len(needle), len(haystack)
        if len_needle > len_haystack:
            return -1
        for i in range(len_haystack):
            index = 0
            for j in range(i, i + len_needle):
                if j >= len_haystack:
                    return -1
                if haystack[j] == needle[index]:
                    index += 1
                    continue
                else:
                    break
            if index == len_needle:
                return i
        return -1

# sol.4.two pointers
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        s, e = 0, len(needle) - 1

        while (e < len(haystack)):
            if haystack[s:e + 1] == needle:
                return s
            s += 1
            e += 1
        return -1