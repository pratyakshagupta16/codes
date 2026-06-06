import random

class RandomizedSet:

    def __init__(self):
        self.nums = []
        self.pos = {}

    def insert(self, val):
        if val in self.pos:
            return False

        self.nums.append(val)
        self.pos[val] = len(self.nums) - 1
        return True

    def remove(self, val):
        if val not in self.pos:
            return False

        idx = self.pos[val]
        last = self.nums[-1]

        self.nums[idx] = last
        self.pos[last] = idx

        self.nums.pop()
        del self.pos[val]

        return True

    def getRandom(self):
        return random.choice(self.nums)