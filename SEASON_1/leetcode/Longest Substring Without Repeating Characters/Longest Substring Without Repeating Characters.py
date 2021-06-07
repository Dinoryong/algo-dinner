"""
[python]
ord 내장함수 <-> chr 내장함수

[concept]
1.Brute Force

2.Sliding Window

3.Hash Map
"""
# sol.2.Sliding Window
# 다 체크하지말고, 
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        chars = [0] * 128

        left = right = 0

        res = 0
        while right < len(s):
            r = s[right]
            chars[ord(r)] += 1

            while chars[ord(r)] > 1:
                l = s[left]
                chars[ord(l)] -= 1
                left += 1

            res = max(res, right - left + 1)

            right += 1
        return res