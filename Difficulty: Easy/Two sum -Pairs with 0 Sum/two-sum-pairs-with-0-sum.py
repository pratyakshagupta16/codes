class Solution:
    def getPairs(self, arr):

        s = set(arr)
        ans = []

        if arr.count(0) > 1:
            ans.append([0, 0])

        for num in s:
            if num > 0 and -num in s:
                ans.append([-num, num])

        ans.sort()
        return ans