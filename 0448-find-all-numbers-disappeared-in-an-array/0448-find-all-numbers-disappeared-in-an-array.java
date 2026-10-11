class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        boolean[] seen = new boolean[nums.length + 1];
        // present element ko true mark kregaa
        for(int i =0;i<nums.length;i++){
            seen[nums[i]] = true;
        }// missing number finding
        for(int i =1 ;i<=nums.length;i++){
            if(!seen[i]){
                ans.add(i);
            }
        } 
        return ans;
        
    }
}