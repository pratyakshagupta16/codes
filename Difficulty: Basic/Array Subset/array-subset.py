from collections import Counter

class Solution:
    def isSubset(self, a, b):

        freq = Counter(a)

        for num in b:
            if freq[num] == 0:
                return False
            freq[num] -= 1

        return True