class Solution:
    def getSingle(self, arr):

        ans = 0

        for n in arr:
            ans ^= n

        return ans