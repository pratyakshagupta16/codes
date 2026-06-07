class Solution:
    def fullJustify(self, words, maxWidth):
        res = []
        i = 0

        while i < len(words):
            line = []
            length = 0

            while i < len(words) and length + len(words[i]) + len(line) <= maxWidth:
                line.append(words[i])
                length += len(words[i])
                i += 1

            spaces = maxWidth - length

            if i == len(words) or len(line) == 1:
                s = " ".join(line)
                s += " " * (maxWidth - len(s))
            else:
                gap = spaces // (len(line) - 1)
                extra = spaces % (len(line) - 1)

                s = ""

                for j in range(len(line) - 1):
                    s += line[j]
                    s += " " * gap

                    if extra > 0:
                        s += " "
                        extra -= 1

                s += line[-1]

            res.append(s)

        return res