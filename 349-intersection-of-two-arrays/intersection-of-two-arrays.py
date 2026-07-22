class Solution:
    def intersection(self, nums1, nums2):
        ans = []

        for i in nums1:
            for j in nums2:
                if i == j and i not in ans:
                    ans.append(i)

        return ans