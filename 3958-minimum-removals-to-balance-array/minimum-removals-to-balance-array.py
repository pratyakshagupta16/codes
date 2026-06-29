class Solution:
    def minRemoval(self, nums, k):
        nums.sort()

        left = 0
        max_keep = 0
        n = len(nums)

        for right in range(n):
            while nums[right] > nums[left] * k:
                left += 1

            max_keep = max(max_keep, right - left + 1)

        return n - max_keep