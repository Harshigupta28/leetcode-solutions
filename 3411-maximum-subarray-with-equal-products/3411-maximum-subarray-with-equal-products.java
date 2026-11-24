import java.math.BigInteger;
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;  // Maximum valid subarray length
        // Starting index of subarray
        for (int i = 0; i < n; i++) {
            BigInteger prod = BigInteger.ONE; // Product
            BigInteger gcd = BigInteger.ZERO; // GCD
            BigInteger lcm = BigInteger.ONE;  // LCM
            // Ending index of subarray
            for (int j = i; j < n; j++) {
                // Convert array element into BigInteger
                BigInteger x = BigInteger.valueOf(nums[j]);
                // Calculate product of elements
                prod = prod.multiply(x);
                // Calculate GCD
                gcd = gcd.gcd(x);
                // Calculate LCM
                lcm = lcm.divide(lcm.gcd(x)).multiply(x);
                // Check product equivalent condition
                if (prod.equals(lcm.multiply(gcd))) {
                    // Update maximum length
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans; // Return longest valid subarray length
    }
}
