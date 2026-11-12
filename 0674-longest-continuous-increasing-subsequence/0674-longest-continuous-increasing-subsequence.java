class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int max = 1;
        for(int i =1 ; i<nums.length;i++){
           if( nums[i] > nums[i - 1]){
            count++;
           }
            // Increasing sequence break ho gayi
           else{
            count =1;
           }
           // Maximum length update karo
            max = Math.max(max, count);
        }return max;
        
    }
}