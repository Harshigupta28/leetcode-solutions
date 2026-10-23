class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k =-1;
        // check kr rhe h konsa kon apni position pe nhi h
        for(int i =0;i<n;i++){
            if(nums[i]!=i){
                if(k==-1){
                    k = nums[i];
                }else{
                    k = k& nums[i];
                }
            }
        }
        if(k ==-1){
            return 0;
        }
        return k;
    }
}