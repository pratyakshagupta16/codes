class Solution(object):
    def sumAndMultiply(self, s, queries):
        MOD = 10**9 + 7
        n = len(s)

        pow10 = [1] * (n + 1)
        for i in range(1, n + 1):
            pow10[i] = (pow10[i - 1] * 10) % MOD

        preSum = [0] * (n + 1)
        cnt = [0] * (n + 1)
        preVal = [0] * (n + 1)

        for i in range(n):
            d = int(s[i])
            preSum[i + 1] = preSum[i] + d
            cnt[i + 1] = cnt[i] + (d != 0)

            if d:
                preVal[i + 1] = (preVal[i] * 10 + d) % MOD
            else:
                preVal[i + 1] = preVal[i]

        ans = []

        for l, r in queries:
            digitSum = preSum[r + 1] - preSum[l]
            digits = cnt[r + 1] - cnt[l]
            x = (preVal[r + 1] - preVal[l] * pow10[digits]) % MOD
            ans.append((x * digitSum) % MOD)

        return ans