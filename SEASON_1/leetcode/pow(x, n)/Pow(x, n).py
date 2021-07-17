class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n = n * -1

        output = 1
        while n:
            if n &1:
                output = output * x
            n >>= 1
            x = x*x
        return output