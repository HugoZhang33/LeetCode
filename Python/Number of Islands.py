class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
            
        rows, cols = len(grid), len(grid[0])
        count = 0
        stack = []
        
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "0" or grid[i][j] == "2":
                    continue
                count += 1
                grid[i][j] = "2"
                stack.append((i, j))
                while stack:
                    r, c = stack.pop()
                    # look up
                    if r-1>=0 and grid[r-1][c]=="1":
                        stack.append((r-1, c))
                        grid[r-1][c] = "2"
                    # look right
                    if c+1<cols and grid[r][c+1]=="1":
                        stack.append((r, c+1))
                        grid[r][c+1] = "2"
                    # look down
                    if r+1<rows and grid[r+1][c]=="1":
                        stack.append((r+1, c))
                        grid[r+1][c] = "2"
                    # look left
                    if c-1>=0 and grid[r][c-1]=="1":
                        stack.append((r, c-1))
                        grid[r][c-1] = "2"
        return count
        
        