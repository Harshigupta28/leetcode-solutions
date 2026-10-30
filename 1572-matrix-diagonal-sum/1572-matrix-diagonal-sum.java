class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i =0;i<mat.length;i++){
            // primary diagonal k sum
            sum += mat[i][i];
            //secoundary diagonal k sum
            sum += mat[i][mat.length-1-i];
        }// middle element ko do bar add na ho usko rokna
         if (mat.length % 2 == 1) {
            sum -= mat[mat.length / 2][mat.length / 2];
        }return sum;
        
    }
}