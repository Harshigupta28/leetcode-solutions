class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // starting boundary set krta h
        stack.push(-1);
        //abhi tak valid substring ki maximum length 
        int maxLen = 0;
        for(int i =0 ; i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen = Math.max(maxLen, i - stack.peek());
                }

            }

        }return maxLen;

        
    }
}