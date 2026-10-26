
class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Positive cell means unvisited land
                if (grid[i][j] > 0) {
                    long sum = dfs(grid, i, j, m, n);

                    // Check divisibility
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int i, int j,
                     int m, int n) {

        // Out of bounds or water/already visited
        if (i < 0 || j < 0 || i >= m || j >= n
                || grid[i][j] == 0) {
            return 0;
        }

        // Store current land value
        int value = grid[i][j];

        // Mark visited so we don't count it again
        grid[i][j] = 0;

        // Add current cell and its 4 neighbours
        long sum = value;

        sum += dfs(grid, i - 1, j, m, n); // Up
        sum += dfs(grid, i + 1, j, m, n); // Down
        sum += dfs(grid, i, j - 1, m, n); // Left
        sum += dfs(grid, i, j + 1, m, n); // Right

        return sum;
    }
}
