class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();

        // Dono strings ke last index
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        // Jab tak digits ya carry bacha hai
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            // Num1 ka digit add karo
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }

            // Num2 ka digit add karo
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }

            // Last digit answer mein add karo
            ans.append(sum % 10);

            // Carry calculate karo
            carry = sum / 10;
        }

        // Answer reverse karke return karo
        return ans.reverse().toString();
    }
}