class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        ArrayList<Integer> a = new ArrayList<>(set1);
        ArrayList<Integer> b = new ArrayList<>(set2);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // nums1 mein hai, nums2 mein nahi
        for (int i = 0; i < a.size(); i++) {
            if (!set2.contains(a.get(i))) {
                list1.add(a.get(i));
            }
        }

        // nums2 mein hai, nums1 mein nahi
        for (int i = 0; i < b.size(); i++) {
            if (!set1.contains(b.get(i))) {
                list2.add(b.get(i));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(list1);
        ans.add(list2);

        return ans;
    }
}