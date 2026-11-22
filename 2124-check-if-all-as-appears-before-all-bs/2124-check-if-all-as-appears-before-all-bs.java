class Solution {
    public boolean checkString(String s) {
        boolean seenb = false;
        for(int i =0;i<s.length();i++){
            // agr b mil gya too condition true hogi
            if(s.charAt(i) == 'b'){
                seenb = true;
            }
            if(s.charAt(i)== 'a' && seenb){
                return false;
            }
        }return true;

        
    }
}