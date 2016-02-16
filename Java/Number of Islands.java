public class Solution {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) 
            return 0;
            
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        Stack<int[]> stack = new Stack<int[]>();
        
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j]=='0' || grid[i][j]=='2') continue;
                count++;
                grid[i][j] = '2';
                int[] tmp = {i, j};
                stack.push(tmp);
                while (!stack.isEmpty()) {
                    int[] p = stack.pop();
                    int r = p[0];
                    int c = p[1];
                    
                    if (r-1>=0 && grid[r-1][c]=='1') {
                        grid[r-1][c] = '2';
                        int[] t = {r-1, c};
                        stack.push(t);
                    }
                    if (c-1>=0 && grid[r][c-1]=='1') {
                        grid[r][c-1] = '2';
                        int[] t = {r, c-1};
                        stack.push(t);
                    }
                    if (r+1<rows && grid[r+1][c]=='1') {
                        grid[r+1][c] = '2';
                        int[] t = {r+1, c};
                        stack.push(t);
                    }
                    if (c+1<cols && grid[r][c+1]=='1') {
                        grid[r][c+1] = '2';
                        int[] t = {r, c+1};
                        stack.push(t);
                    }    
                }
            }
        }
        
        return count;
    }
}