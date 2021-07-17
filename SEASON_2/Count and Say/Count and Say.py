class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        prev = self.countAndSay(n-1)
        res = ""
        cnt = 1
        for i in range(len(prev)):
            if i == len(prev) -1 or prev[i] != prev[i+1]:
                res += str(cnt) + prev[i]
                cnt = 1
            else:
                cnt += 1
        return res