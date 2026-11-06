import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int q = queries.length;
        int[] ans = new int[q];

        // Step 1: Logs ko time ke according sort karo
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        // Step 2: Query ke original indexes store karo
        Integer[] idx = new Integer[q];

        for (int i = 0; i < q; i++) {
            idx[i] = i;
        }

        // Queries ko ascending order mein process karenge
        Arrays.sort(idx, (a, b) -> queries[a] - queries[b]);

        // Server ki active requests count karenge
        int[] freq = new int[n + 1];

        int active = 0;
        int left = 0;
        int right = 0;

        // Step 3: Sorted queries process karo
        for (int i = 0; i < q; i++) {

            int time = queries[idx[i]];
            int start = time - x;

            // Window ke andar aane wale logs add karo
            while (right < logs.length && logs[right][1] <= time) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    active++;
                }

                freq[server]++;
                right++;
            }

            // Window se bahar jaane wale logs remove karo
            while (left < right && logs[left][1] < start) {

                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    active--;
                }

                left++;
            }

            // Total servers - active servers
            ans[idx[i]] = n - active;
        }

        return ans;
    }
}