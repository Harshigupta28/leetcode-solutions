class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        for(int  i =0;i<nums.size();i++){
            int sum =0;
            for(int j=i;j<nums.size();j++){
                //current elemsnt summ m  add krn rhe h
                sum += nums.get(j);
                //subarray ki length calculate
                int length = j - i + 1;
                //l or r k beech hi aaye  length
                if(length>=l && length<=r){
                    if(sum>0){
                        minSum = Math.min(minSum, sum);
                    }
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;      
    }
}