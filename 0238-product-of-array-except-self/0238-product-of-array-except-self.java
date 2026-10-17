class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Left side ke elements ka product
        int product = 1;

        // Step 1: Left product calculate karna
        for (int i = 0; i < n; i++) {
            // Current index ke left ke elements ka product store karo
            answer[i] = product;
            // Current element ko product mein multiply karo
            product = product * nums[i];
        }

        // Right product dobara 1 se start karenge
        product = 1;

        // Step 2: Right se left traverse karna
        for (int i = n - 1; i >= 0; i--) {

            // Left product ko right product se multiply karo
            answer[i] = answer[i] * product;

            // Current element ko right product mein multiply karo
            product = product * nums[i];
        }
        return answer;
    }
}