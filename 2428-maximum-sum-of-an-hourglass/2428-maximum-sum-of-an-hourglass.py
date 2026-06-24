class Solution:
    def maxSum(self, grid):
        rows = len(grid)
        cols = len(grid[0])
        ans = 0

        for i in range(rows - 2):
            for j in range(cols - 2):
                total = (
                    grid[i][j] + grid[i][j+1] + grid[i][j+2]
                    + grid[i+1][j+1]
                    + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2]
                )
                ans = max(ans, total)

        return ans