class Solution:
    def sumAndMultiply(self, n):
        s = str(n)

        x = ""
        total = 0

        for ch in s:
            if ch != '0':
                x += ch
                total += int(ch)

        if x == "":
            return 0

        return int(x) * total