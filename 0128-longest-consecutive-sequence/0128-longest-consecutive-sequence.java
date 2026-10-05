import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Saare elements HashSet me daalo
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;

        // Unique elements ko check karo
        for(int x : set) {

            // Agar x-1 nahi hai, to x sequence ka starting point hai
            if(!set.contains(x - 1)) {

                int count = 1;
                int next = x + 1;

                // Aage ke consecutive numbers check karo
                while(set.contains(next)) {
                    count++;
                    next++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}