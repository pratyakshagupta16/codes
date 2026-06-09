class Solution:
    def maxVowels(self, s, k):
        vowels = set("aeiou")

        count = sum(c in vowels for c in s[:k])
        ans = count

        for i in range(k, len(s)):
            if s[i] in vowels:
                count += 1
            if s[i-k] in vowels:
                count -= 1

            ans = max(ans, count)

        return ans