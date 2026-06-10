class Solution(object):
    def maxProduct(self, nums):
        ans = max(nums)
        prefix = suffix = 1

        for i in range(len(nums)):
            prefix = (prefix or 1) * nums[i]
            suffix = (suffix or 1) * nums[len(nums)-1-i]

            ans = max(ans, prefix, suffix)

        return ans