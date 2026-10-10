class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
        }

        if (sum <= k) {
            return 0;
        }

        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {
            high = Math.max(high, diff[i]);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            long need = 0;

            for (int i = 0; i < n; i++) {
                if (diff[i] > mid) {
                    need += diff[i] - mid;
                }
            }

            if (need <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int level = low;
        long used = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (diff[i] > level) {
                used += diff[i] - level;
            }

            long value = Math.min(diff[i], level);
            ans += value * value;
        }

        long remaining = k - used;
        ans -= remaining * (2L * level - 1);

        return ans;
    }
}