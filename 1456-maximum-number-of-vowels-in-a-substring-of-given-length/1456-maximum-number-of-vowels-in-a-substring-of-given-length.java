class Solution {
    public int maxVowels(String s, int k) {
        int count =0;
        // first window bana rh h
        for(int i =0; i<k;i++){
            //checking character
            char ch = s.charAt(i);
            if(ch == 'a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
        } int maxCount = count;
        //sliding window
        for(int i = k;i<s.length();i++){
            // old charcter remove ho rha h jb window sslid kr rhi h
            char old = s.charAt(i-k);
            if (old == 'a' || old == 'e' || old == 'i' || old == 'o' || old == 'u') {
             count--;
            }
            // naya character  window m ayega ab
            char ch = s.charAt(i);
              if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
            // updat maximun
            maxCount = Math.max(maxCount, count); 
        } 
        return maxCount;
    }
}