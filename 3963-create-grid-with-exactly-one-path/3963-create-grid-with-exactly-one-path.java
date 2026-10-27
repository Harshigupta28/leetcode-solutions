class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        //  Saare cells blocked
        for(int i =0; i<m;i++){
            for(int j =0;j<n;j++){
                grid[i][j] ='#';
            }
        }
        //  First row free
         for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }
        ////  Last column free
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        // char[][] ko String[] mein convert krna
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        return result;
    }
}