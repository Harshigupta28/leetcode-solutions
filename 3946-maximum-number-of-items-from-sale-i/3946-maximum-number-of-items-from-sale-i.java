class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

            int freeItems = 0;

            for (int j = 0; j < n; j++) {

                if (i != j && items[j][0] % factor == 0) {
                    freeItems++;
                }
            }

            // First copy: purchased + free items
            int benefit = 1 + freeItems;

            for (int j = budget; j >= price; j--) {

                dp[j] = Math.max(
                    dp[j],
                    dp[j - price] + benefit
                );
            }
        }

        int answer = 0;

        for (int cost = 0; cost <= budget; cost++) {

            int extraCopies = (budget - cost) / minPrice;

            int total = dp[cost] + extraCopies;

            answer = Math.max(answer, total);
        }

        return answer;
    }
}