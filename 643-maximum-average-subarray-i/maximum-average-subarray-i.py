class Solution:
    def findMaxAverage(self, nums, k):
        s = sum(nums[:k])
        mx = s

        for i in range(k, len(nums)):
            s += nums[i] - nums[i-k]
            mx = max(mx, s)

        return mx / float(k)