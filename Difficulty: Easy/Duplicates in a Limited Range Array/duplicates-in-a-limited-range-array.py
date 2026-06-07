class Solution:
    def findDuplicates(self, arr):

        freq = {}
        ans = []

        for num in arr:
            freq[num] = freq.get(num, 0) + 1

        for num in freq:
            if freq[num] == 2:
                ans.append(num)

        return ans