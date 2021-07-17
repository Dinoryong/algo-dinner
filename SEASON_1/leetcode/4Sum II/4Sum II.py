class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        cnt = 0
        m = {}
        for a in A:
            for b in B:
                m[a + b] = m.get(a + b, 0) + 1
        for c in C:
            for d in D:
                cnt += m.get(-(c + d), 0)
        return cnt