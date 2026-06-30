class Solution(object):
    def mostWordsFound(self, sentences):
        return max(len(s.split()) for s in sentences)