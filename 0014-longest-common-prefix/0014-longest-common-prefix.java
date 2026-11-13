class Solution {
    public String longestCommonPrefix(String[] strs) {
        //phli string  ko prefix maan lenge
        String prefix = strs[0];
        //baaki ki string check kr rhe h
        for(int i =1;i<strs.length;i++){
             while (!strs[i].startsWith(prefix)) {

                // Prefix ka last character remove karenge
                prefix = prefix.substring(0, prefix.length() - 1);

                // Agar prefix empty ho gaya toh empty string return karo
                if (prefix.isEmpty()) {
                    return "";
                }
             }
              

        }
        return prefix;
    }
}