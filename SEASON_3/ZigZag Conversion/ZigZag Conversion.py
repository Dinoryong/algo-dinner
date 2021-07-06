"""
string
"""
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows <= 1 :
            return s

        n = len(s)
        arr = [""]*numRows

        dr = 1
        x = 0

        for i in range(n) :

            arr[x] += s[i]
            x += dr

            if x == numRows-1 or x == 0 :
                dr *= -1

        ans = ""

        for i in range(numRows) :
            ans += arr[i]

        return ans