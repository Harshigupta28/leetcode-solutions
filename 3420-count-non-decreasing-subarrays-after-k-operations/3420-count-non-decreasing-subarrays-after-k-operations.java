
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int LOG = 32 - Integer.numberOfLeadingZeros(n);

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Find next greater element on the right
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int[][] jump = new int[LOG][n];
        long[][] cost = new long[LOG][n];
        boolean[][] valid = new boolean[LOG][n];

        // Build first jump and its operation cost
        for (int i = 0; i < n; i++) {
            jump[0][i] = nge[i];

            cost[0][i] = (long) nums[i] * (nge[i] - i)
                         - (prefix[nge[i]] - prefix[i]);

            valid[0][i] = true;
        }

        // Binary lifting preprocessing
        for (int p = 1; p < LOG; p++) {
            for (int i = 0; i < n; i++) {
                int mid = jump[p - 1][i];

                if (valid[p - 1][i] && mid < n && valid[p - 1][mid]) {
                    valid[p][i] = true;
                    jump[p][i] = jump[p - 1][mid];

                    cost[p][i] = cost[p - 1][i]
                               + cost[p - 1][mid];
                }
            }
        }

        long ans = 0;

        // Binary search maximum valid ending index for each start
        for (int l = 0; l < n; l++) {
            int low = l, high = n;

            while (low < high) {
                int r = low + (high - low) / 2;

                // Calculate minimum operations for [l, r]
                long operations = 0;
                int cur = l;

                for (int p = LOG - 1; p >= 0; p--) {
                    if (cur < n && valid[p][cur]
                            && jump[p][cur] <= r + 1) {

                        operations += cost[p][cur];
                        cur = jump[p][cur];
                    }
                }

                // Handle remaining partial block
                if (cur <= r) {
                    operations += (long) nums[cur] * (r - cur + 1)
                                - (prefix[r + 1] - prefix[cur]);
                }

                if (operations <= k) {
                    low = r + 1;
                } else {
                    high = r;
                }
            }

            // Count valid subarrays starting at l
            ans += low - l;
        }

        return ans;
    }
}
