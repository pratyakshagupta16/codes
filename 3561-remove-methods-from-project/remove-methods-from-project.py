from collections import defaultdict, deque

class Solution:
    def remainingMethods(self, n, k, invocations):
        graph = defaultdict(list)
        for u, v in invocations:
            graph[u].append(v)
        
        # Step 1: Find all suspicious methods reachable from k
        suspicious = {k}
        queue = deque([k])
        
        while queue:
            u = queue.popleft()
            for v in graph[u]:
                if v not in suspicious:
                    suspicious.add(v)
                    queue.append(v)
        
        # Step 2: Check if any non-suspicious method points to a suspicious method
        safe_to_remove = True
        for u in range(n):
            if u not in suspicious:
                for v in graph[u]:
                    if v in suspicious:
                        safe_to_remove = False
                        break
            if not safe_to_remove:
                break
        
        # Step 3: Collect remaining methods
        if not safe_to_remove:
            return list(range(n))
        
        return [i for i in range(n) if i not in suspicious]