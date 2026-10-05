import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while(n != 1) {

            int sum = 0;
            int temp = n;

            while(temp > 0) {
                int digit = temp % 10;
                sum = sum + digit * digit;
                temp = temp / 10;
            }

            if(set.contains(sum)) {
                return false;
            }

            set.add(sum);

            n = sum;
        }

        return true;
    }
}