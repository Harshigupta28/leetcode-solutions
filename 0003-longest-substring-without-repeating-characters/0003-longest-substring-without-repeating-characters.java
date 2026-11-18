import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // Remove duplicate characters
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add current character
            set.add(ch);
            // Update maximum length
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
