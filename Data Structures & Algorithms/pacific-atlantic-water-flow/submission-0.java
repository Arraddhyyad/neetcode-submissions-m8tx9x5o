class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) dfs(heights, pacific, i, 0, m, n);
        for (int j = 0; j < n; j++) dfs(heights, pacific, 0, j, m, n);

        for (int i = 0; i < m; i++) dfs(heights, atlantic, i, n-1, m, n);
        for (int j = 0; j < n; j++) dfs(heights, atlantic, m-1, j, m, n);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int m, int n) {
        visited[r][c] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr < 0 || nr == m || nc < 0 || nc == n) continue;
            if (visited[nr][nc]) continue;
            if (heights[nr][nc] < heights[r][c]) continue; 
            dfs(heights, visited, nr, nc, m, n);
        }
    }
}