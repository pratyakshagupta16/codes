class Solution:
    def lastWordLen(self, s):
        return len(s.strip().split()[-1])
        