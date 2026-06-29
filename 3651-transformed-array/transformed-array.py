class Solution:
    def constructTransformedArray(self, nums):
        n = len(nums)
        ans = [0] * n

        for i in range(n):
            if nums[i] == 0:
                ans[i] = 0
            else:
                ans[i] = nums[(i + nums[i]) % n]

        return ans