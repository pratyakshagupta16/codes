class Solution:
    def largest(self, arr):
        
        maxi = arr[0]
        
        for num in arr:
            if num > maxi:
                maxi = num
        
        return maxi