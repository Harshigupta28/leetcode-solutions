class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        // Step 1: Original index store karna
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        // Step 2: Decreasing order mein sort karna
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (arr[i][0] < arr[j][0]) {
                    int[] temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        // Step 3: Rank ke according answer store karna
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {

            int rank = i + 1;
            int originalIndex = arr[i][1];

            if (rank == 1) {
                ans[originalIndex] = "Gold Medal";
            } else if (rank == 2) {
                ans[originalIndex] = "Silver Medal";
            } else if (rank == 3) {
                ans[originalIndex] = "Bronze Medal";
            } else {
                ans[originalIndex] = String.valueOf(rank);
            }
        }

        return ans;
    }
}