class Solution {
    public int minOperations(int[] nums) {
        // Step 1: Find index of zero
        int zero =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                zero =i;
                break;
            }
        }
        // checkinng array is sorted or not
        boolean sorted = true;
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                sorted = false;
                break;
            }
        } if(sorted){
            return 0;
        }

        // Step 3: Check both directions
        int ans = Integer.MAX_VALUE;

        if (check(nums, zero, 1)) {
            ans = Math.min(ans, zero);
           ans = Math.min(ans, nums.length - zero + 2);
        }

        if (check(nums, zero, -1)) {
            ans = Math.min(ans, zero + 2);
           ans = Math.min(ans, nums.length - zero);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private boolean check(int[] nums, int zero, int step) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int prev = (zero + (i - 1) * step + n) % n;
            int curr = (zero + i * step + n) % n;

            if (nums[prev] > nums[curr]) {
                return false;
            }
        }

        return true;
        
            
    }
}