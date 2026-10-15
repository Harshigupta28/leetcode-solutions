class Solution {
    public int sumCounts(List<Integer> nums) {

        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int count = 0;

                for (int k = i; k <= j; k++) {
                    boolean duplicate = false;

                    for (int p = i; p < k; p++) {
                        if (nums.get(p).equals(nums.get(k))) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (!duplicate) {
                        count++;
                    }
                }

                ans += count * count;
            }
        }

        return ans;
    }
}