class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++){
        for(int j=0; j<grid[0].length; j++){
            if(grid[i][j]==1){
                maxArea = Math.max(dfs(grid, i, j, 0), maxArea);
            }
                
        }
       } 
       return maxArea;
    }

    public int dfs(int[][]grid, int r, int c, int area){
        if(r<0 || r==grid.length || c<0 || c==grid[0].length || grid[r][c]==0)
            return 0;
        
       //if(grid[r][c]==1)
       //     area++;

        grid[r][c] = 0;

        return 1 + dfs(grid, r+1, c, area+1) + 
        dfs(grid, r-1, c, area+1) + 
        dfs(grid, r, c+1, area+1) + 
        dfs(grid, r, c-1, area+1);


    }
}
