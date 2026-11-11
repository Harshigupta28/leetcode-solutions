class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        // Dono requirements ko Type 3 items se fulfill karna
        long both = (long) Math.max(need1, need2) * costBoth;

        // Dono requirements ke liye individual items lena
        long separate = (long) need1 * cost1
                      + (long) need2 * cost2;

        // Type 3 se jitni common requirement fulfill ho sakti hai
        long common = (long) Math.min(need1, need2) * costBoth;

        // Remaining requirements individual items se fulfill karna
        long mixed = common
                   + (long) (need1 - Math.min(need1, need2)) * cost1
                   + (long) (need2 - Math.min(need1, need2)) * cost2;

        // Minimum cost return karo
        return Math.min(both, Math.min(separate, mixed));
    }
}