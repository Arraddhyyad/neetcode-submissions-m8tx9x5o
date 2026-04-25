class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O')
                dfs(r, 0, board, rows, cols);
            if (board[r][cols - 1] == 'O')
                dfs(r, cols - 1, board, rows, cols);
        }

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O')
                dfs(0, c, board, rows, cols);
            if (board[rows - 1][c] == 'O')
                dfs(rows - 1, c, board, rows, cols);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(int r, int c, char[][] board, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O')
            return;

        board[r][c] = '#';

        dfs(r + 1, c, board, rows, cols);
        dfs(r - 1, c, board, rows, cols);
        dfs(r, c + 1, board, rows, cols);
        dfs(r, c - 1, board, rows, cols);
    }
}