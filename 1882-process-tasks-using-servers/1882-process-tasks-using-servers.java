import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Free servers: weight ke according, tie hone par index
        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        );

        // Busy servers: available time, weight, index
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                if (a[1] != b[1]) return Long.compare(a[1], b[1]);
                return Long.compare(a[2], b[2]);
            }
        );

        // Initially saare servers free hain
        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        long time = 0;

        // Har task ko process karenge
        for (int i = 0; i < m; i++) {

            // Task ke arrival time se pehle process nahi kar sakte
            time = Math.max(time, i);

            // Jo servers free ho chuke hain unhe free heap mein daalo
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();

                free.offer(new int[]{(int) s[1], (int) s[2]});
            }

            // Agar koi server free nahi hai, toh wait karo
            if (free.isEmpty()) {

                time = busy.peek()[0];

                // Ek saath free hone wale saare servers release karo
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] s = busy.poll();

                    free.offer(new int[]{(int) s[1], (int) s[2]});
                }
            }

            // Minimum weight aur index wala server select karo
            int[] server = free.poll();

            int weight = server[0];
            int index = server[1];

            ans[i] = index;

            // Server ka next available time calculate karo
            busy.offer(new long[]{
                time + tasks[i],
                weight,
                index
            });
        }

        return ans;
    }
}