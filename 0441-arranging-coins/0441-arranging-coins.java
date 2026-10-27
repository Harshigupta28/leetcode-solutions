class Solution {
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long coins = (long) mid * (mid + 1) / 2;

            if (coins == n) {
                return mid;
            } 
            else if (coins < n) {
                ans = mid;
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return ans;
    }
}