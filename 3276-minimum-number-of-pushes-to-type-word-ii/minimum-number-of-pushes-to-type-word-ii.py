class Solution:
    def minimumPushes(self, word):
        freq = {}

        for ch in word:
            freq[ch] = freq.get(ch, 0) + 1

        arr = sorted(freq.values(), reverse=True)

        ans = 0

        for i in range(len(arr)):
            ans += arr[i] * (i // 8 + 1)

        return ans