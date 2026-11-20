
import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;

        for (int x : nums) {

            int a = map.getOrDefault(x, 0) + 1;
            int b = map.getOrDefault(x - 1, 0) + 1;

            map.put(x, Math.max(map.getOrDefault(x, 0), b));

            map.put(x + 1, Math.max(map.getOrDefault(x + 1, 0), a));

            max = Math.max(max, Math.max(map.get(x), map.get(x + 1)));
        }

        return max;
    }
}
