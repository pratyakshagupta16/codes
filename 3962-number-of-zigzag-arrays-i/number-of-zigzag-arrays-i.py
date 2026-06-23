class Solution(object):
    def zigZagArrays(self, n, l, r):
        MOD = 10**9 + 7
        m = r - l + 1

        up = [i for i in range(m)]
        down = [m - 1 - i for i in range(m)]

        for _ in range(3, n + 1):
            new_up = [0] * m
            new_down = [0] * m

            s = 0
            for i in range(m):
                new_up[i] = s
                s = (s + down[i]) % MOD

            s = 0
            for i in range(m - 1, -1, -1):
                new_down[i] = s
                s = (s + up[i]) % MOD

            up, down = new_up, new_down

        return (sum(up) + sum(down)) % MOD