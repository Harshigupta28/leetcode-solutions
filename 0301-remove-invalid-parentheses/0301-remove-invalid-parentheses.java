import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        int leftRemove = 0;
        int rightRemove = 0;

        // Find minimum number of brackets to remove
        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRemove++;
            }
            else if (c == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                }
                else {
                    rightRemove++;
                }
            }
        }

        solve(s, 0, leftRemove, rightRemove, 0, "", ans);

        return ans;
    }

    private void solve(
        String s,
        int index,
        int leftRemove,
        int rightRemove,
        int balance,
        String current,
        List<String> ans
    ) {

        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                if (!ans.contains(current)) {
                    ans.add(current);
                }
            }

            return;
        }

        char c = s.charAt(index);

        // REMOVE
        if (c == '(' && leftRemove > 0) {

            solve(
                s,
                index + 1,
                leftRemove - 1,
                rightRemove,
                balance,
                current,
                ans
            );
        }

        if (c == ')' && rightRemove > 0) {

            solve(
                s,
                index + 1,
                leftRemove,
                rightRemove - 1,
                balance,
                current,
                ans
            );
        }

        // KEEP

        if (c != '(' && c != ')') {

            solve(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance,
                current + c,
                ans
            );
        }

        else if (c == '(') {

            solve(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                current + c,
                ans
            );
        }

        else if (c == ')' && balance > 0) {

            solve(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance - 1,
                current + c,
                ans
            );
        }
    }
}