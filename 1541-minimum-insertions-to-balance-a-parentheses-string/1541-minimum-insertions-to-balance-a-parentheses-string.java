class Solution {
    public int minInsertions(String s) {

        int open = 0;
        int insertion = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open += 2;
                if (open % 2 == 1) {
                    insertion++;
                    open--;
                }
            } else {
                open--;

                if (open < 0) {
                    insertion++;
                    open = 1;
                }
            }
        }
        return insertion + open;
    }
}