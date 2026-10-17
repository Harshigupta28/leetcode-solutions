import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        // Step 1: Store number and digit sum
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;
        }

        // Step 2: Sort by digit sum, then by number
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // Step 3: Find each number's target position
        Map<Integer, Integer> position = new HashMap<>();

        for (int i = 0; i < n; i++) {
            position.put(nums[i], i);
        }

        int swaps = 0;

        // Step 4: Put each number in its correct position
        for (int i = 0; i < n; i++) {
            if (nums[i] != arr[i][0]) {
                swaps++;

                int correctIndex = position.get(arr[i][0]);

                position.put(nums[i], correctIndex);
                position.put(arr[i][0], i);

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        return swaps;
    }
}