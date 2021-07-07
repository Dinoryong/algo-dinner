"""
[topics]
two pointer
linear search

[sketch]
1. bruteforce
left pointer, right pointer
square = minimum height * ()
for left in range():
    for right in range():

2. two pointer - how to shift
left pointer , right pointer
update : shift shorter pointer
height(left pointer) == height(right pointer)
| index[left] - index[right] | : break
max area
"""
# sol. bruteforce : O(N^2) => exceed time complexity limits
class Solution:
    def maxArea(self, height: List[int]) -> int:
        # initialize result
        res = 0

        # go through every single case : bruteforce
        # left pointer
        for l in range(len(height)):
            # right pointer
            for r in range(l + 1, len(height)):
                area = (r - 1) * min(height[l], height[r])
                res = max(res, area)

        return res

# sol. two pointer : O(N)
class Solution:
    def maxArea(self, height: List[int]) -> int:
        # initialize
        res = 0
        left, right = 0, len(height) - 1

        while left < right:
            area = (right - 1) * min(height[left], height[right])
            res = max(res, area)

            # update pointer
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return res