class Solution:
    def plusOne(self, digits):
        num = int("".join(map(str, digits)))
        num += 1
        return(list(map(int, str(num))))