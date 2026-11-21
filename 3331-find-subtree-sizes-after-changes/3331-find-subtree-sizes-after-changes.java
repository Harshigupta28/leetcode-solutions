
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        // Step 1: Build original tree
        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        // Step 2: Find new parents using DFS
        int[] newParent = new int[n];
        int[] last = new int[26];

        Arrays.fill(last, -1);

        int[] previous = new int[n];

        // Iterative DFS
        int[] stack = new int[2 * n + 1];
        int top = 0;

        stack[top++] = 0;

        while (top > 0) {

            int event = stack[--top];

            // Exit event
            if (event < 0) {
                int node = ~event;
                int c = s.charAt(node) - 'a';

                last[c] = previous[node];
                continue;
            }

            // Enter event
            int node = event;
            int c = s.charAt(node) - 'a';

            previous[node] = last[c];

            if (node == 0) {
                newParent[node] = -1;
            } else {
                if (last[c] != -1) {
                    newParent[node] = last[c];
                } else {
                    newParent[node] = parent[node];
                }
            }

            last[c] = node;

            stack[top++] = ~node;

            for (int child : children[node]) {
                stack[top++] = child;
            }
        }

        // Step 3: Build final tree
        List<Integer>[] newChildren = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }

        // Step 4: Get traversal order
        int[] order = new int[n];
        top = 0;

        int count = 0;
        stack[top++] = 0;

        while (top > 0) {
            int node = stack[--top];

            order[count++] = node;

            for (int child : newChildren[node]) {
                stack[top++] = child;
            }
        }

        // Step 5: Calculate subtree sizes
        int[] answer = new int[n];

        Arrays.fill(answer, 1);

        for (int i = n - 1; i > 0; i--) {
            int node = order[i];

            answer[newParent[node]] += answer[node];
        }

        return answer;
    }
}
