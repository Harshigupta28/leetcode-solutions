class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        //1st slidinng window
        for(int i =0;i<k;i++){
            sum +=arr[i];
        }
        int count = 0;
        // checking 1st window
        if(sum >= threshold*k){
            count++;
        }
        // window ko ab sslid krna h
        for(int i =k;i<arr.length;i++){
            // purana element remove + naya element add kr rhe h
            sum = sum - arr[i-k]+arr[i];
            // window checking
            if(sum>=threshold*k){
                count++;
            }
        
        } return count;
        
    }
}