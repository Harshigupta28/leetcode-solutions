class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            // Increasing subarray
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            }
            // Decreasing subarray
            else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            }
            // Equal elements
            else {
                inc = 1;
                dec = 1;
            }
            // Maximum length update
            max = Math.max(max, Math.max(inc, dec));
        }
        return max;
    }
}