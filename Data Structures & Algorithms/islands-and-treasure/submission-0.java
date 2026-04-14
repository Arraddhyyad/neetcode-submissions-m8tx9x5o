class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> tres = new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0)
                    tres.offer(new int[]{i, j});
            }
        }

        int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!tres.isEmpty()){
            int[] curr = tres.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir: dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr<0 || nr == grid.length || nc<0 || nc == grid[0].length)
                    continue;
                if(grid[nr][nc]!=Integer.MAX_VALUE) continue;

                grid[nr][nc] = grid[r][c]+1;
                tres.offer(new int[]{nr, nc});
            }
        }
    }
}
