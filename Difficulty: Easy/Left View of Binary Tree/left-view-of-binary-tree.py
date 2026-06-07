from collections import deque

class Solution:
    def leftView(self, root):

        if not root:
            return []

        ans = []
        q = deque([root])

        while q:

            n = len(q)

            for i in range(n):

                node = q.popleft()

                if i == 0:
                    ans.append(node.data)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

        return ans