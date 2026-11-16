class Solution {
    public int strStr(String haystack, String needle) {
        // Agar needle empty hai toh 0 return karo
        if (needle.length() == 0) {
            return 0;
        }
        // Haystack mein starting positions check karenge
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Inner loop ke baad j ki value check karni hai
            int j;
            // Needle ke characters compare karenge
            for (j = 0; j < needle.length(); j++) {

                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // Agar saare characters match ho gaye
            if (j == needle.length()) {
                return i;
            }
        }
        // Needle nahi mila
        return -1;
    }
}