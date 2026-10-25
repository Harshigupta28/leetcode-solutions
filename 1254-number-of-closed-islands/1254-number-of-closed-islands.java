class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Boundary se connected land ko remove karo
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0)
                dfs(grid, i, 0);

            if (grid[i][n - 1] == 0)
                dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0)
                dfs(grid, 0, j);

            if (grid[m - 1][j] == 0)
                dfs(grid, m - 1, j);
        }

        int count = 0;

        // Bachi hui land closed islands hain
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        // Boundary ya water check
        if (r < 0 || c < 0 || r >= m || c >= n
                || grid[r][c] == 1) {
            return;
        }

        // Visited mark
        grid[r][c] = 1;

        // 4 directions mein DFS
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}