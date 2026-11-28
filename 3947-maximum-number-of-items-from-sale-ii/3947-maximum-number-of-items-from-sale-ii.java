
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Count how many items have each factor
        int[] freq = new int[n + 1];

        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // Calculate free-item gain for each factor
        int[] gain = new int[n + 1];

        for (int factor = 1; factor <= n; factor++) {

            for (int j = factor; j <= n; j += factor) {
                gain[factor] += freq[j];
            }

            // Exclude the item itself
            if (freq[factor] > 0) {
                gain[factor]--;
            }
        }

        // Store [price, number of boosted copies]
        List<int[]> deals = new ArrayList<>();

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            if (gain[factor] > 0 &&
                price < 2L * minPrice) {

                deals.add(new int[]{price, gain[factor]});
            }
        }

        // Cheapest boosted copies first
        deals.sort((a, b) -> Integer.compare(a[0], b[0]));

        long answer = 0;

        // Buy boosted copies
        for (int[] deal : deals) {

            int price = deal[0];
            int count = deal[1];

            int buy = Math.min(count, budget / price);

            answer += 2L * buy;
            budget -= buy * price;
        }

        // Spend remaining budget on cheapest normal copies
        answer += budget / minPrice;

        return (int) answer;
    }
}
