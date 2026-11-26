class Solution {
    public boolean canAliceWin(int n) {
        if(n<10){
            return false;
        }
        n= n-10;
        if(n<9){
            return true;
        }
        n = n-9;
        if(n<8){
            return false;
        }
        n = n-8;
        if(n<7){
            return true;
        }
        n = n - 7;
        if (n < 6) {
            return false;
        }
        n = n - 6;
        if (n < 5) {
            return true;
        }
        n = n - 5;
        if (n < 4) {
            return false;
        }
        n = n - 4;
        if (n < 3) {
            return true;
        }
        n = n - 3;
        if (n < 2) {
            return false;
        }
        n = n - 2;
        if (n < 1) {
            return true;
        }
        return false;
    }
}