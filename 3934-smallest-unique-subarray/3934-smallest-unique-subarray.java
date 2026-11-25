import java.util.*;
class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        // Binary Search ke liye range
        int low = 1;
        int high = n;
        // Jab tak search range bachi hai
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check karo ki mid length ka
            // koi unique subarray hai ya nahi
            if (check(nums, mid)) {
                // Unique mil gaya, ab chhoti length try karo
                high = mid - 1;
            } else {
                // Unique nahi mila, ab badi length try karo
                low = mid + 1;
            }
        }
        // Binary Search ke baad minimum valid length
        return low;
    }
    // Ye method check karega ki given length ka
    // koi subarray sirf ek baar aata hai ya nahi
    public boolean check(int[] nums, int len) {
        int n = nums.length;
        // Double Rolling Hash ke constants
        long base1 = 100019;
        long base2 = 100043;
        long mod1 = 1000000007;
        long mod2 = 1000000009;
        // HashMap mein subarray hash ki frequency store hogi
        HashMap<Long, Integer> map = new HashMap<>();
        // base^len calculate karna
        long power1 = 1;
        long power2 = 1;
        for (int i = 0; i < len; i++) {
            power1 = (power1 * base1) % mod1;
            power2 = (power2 * base2) % mod2;
        }
        // Pehle subarray ka hash calculate karo
        long hash1 = 0;
        long hash2 = 0;
        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * base1 + nums[i]) % mod1;
            hash2 = (hash2 * base2 + nums[i]) % mod2;
        }
        // Dono hashes ko combine karke ek key banao
        long key = hash1 * mod2 + hash2;
        // First subarray ki frequency 1 hai
        map.put(key, 1);
        // Ab sliding window se baaki subarrays check karo
        for (int i = len; i < n; i++) {
            // Window se purana element remove hoga
            int oldElement = nums[i - len];
            // Window mein naya element add hoga
            int newElement = nums[i];
            // First rolling hash update
            hash1 = (hash1 * base1
                    + newElement
                    - (oldElement * power1) % mod1
                    + mod1) % mod1;
            // Second rolling hash update
            hash2 = (hash2 * base2
                    + newElement
                    - (oldElement * power2) % mod2
                    + mod2) % mod2;
            // Updated hashes ko combine karo
            key = hash1 * mod2 + hash2;
            // HashMap mein frequency increase karo
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // Check karo ki koi hash exactly ek baar aaya hai
        for (int frequency : map.values()) {
            if (frequency == 1) {
                // Unique subarray mil gaya
                return true;
            }
        }
        // Koi unique subarray nahi mila
        return false;
    }
}
