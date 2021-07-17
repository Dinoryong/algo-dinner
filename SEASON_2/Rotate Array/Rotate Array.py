class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        x = k % len(nums)
        temp = [nums[i] for i in range(len(nums))]
        for i in range(len(nums)):
            nums[(i+k) % len(nums)] = temp[i]
