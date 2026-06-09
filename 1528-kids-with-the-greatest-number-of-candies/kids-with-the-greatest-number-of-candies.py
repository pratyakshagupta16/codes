class Solution:
    def kidsWithCandies(self, candies, extraCandies):
        mx = max(candies)

        res = []

        for c in candies:
            res.append(c + extraCandies >= mx)

        return res