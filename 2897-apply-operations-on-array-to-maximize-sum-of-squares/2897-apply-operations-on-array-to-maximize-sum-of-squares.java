import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bits = new int[31];

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);

            for (int j = 0; j < 31; j++) {
                if (((num >> j) & 1) == 1) {
                    bits[j]++;
                }
            }
        }

        long ans = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int j = 0; j < 31; j++) {
                if (bits[j] > 0) {
                    num |= (1L << j);
                    bits[j]--;
                }
            }

            ans = (ans + num * num) % mod;
        }

        return (int) ans;
    }
}
