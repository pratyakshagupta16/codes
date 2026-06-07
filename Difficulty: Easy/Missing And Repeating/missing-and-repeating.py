class Solution:
    def findTwoElement(self, arr):

        n = len(arr)
        freq = [0] * (n + 1)

        repeat = -1
        missing = -1

        for num in arr:
            freq[num] += 1

        for i in range(1, n + 1):
            if freq[i] == 2:
                repeat = i
            elif freq[i] == 0:
                missing = i

        return [repeat, missing]