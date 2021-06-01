"""
Array
Binary Search

sol.1
brute force -> complexity issue (문제 볼 때, 항상 먼저 complexity 먼저 확인하자)

sol.2
binary search
1. begin, mid, end 설정
2. binary search 하면서 버리고 , mid로 begin과 end 옮기기
3. begin >= end 까지 반복

python : bisect
"""
#
class Solution:
    # 이 부분을 새로 만들음, self 해서는 처음 풀었다,
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        lower_bound = self.findBound(nums, target, True)
        if (lower_bound == -1):
            return [-1, -1]

        upper_bound = self.findBound(nums, target, False)

        return [lower_bound, upper_bound]

    def findBound(self, nums: List[int], target: int, isFirst: bool) -> int:

        N = len(nums)
        begin, end = 0, N - 1
        while begin <= end:
            mid = int((begin + end) / 2)

            if nums[mid] == target:

                if isFirst:
                    if mid == begin or nums[mid - 1] < target:
                        return mid

                    end = mid - 1
                else:

                    if mid == end or nums[mid + 1] > target:
                        return mid

                    begin = mid + 1

            elif nums[mid] > target:
                end = mid - 1
            else:
                begin = mid + 1

        return -1