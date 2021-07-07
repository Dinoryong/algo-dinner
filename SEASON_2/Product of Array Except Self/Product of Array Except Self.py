"""
[topics]


[sketch]
1. bruteforce : O(N^2)
0 ~ i - 1, i ,i + 1 ~ len(nums) - 1
multiply except i

2. : O(N)
prefix multi
0 ~ i multiply

default == 1

prefix
postfix
output

store prefix & postfix in output

"""
# : O(N)
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1] * len(nums)

        prefix = 1
        for i in range(len(nums)):
            res[i] = prefix
            prefix *= nums[i]
        postfix = 1
        for i in range(len(nums) - 1, -1, -1):
            res[i] *= postfix
            postfix *= nums[i]
        return res