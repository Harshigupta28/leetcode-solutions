class Solution {
    static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long[] sum = new long[4 * n];
        long[] sq = new long[4 * n];
        long[] lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int left = last[nums[i]] + 1;

            update(1, 0, n - 1, left, i, sum, sq, lazy);

            ans = (ans + sq[1]) % MOD;
            last[nums[i]] = i;
        }

        return (int) ans;
    }

    void push(int node, int start, int end,
              long[] sum, long[] sq, long[] lazy) {
        if (lazy[node] == 0 || start == end) return;

        int mid = (start + end) / 2;
        int leftNode = node * 2;
        int rightNode = node * 2 + 1;

        apply(leftNode, mid - start + 1, lazy[node], sum, sq, lazy);
        apply(rightNode, end - mid, lazy[node], sum, sq, lazy);

        lazy[node] = 0;
    }

    void apply(int node, int len, long val,
               long[] sum, long[] sq, long[] lazy) {
        sq[node] = (sq[node] + 2 * val % MOD * sum[node] % MOD
                    + val * val % MOD * len % MOD) % MOD;

        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void update(int node, int start, int end, int l, int r,
                long[] sum, long[] sq, long[] lazy) {
        if (r < start || end < l) return;

        if (l <= start && end <= r) {
            apply(node, end - start + 1, 1, sum, sq, lazy);
            return;
        }

        push(node, start, end, sum, sq, lazy);

        int mid = (start + end) / 2;

        update(node * 2, start, mid, l, r, sum, sq, lazy);
        update(node * 2 + 1, mid + 1, end, l, r, sum, sq, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}