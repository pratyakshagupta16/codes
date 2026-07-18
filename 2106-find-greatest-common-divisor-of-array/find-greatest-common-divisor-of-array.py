class Solution:
    def findGCD(self, nums):
        small = min(nums)
        large = max(nums)

        for i in range(small, 0, -1):
            if small % i == 0 and large % i == 0:
                return i