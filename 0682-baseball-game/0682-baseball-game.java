
import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];

            if (op.equals("C")) {
                scores.remove(scores.size() - 1);
            } else if (op.equals("D")) {
                int last = scores.get(scores.size() - 1);
                scores.add(last * 2);
            } else if (op.equals("+")) {
                int last = scores.get(scores.size() - 1);
                int secondLast = scores.get(scores.size() - 2);
                scores.add(last + secondLast);
            } else {
                scores.add(Integer.parseInt(op));
            }
        }

        int total = 0;

        for (int i = 0; i < scores.size(); i++) {
            total += scores.get(i);
        }

        return total;
    }
}
