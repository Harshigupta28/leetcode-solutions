class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result =  new ArrayList<>();
        for(int num = left;num<=right;num++){
            int  original = num;
            boolean isValid =  true;
            while(num>0){
                //last digit  nikal rhe h
                int digit = num % 10;
                // digit zero  ho y  original  pura divide  na hua ho  
                if(digit == 0|| original % digit!=0){
                    isValid = false;
                    break;
                }// last digit hata rhe h
                num = num/10;
            }
            if(isValid){
                result.add(original);
            }
            num = original;
        } 
        return result; 
    }
}