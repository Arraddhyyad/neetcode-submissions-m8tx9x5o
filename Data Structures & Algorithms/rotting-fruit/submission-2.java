class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rot = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) rot.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int mins = 0;

        while (!rot.isEmpty() && fresh > 0) {
            int size = rot.size();

            for (int i = 0; i < size; i++) {
                int[] curr = rot.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) continue;
                    if (grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    fresh--;
                    rot.offer(new int[]{nr, nc});
                }
            }

            mins++;
        }

        return fresh == 0 ? mins : -1;
    }
}