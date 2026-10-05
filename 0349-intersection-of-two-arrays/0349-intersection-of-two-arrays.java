import java.util.HashSet;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s = new HashSet<>();
        // nums1 k element store krne k liye
        for(int i =0 ;i<nums1.length;i++){
            s.add(nums1[i]);
        }// yaha common element check  honge
        HashSet<Integer> a = new HashSet<>();
        for(int i =0;i<nums2.length;i++){
            if(s.contains(nums2[i])){
                a.add(nums2[i]);
            }
        }// hashset ko arry m convert kro
        int r[] = new int[a.size()];
        Object[] arr = a.toArray();
        for(int i =0;i<a.size();i++){
             r[i] = (int) arr[i];

        } return r;

        
    }
}