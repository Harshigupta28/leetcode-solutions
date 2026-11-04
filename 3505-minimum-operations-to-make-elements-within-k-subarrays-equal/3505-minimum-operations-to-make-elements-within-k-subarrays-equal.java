
import java.util.*;

class Solution {

    class MedianWindow {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0, rightSize = 0;
        long sumL = 0, sumR = 0;

        void addMap(TreeMap<Integer, Integer> map, int val) {
            map.merge(val, 1, Integer::sum);
        }

        void removeMap(TreeMap<Integer, Integer> map, int val) {
            int c = map.get(val);
            if (c == 1) map.remove(val);
            else map.put(val, c - 1);
        }

        void add(int val) {
            if (leftSize == 0 || val <= left.lastKey()) {
                addMap(left, val);
                leftSize++;
                sumL += val;
            } else {
                addMap(right, val);
                rightSize++;
                sumR += val;
            }
            balance();
        }

        void remove(int val) {
            if (left.containsKey(val)) {
                removeMap(left, val);
                leftSize--;
                sumL -= val;
            } else {
                removeMap(right, val);
                rightSize--;
                sumR -= val;
            }
            balance();
        }

        void balance() {
            int target = (leftSize + rightSize + 1) / 2;

            while (leftSize > target) {
                int v = left.lastKey();
                removeMap(left, v);
                leftSize--;
                sumL -= v;

                addMap(right, v);
                rightSize++;
                sumR += v;
            }

            while (leftSize < target) {
                int v = right.firstKey();
                removeMap(right, v);
                rightSize--;
                sumR -= v;

                addMap(left, v);
                leftSize++;
                sumL += v;
            }
        }

        long getCost() {
            long median = left.lastKey();

            return median * leftSize - sumL
                 + sumR - median * rightSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int m = n - x + 1;
        long[] cost = new long[m];

        MedianWindow window = new MedianWindow();

        // Calculate first window
        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

        // Sliding window
        for (int i = x; i < n; i++) {
            window.remove(nums[i - x]);
            window.add(nums[i]);

            cost[i - x + 1] = window.getCost();
        }

        // DP
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {

                // Skip current element
                dp[j][i] = dp[j][i - 1];

                // Select a window ending at i-1
                if (i >= x && dp[j - 1][i - x] != INF) {

                    long take = dp[j - 1][i - x]
                              + cost[i - x];

                    dp[j][i] = Math.min(dp[j][i], take);
                }
            }
        }

        return dp[k][n];
    }
}
