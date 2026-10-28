class Solution {
    public int specialArray(int[] nums) {
        int left =0;
        int right = nums.length;
        while(left<=right){
            int x = left +(right-left)/2;
            int count =0;

            for(int i =0;i<nums.length;i++){
                if(nums[i]>=x){
                    count++;
                }
            }
            if(count ==x ){
                return x;
            }else if(count > x){
                left = x+1;
            }else{
                right = x-1;
            }
        }
        return -1;
    }
}