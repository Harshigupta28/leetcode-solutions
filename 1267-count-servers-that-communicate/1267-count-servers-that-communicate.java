class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // Har row aur column mein servers count karenge
        int[] row = new int[m];
        int[] col = new int[n];
        // Step 1: Har row aur column ka count nikalo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int count = 0;
        // Step 2: Check karo kaunsa server communicate kar sakta hai
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // Same row ya same column mein another server hona chahiye
                    if (row[i] > 1 || col[j] > 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}